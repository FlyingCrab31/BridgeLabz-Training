
import java.util.*;

public class RemoveDuplicates {

    public static <T> List<T> removeDuplicates(List<T> list) {
        Set<T> seen = new HashSet<>();
        List<T> result = new ArrayList<>();

        for (T element : list) {
            if (!seen.contains(element)) {
                seen.add(element);
                result.add(element);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(3, 1, 2, 2, 3, 4);
        List<Integer> output = removeDuplicates(input);
        System.out.println(output); // [3, 1, 2, 4]
    }
}
