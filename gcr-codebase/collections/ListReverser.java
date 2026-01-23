
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListReverser {

    // Generic method to reverse any List<T> in-place
    public static <T> void reverseList(List<T> list) {
        int start = 0;
        int end = list.size() - 1;

        while (start < end) {
            T temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        // Example with ArrayList
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        reverseList(arrayList);
        System.out.println("Reversed ArrayList: " + arrayList); // [5, 4, 3, 2, 1]

        // Example with LinkedList
        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        reverseList(linkedList);
        System.out.println("Reversed LinkedList: " + linkedList); // [5, 4, 3, 2, 1]
    }
}
