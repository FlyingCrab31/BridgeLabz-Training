// Custom checked exception
class InvalidScoreException extends Exception {
    public InvalidScoreException(String message) {
        super(message);
    }
}




public class StudentScoreAnalyzer {

    // Validate all scores: must be between 0 and 100
    public static void validateScores(int[] scores) throws InvalidScoreException {
        for (int score : scores) {
            if (score < 0 || score > 100) {
                throw new InvalidScoreException("Invalid score: " + score +
                        ". Score must be between 0 and 100.");
            }
        }
    }

    public static double calculateAverage(int[] scores) {
        double sum = 0;
        for (int score : scores) {          // sum array elements
            sum += score;
        }
        return sum / scores.length;         // compute average
    }

    public static int findMax(int[] scores) {
        int max = scores[0];
        for (int score : scores) {          // loop to find max
            if (score > max) {
                max = score;
            }
        }
        return max;
    }

    public static int findMin(int[] scores) {
        int min = scores[0];
        for (int score : scores) {          // loop to find min
            if (score < min) {
                min = score;
            }
        }
        return min;
    }
}
class Main {
    public static void main(String[] args) {
        int[] scores = {85, 90, 76, 95, 60};

        try {
            StudentScoreAnalyzer.validateScores(scores);

            double avg = StudentScoreAnalyzer.calculateAverage(scores);
            int max = StudentScoreAnalyzer.findMax(scores);
            int min = StudentScoreAnalyzer.findMin(scores);

            System.out.println("Average score: " + avg);
            System.out.println("Highest score: " + max);
            System.out.println("Lowest score: " + min);

        } catch (InvalidScoreException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

