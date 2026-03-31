public class EduQuizGrader {

    public static void main(String[] args) {
        // Correct answers for 10 questions
        String[] correctAnswers = {
            "A", "B", "C", "D", "A",
            "B", "C", "D", "A", "B"
        };

        // Example student answers (normally you would read from Scanner)
        String[] studentAnswers = {
            "a", "b", "X", "d", "A",
            "b", "c", "y", "A", "b"
        };

        int score = calculateScore(correctAnswers, studentAnswers);
        int totalQuestions = correctAnswers.length;
        double percentage = (score * 100.0) / totalQuestions;

        System.out.println("\nTotal correct: " + score + "/" + totalQuestions);
        System.out.println("Percentage: " + percentage + "%");

        if (percentage >= 40) { // you can change pass criteria
            System.out.println("Result: PASS");
        } else {
            System.out.println("Result: FAIL");
        }
    }

    // Returns number of correct answers and prints detailed feedback
    public static int calculateScore(String[] correct, String[] student) {
        int correctCount = 0;

        for (int i = 0; i < correct.length; i++) {
            String correctAns = correct[i];
            String studentAns = student[i];

            boolean isCorrect = correctAns.equalsIgnoreCase(studentAns); // case-insensitive

            if (isCorrect) {
                correctCount++;
                System.out.println("Question " + (i + 1) + ": Correct");
            } else {
                System.out.println("Question " + (i + 1) + ": Incorrect"
                        + " (Correct: " + correctAns + ", Your answer: " + studentAns + ")");
            }
        }

        return correctCount;
    }
}
