
import java.util.*;

public class FrequencyCounter {

    public static Map<String, Integer> findFrequency(List<String> items) {
        Map<String, Integer> freqMap = new HashMap<>();

        for (String item : items) {
            freqMap.put(item, freqMap.getOrDefault(item, 0) + 1);
        }

        return freqMap;
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList("apple", "banana", "apple", "orange");
        Map<String, Integer> result = findFrequency(input);
        System.out.println(result); // {apple=2, banana=1, orange=1}
    }
}
