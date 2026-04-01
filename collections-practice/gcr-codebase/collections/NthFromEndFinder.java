
import java.util.LinkedList;
import java.util.ListIterator;

public class NthFromEndFinder {

    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be positive");
        }

        // Use iterators to simulate two pointers
        ListIterator<T> first = list.listIterator();
        ListIterator<T> second = list.listIterator();

        // Move 'first' n steps ahead
        for (int i = 0; i < n; i++) {
            if (!first.hasNext()) {
                throw new IllegalArgumentException("n is greater than list size");
            }
            first.next();
        }

        // Move both until 'first' reaches the end
        while (first.hasNext()) {
            first.next();
            second.next();
        }

        // 'second' is now at the Nth element from the end
        return second.next();
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        String result = findNthFromEnd(list, 2);
        System.out.println(result); // D
    }
}
