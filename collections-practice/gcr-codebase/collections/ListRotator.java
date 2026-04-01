
import java.util.*;

public class ListRotator {

    public static <T> List<T> rotateLeft(List<T> list, int k) {
        int n = list.size();
        if (n == 0) {
            return list;
        }

        k = k % n;
        if (k == 0) {
            return list;
        }

        List<T> result = new ArrayList<>(n);
        result.addAll(list.subList(k, n));   // [30, 40, 50]
        result.addAll(list.subList(0, k));   // [10, 20]
        return result;
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(10, 20, 30, 40, 50);
        List<Integer> rotated = rotateLeft(input, 2);
        System.out.println(rotated); // [30, 40, 50, 10, 20]
    }
}
