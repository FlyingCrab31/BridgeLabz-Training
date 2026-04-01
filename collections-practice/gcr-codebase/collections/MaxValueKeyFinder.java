
import java.util.*;

public class MaxValueKeyFinder {

    public static String findKeyWithMaxValue(Map<String, Integer> map) {
        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() > maxValue) {
                maxValue = e.getValue();
                maxKey = e.getKey();
            }
        }
        return maxKey; // null if map is empty
    }

    public static void main(String[] args) {
        Map<String, Integer> input = new HashMap<>();
        input.put("A", 10);
        input.put("B", 20);
        input.put("C", 15);

        System.out.println(findKeyWithMaxValue(input)); // B
    }
}
