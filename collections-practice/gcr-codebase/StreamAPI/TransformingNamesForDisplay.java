
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TransformingNamesForDisplay {

    public static void main(String[] args) {

        List<String> customerNames = Arrays.asList(
                "alice",
                "Bob",
                "charlie",
                "david",
                "Eve"
        );

        List<String> upperCaseSortedNames = customerNames.stream()
                .map(String::toUpperCase) // convert to uppercase
                .sorted() // sort alphabetically
                .collect(Collectors.toList());

        upperCaseSortedNames.forEach(System.out::println);
    }
}
