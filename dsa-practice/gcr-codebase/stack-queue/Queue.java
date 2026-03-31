// Implementation of a Queue data structure using Stacks
import java.util.Stack;
public class Queue<T> {
    private final Stack<T> st1;
    private final Stack<T> st2;

    public Queue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    // Enqueue
    public void enqueue(T item) {
        st1.push(item);
    }

    // Dequeue
    public T dequeue() {
        shiftStacks();
        if (st2.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return st2.pop();
    }

    // Peek
    public T peek() {
        shiftStacks();
        if (st2.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return st2.peek();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return st1.isEmpty() && st2.isEmpty();
    }

    // method to shift elements from st1 to st2
    private void shiftStacks() {
        if (st2.isEmpty()) {
            while (!st1.isEmpty()) {
                st2.push(st1.pop());
            }
        }
    }
    // main method for testing
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue()); // Output: 1
        System.out.println(queue.peek());    // Output: 2
        System.out.println(queue.dequeue()); // Output: 2
        System.out.println(queue.isEmpty()); // Output: false
        System.out.println(queue.dequeue()); // Output: 3
        System.out.println(queue.isEmpty()); // Output: true
    }
}