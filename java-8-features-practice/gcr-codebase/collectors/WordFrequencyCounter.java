

/*Word Frequency Counter
○ Scenario: Analyze a paragraph for word occurrence.
○ Task: Use Collectors.toMap(). */
import java.util.*;
import java.util.stream.Collectors;
public class WordFrequencyCounter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Paragraph : ");
        String paragraph = sc.nextLine();

        //Convert Paragraph into word frequency Map

       Map<String, Integer> wordCountMap =
                Arrays.stream(paragraph.toLowerCase()
                        .replaceAll("[^a-zA-Z ]", "")
                        .split("\\s+"))
                        .filter(word -> !word.isEmpty())
                        .collect(Collectors.toMap(
                                word -> word,     // key mapper
                                word -> 1,        // value mapper
                                Integer::sum      // merge function
                        ));

                        //Display result 
        System.out.println("\nWord Occurences : ");
        wordCountMap.forEach((word, count) ->
                System.out.println(word + " -> " + count)
        );
       
    }

    
}
