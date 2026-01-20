package ExamProctor;

import java.util.HashMap;
import java.util.Map;

public class ExamSession {
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
