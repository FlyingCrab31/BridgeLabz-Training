package ExamProctor;

import java.util.Map;

public class ScoringFunctions {
    // basic scoring: +1 for correct, 0 for wrong/unanswered
    public static int calculateScore(Map<Integer, String> answers, AnswerKey key) {
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
