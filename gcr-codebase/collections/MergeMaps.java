
import java.util.*;

public class MergeMaps {

    public static Map<String, Integer> mergeWithSum(Map<String, Integer> m1,
            Map<String, Integer> m2) {
        Map<String, Integer> result = new HashMap<>(m1);

        for (Map.Entry<String, Integer> e : m2.entrySet()) {
            String key = e.getKey();
            Integer value = e.getValue();

            result.merge(key, value, Integer::sum);
        }

        return result;
    }

    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        Map<String, Integer> merged = mergeWithSum(map1, map2);
        System.out.println(merged); // {A=1, B=5, C=4}
    }
}
