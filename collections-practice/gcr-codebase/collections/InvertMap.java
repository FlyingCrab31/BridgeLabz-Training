
import java.util.*;

public class InvertMap {

    public static <K, V> Map<V, List<K>> invert(Map<K, V> map) {
        Map<V, List<K>> inverted = new HashMap<>();

        for (Map.Entry<K, V> e : map.entrySet()) {
            K key = e.getKey();
            V value = e.getValue();

            inverted
                    .computeIfAbsent(value, k -> new ArrayList<>())
                    .add(key);
        }

        return inverted;
    }

    public static void main(String[] args) {
        Map<String, Integer> input = new HashMap<>();
        input.put("A", 1);
        input.put("B", 2);
        input.put("C", 1);

        Map<Integer, List<String>> result = invert(input);
        System.out.println(result); // {1=[A, C], 2=[B]}
    }
}
