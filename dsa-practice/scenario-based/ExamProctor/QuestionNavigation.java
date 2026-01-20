package ExamProctor;

import java.util.Stack;

public class QuestionNavigation {
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
