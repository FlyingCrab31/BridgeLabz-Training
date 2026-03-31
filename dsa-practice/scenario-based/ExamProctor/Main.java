package ExamProctor;

public class Main {
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
