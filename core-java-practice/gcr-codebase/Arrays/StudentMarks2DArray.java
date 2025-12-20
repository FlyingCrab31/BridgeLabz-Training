import java.util.Scanner;

class StudentMarks2DArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 1. Take input for number of students
        System.out.print("Enter number of students: ");
        int n = input.nextInt();

        if (n <= 0) {
            System.err.println("Invalid number of students.");
            input.close();
            return;
        }

        // 2. Create 2D array for marks and arrays for percent and grade
        int[][] marks = new int[n][3];      // 0: Phy, 1: Chem, 2: Math
        double[] percent = new double[n];
        char[] grade = new char[n];

        // 3. Take input for marks with validation
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter marks for student " + (i + 1));

            System.out.print("Physics: ");
            int p = input.nextInt();
            System.out.print("Chemistry: ");
            int c = input.nextInt();
            System.out.print("Maths: ");
            int m = input.nextInt();

            if (p < 0 || c < 0 || m < 0) {
                System.err.println("Marks cannot be negative. Enter again.");
                i--;           // decrement index as per hint
                continue;
            }

            marks[i][0] = p;
            marks[i][1] = c;
            marks[i][2] = m;
        }

        // 4. Calculate percentage and grade of the students
        for (int i = 0; i < n; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            percent[i] = (total / 300.0) * 100.0;

            if (percent[i] >= 90) {
                grade[i] = 'A';
            } else if (percent[i] >= 80) {
                grade[i] = 'B';
            } else if (percent[i] >= 70) {
                grade[i] = 'C';
            } else if (percent[i] >= 60) {
                grade[i] = 'D';
            } else {
                grade[i] = 'F';
            }
        }

        // 5. Display marks, percentages, and grades of each student
        System.out.println("\nStudent\tPhy\tChem\tMath\tPercent\tGrade");
        for (int i = 0; i < n; i++) {
            System.out.printf(
                "%d\t%d\t%d\t%d\t%.2f\t%c%n",
                (i + 1),
                marks[i][0],
                marks[i][1],
                marks[i][2],
                percent[i],
                grade[i]
            );
        }

        input.close();
    }
}
