
import java.util.*;

public class SetToSortedList {

    public static List<Integer> toSortedList(Set<Integer> set) {
        List<Integer> list = new ArrayList<>(set);  // convert to list
        Collections.sort(list);                     // sort ascending
        return list;
    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(5);
        set.add(3);
        set.add(9);
        set.add(1);

        List<Integer> sorted = toSortedList(set);
        System.out.println(sorted); // [1, 3, 5, 9]
    }
}
