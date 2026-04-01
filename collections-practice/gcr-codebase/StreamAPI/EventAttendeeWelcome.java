
import java.util.Arrays;
import java.util.List;

public class EventAttendeeWelcome {

    public static void main(String[] args) {

        List<String> attendees = Arrays.asList(
                "Alice",
                "Bob",
                "Charlie",
                "David"
        );

        // Use forEach() with a lambda to print welcome messages
        attendees.forEach(name
                -> System.out.println("Welcome to the event, " + name + "!")
        );
    }
}
