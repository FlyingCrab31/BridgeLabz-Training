import java.util.Scanner;

class Line implements Comparable<Line> {

    private double length;

    Line(double x1, double y1, double x2, double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        this.length = Math.sqrt(dx * dx + dy * dy);  // UC1: length
    }

    double getLength() {
        return length;
    }

    // UC2: check equality of two lines
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Line)) return false;
        Line other = (Line) obj;
        // here other.length is pointing to the length of the other line which is passed as an argument.
        return Math.abs(this.length - other.length) < 1e-6;
    }

    // UC3: compare two lines
    @Override
    public int compareTo(Line other) {
        double diff = this.length - other.length;
        if (Math.abs(diff) < 1e-6) return 0;
        return diff > 0 ? 1 : -1;
    }
}

public class LineComparisonComputation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Line 1 (x1 y1 x2 y2):");
        Line l1 = new Line(sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble());

        System.out.println("Enter Line 2 (x1 y1 x2 y2):");
        Line l2 = new Line(sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble());

        System.out.println("Length of Line 1: " + l1.getLength());
        System.out.println("Length of Line 2: " + l2.getLength());

        // UC2
        if (l1.equals(l2)) {
            System.out.println("Line 1 and Line 2 are equal in length.");
        } else {
            System.out.println("Line 1 and Line 2 are NOT equal in length.");
        }

        // UC3
        int cmp = l1.compareTo(l2);
        if (cmp == 0) {
            System.out.println("Line 1 is equal to Line 2.");
        } else if (cmp > 0) {
            System.out.println("Line 1 is greater than Line 2.");
        } else {
            System.out.println("Line 1 is less than Line 2.");
        }

        sc.close();
    }
}
