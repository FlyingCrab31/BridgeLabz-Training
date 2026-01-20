package ExamProctor;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
