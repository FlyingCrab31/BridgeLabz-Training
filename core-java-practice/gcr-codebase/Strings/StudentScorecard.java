import java.util.Random;

public class StudentScorecard {

    public static int[][] generateMarks(int students) {
        Random rand = new Random();
        int[][] marks = new int[students][3]; // 0:Phy, 1:Chem, 2:Math
        for (int i = 0; i < students; i++) {
            for (int j = 0; j < 3; j++) {
                marks[i][j] = rand.nextInt(90) + 10; // 10–99
            }
        }
        return marks;
    }

    public static double[][] calculateStats(int[][] marks) {
        int n = marks.length;
        double[][] stats = new double[n][3]; // total, avg, percent
        for (int i = 0; i < n; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            double avg = total / 3.0;
            double percent = avg; // each subject out of 100
            stats[i][0] = total;
            stats[i][1] = Math.round(avg * 100.0) / 100.0;
            stats[i][2] = Math.round(percent * 100.0) / 100.0;
        }
        return stats;
    }

    public static char[] calculateGrades(double[][] stats) {
        int n = stats.length;
        char[] grades = new char[n];
        for (int i = 0; i < n; i++) {
            double p = stats[i][2];
            if (p >= 80) grades[i] = 'A';
            else if (p >= 70) grades[i] = 'B';
            else if (p >= 60) grades[i] = 'C';
            else if (p >= 50) grades[i] = 'D';
            else if (p >= 40) grades[i] = 'E';
            else grades[i] = 'R';
        }
        return grades;
    }

    public static void printScorecard(int[][] marks, double[][] stats, char[] grades) {
        System.out.printf("%-10s%-8s%-8s%-8s%-8s%-10s%-12s%-8s%n",
                "Student", "Phy", "Chem", "Math", "Total", "Average", "Percent", "Grade");
        for (int i = 0; i < marks.length; i++) {
            System.out.printf("%-10d%-8d%-8d%-8d%-8.0f%-10.2f%-12.2f%-8c%n",
                    (i + 1),
                    marks[i][0], marks[i][1], marks[i][2],
                    stats[i][0], stats[i][1], stats[i][2], grades[i]);
        }
    }

    public static void main(String[] args) {
        int students = 5; // or take input
        int[][] marks = generateMarks(students);
        double[][] stats = calculateStats(marks);
        char[] grades = calculateGrades(stats);
        printScorecard(marks, stats, grades);
    }
}
