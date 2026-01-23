
import java.util.PriorityQueue;

class Patient {

    private String name;
    private int severity; // higher = more severe

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    public String getName() {
        return name;
    }

    public int getSeverity() {
        return severity;
    }

    @Override
    public String toString() {
        return name + " (severity=" + severity + ")";
    }
}

public class HospitalTriage {

    public static void main(String[] args) {
        PriorityQueue<Patient> triageQueue
                = new PriorityQueue<>((p1, p2) -> Integer.compare(p2.getSeverity(), p1.getSeverity()));

        triageQueue.add(new Patient("John", 3));
        triageQueue.add(new Patient("Alice", 5));
        triageQueue.add(new Patient("Bob", 2));

        System.out.println("Treatment order:");
        while (!triageQueue.isEmpty()) {
            System.out.println(triageQueue.remove());
        }
        // Alice (5), John (3), Bob (2)
    }
}
