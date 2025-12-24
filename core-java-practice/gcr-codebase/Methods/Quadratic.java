import java.util.Scanner;

public class Quadratic {

    // returns array: 0/1/2 roots depending on delta
    public static double[] findRoots(double a, double b, double c) {
        double delta = b * b - 4 * a * c;

        if (delta > 0) {
            double root1 = (-b + Math.sqrt(delta)) / (2 * a);
            double root2 = (-b - Math.sqrt(delta)) / (2 * a);
            return new double[]{root1, root2};
        } else if (delta == 0) {
            double root = -b / (2 * a);
            return new double[]{root};
        } else {
            // delta < 0 -> no real roots
            return new double[0];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter coefficient a: ");
        double a = sc.nextDouble();
        System.out.print("Enter coefficient b: ");
        double b = sc.nextDouble();
        System.out.print("Enter coefficient c: ");
        double c = sc.nextDouble();

        double[] roots = findRoots(a, b, c);

        switch (roots.length) {
            case 2 -> {
                System.out.println("Two real roots:");
                System.out.println("x1 = " + roots[0]);
                System.out.println("x2 = " + roots[1]);
            }
            case 1 -> {
                System.out.println("One real root:");
                System.out.println("x = " + roots[0]);
            }
            default -> System.out.println("No real roots (delta < 0).");
        }

        sc.close();
    }
}
