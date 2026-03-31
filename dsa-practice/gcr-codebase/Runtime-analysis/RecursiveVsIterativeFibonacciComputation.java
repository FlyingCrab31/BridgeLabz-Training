
public class RecursiveVsIterativeFibonacciComputation {

    public static int fiboRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fiboRecursive(n - 1) + fiboRecursive(n - 2);

    }

    public static int fiboIterative(int n) {
        if (n <= 1) {
            return n;
        }

        int a = 0, b = 1, sum = 0;

        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;

    }

    public static void test(int n) {
        System.out.println("Fibonacci n= " + n);

        if (n <= 40) {
            long startRec = System.currentTimeMillis();
            int fiboRec = fiboRecursive(n);
            long endRec = System.currentTimeMillis();

            System.out.println("Recursive result: " + fiboRec);
            System.out.println("Recursive time: " + (endRec - startRec) + " ms");

        } else {
            System.out.println("Recursive time: skipped(too slow)");
        }

        long startIter = System.currentTimeMillis();
        int fiboIter = fiboIterative(n);
        long endIter = System.currentTimeMillis();

        System.out.println("Iterative result: " + fiboIter);
        System.out.println("Iterative time: " + (endIter - startIter) + " ms");
        System.out.println();

    }

    public static void main(String args[]) {
        System.out.println("Recursive vs iterative fibonacci");
        test(10);
        test(20);
        test(30);
        test(40);
        test(50);
    }
}
