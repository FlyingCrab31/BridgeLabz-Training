
import java.util.HashSet;
import java.util.Set;

public class SymmetricDifference {

    public static <T> Set<T> symmetricDifference(Set<T> set1, Set<T> set2) {
        // union
        Set<T> union = new HashSet<>(set1);
        union.addAll(set2);

        // intersection
        Set<T> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        // union - intersection
        union.removeAll(intersection);
        return union;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = Set.of(1, 2, 3);
        Set<Integer> set2 = Set.of(3, 4, 5);

        System.out.println(symmetricDifference(set1, set2)); // [1, 2, 4, 5]
    }
}
