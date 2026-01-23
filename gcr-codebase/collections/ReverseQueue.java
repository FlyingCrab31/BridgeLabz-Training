
import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {

    public static <T> void reverse(Queue<T> q) {
        if (q.isEmpty()) {
            return;
        }
        T front = q.remove();          // dequeue
        reverse(q);                    // reverse remaining
        q.add(front);                  // enqueue at the end
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);

        System.out.println("Original: " + q); // [10, 20, 30]
        reverse(q);
        System.out.println("Reversed: " + q); // [30, 20, 10]
    }
}
