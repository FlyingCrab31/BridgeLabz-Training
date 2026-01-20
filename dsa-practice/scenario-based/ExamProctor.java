
import java.util.*;

class QuestionNavigation {

    private final Stack<Integer> navStack = new Stack<>();

    public void visit(int questionId) {
        navStack.push(questionId);
    }

    public Integer goBack() {
        if (navStack.size() <= 1) {
            return navStack.peek(); // cannot go back further
        }
        navStack.pop();             // remove current
        return navStack.peek();     // previous becomes current
    }

    public Integer getCurrent() {
        return navStack.isEmpty() ? null : navStack.peek();
    }
}

class AnswerKey {

    private final Map<Integer, String> key = new HashMap<>();

    public void addCorrectAnswer(int qId, String ans) {
        key.put(qId, ans);
    }

    public String getCorrectAnswer(int qId) {
        return key.get(qId);
    }

    public Set<Integer> getAllQuestionIds() {
        return key.keySet();
    }
}

class ExamSession {

    private final Map<Integer, String> answers = new HashMap<>();
    private final QuestionNavigation navigation = new QuestionNavigation();

    public ExamSession(int firstQuestionId) {
        navigation.visit(firstQuestionId);
    }

    public void visitQuestion(int qId) {
        navigation.visit(qId);
    }

    public void answerCurrent(String ans) {
        Integer qId = navigation.getCurrent();
        if (qId != null) {
            answers.put(qId, ans); // store/update answer
        }
    }

    public void back() {
        Integer qId = navigation.goBack();
        System.out.println("Moved back to question: " + qId);
    }

    public int submit(AnswerKey key) {
        return ScoringFunctions.calculateScore(answers, key);
    }
}

class ScoringFunctions {

    // basic scoring: +1 for correct, 0 for wrong/unanswered
    public static int calculateScore(Map<Integer, String> answers,
            AnswerKey key) {
        int score = 0;
        for (Integer qId : key.getAllQuestionIds()) {
            String correct = key.getCorrectAnswer(qId);
            String given = answers.get(qId);
            if (correct != null && correct.equalsIgnoreCase(given)) {
                score++;
            }
        }
        return score;
    }

    // extended scoring with negative marking
    public static int calculateScoreWithNegative(Map<Integer, String> answers,
            AnswerKey key,
            int correctMarks,
            int wrongPenalty) {
        int score = 0;
        for (Integer qId : key.getAllQuestionIds()) {
            String correct = key.getCorrectAnswer(qId);
            String given = answers.get(qId);
            if (given == null) {
                continue; // not attempted

            }
            if (correct.equalsIgnoreCase(given)) {
                score += correctMarks;
            } else {
                score -= wrongPenalty;
            }
        }
        return score;
    }
}

public class ExamProctor {

    public static void main(String[] args) {
        AnswerKey key = new AnswerKey();
        key.addCorrectAnswer(1, "A");
        key.addCorrectAnswer(2, "C");
        key.addCorrectAnswer(3, "B");

        ExamSession session = new ExamSession(1);
        session.answerCurrent("A");

        session.visitQuestion(2);
        session.answerCurrent("B"); // wrong

        session.visitQuestion(3);
        session.answerCurrent("B"); // correct

        session.back(); // goes back to Q2 if needed for review

        int score = session.submit(key);
        System.out.println("Final score: " + score);
    }
}
