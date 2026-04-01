
import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues<T> {

    private Queue<T> q1 = new LinkedList<>();
    private Queue<T> q2 = new LinkedList<>();

    public void push(T x) {
        // Step 1: enqueue a new element into q2
        q2.add(x);

        // Step 2: move all elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        // Step 3: swap q1 and q2
        Queue<T> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public T pop() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return q1.remove();
    }

    public T top() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return q1.peek();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues<Integer> stack = new StackUsingQueues<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop()); // 3
        System.out.println(stack.top()); // 2
        System.out.println(stack.pop()); // 2
        System.out.println(stack.pop()); // 1
    }
}
