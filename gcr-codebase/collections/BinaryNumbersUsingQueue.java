
import java.util.LinkedList;
import java.util.Queue;

public class BinaryNumbersUsingQueue {

    public static void generateBinary(int n) {
        if (n <= 0) {
            return;
        }

        Queue<String> q = new LinkedList<>();
        q.add("1");

        for (int i = 0; i < n; i++) {
            String s = q.remove();
            System.out.print(s + " ");

            q.add(s + "0");
            q.add(s + "1");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.print("First " + n + " binary numbers: ");
        generateBinary(n); // 1 10 11 100 101
    }
}
