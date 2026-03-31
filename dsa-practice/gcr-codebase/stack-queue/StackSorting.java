// Sort a stack using recursion in ascendending order

import java.util.Stack;

public class StackSorting {

    // Method to sort a stack
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop();
            sortStack(stack);
            insertInSortedOrder(stack, top);
        }
    }

    //method to insert an element in sorted order
    private static void insertInSortedOrder(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
        } else {
            int top = stack.pop();
            insertInSortedOrder(stack, element);
            stack.push(top);
        }
    }

    // Main method
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);

        System.out.println("Original Stack: " + stack);
        sortStack(stack);
        System.out.println("Sorted Stack: " + stack);
    }
}
