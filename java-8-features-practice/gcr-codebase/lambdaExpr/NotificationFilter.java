
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Alert {

    private final String type;      // e.g. "CRITICAL", "LAB", "REMINDER"
    private final String message;
    private final boolean critical;
    private final boolean fromAssignedDoctor;

    public Alert(String type, String message,
            boolean critical, boolean fromAssignedDoctor) {
        this.type = type;
        this.message = message;
        this.critical = critical;
        this.fromAssignedDoctor = fromAssignedDoctor;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public boolean isCritical() {
        return critical;
    }

    public boolean isFromAssignedDoctor() {
        return fromAssignedDoctor;
    }

    @Override
    public String toString() {
        return "[" + type + ", critical=" + critical
                + ", fromDoctor=" + fromAssignedDoctor
                + "] " + message;
    }
}

public class NotificationFilter {

    public static void main(String[] args) {
        List<Alert> list = Arrays.asList(
                new Alert("Critical", "Low Oxygen Level", true, true),
                new Alert("LAB", "Blood test report available", false, true),
                new Alert("REMINDER", "Take evening medicine", false, false),
                new Alert("INFO", "New health tips available", false, false));

        Predicate<Alert> criticalOnly = Alert::isCritical;
        Predicate<Alert> fromDocOnly = Alert::isFromAssignedDoctor;
        Predicate<Alert> CriticalorDoctor = criticalOnly.or(fromDocOnly);
        List<Alert> filtered = list.stream()
                .filter(CriticalorDoctor)
                .collect(Collectors.toList());
        System.out.println("Filtered Alerts for user : ");
        filtered.forEach(System.out::println);

    }
}
