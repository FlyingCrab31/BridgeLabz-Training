
import java.util.Arrays;
import java.util.List;

class Patient {

    private final String id;
    private final String name;

    public Patient(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

public class PatientIdPrinting {

    public static void main(String[] args) {
        List<Patient> patients = Arrays.asList(
                new Patient("PID-2001", "Ravi"),
                new Patient("PID-2002", "Sita"),
                new Patient("PID-2003", "Aman")
        );

        // 1) print only IDs using a custom method + method reference
        patients.stream()
                .map(Patient::getId) // method reference to getter
                .forEach(System.out::println); // method reference to println
    }
}
