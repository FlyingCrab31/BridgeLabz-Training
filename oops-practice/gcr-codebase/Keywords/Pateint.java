class Patient {

    // 1. Static
    static String hospitalName = "City Care Hospital";   // shared among all patients
    private static int totalPatients = 0;                // counts total admitted patients

    public static int getTotalPatients() {
        return totalPatients;
    }

    // 3. Final
    private final int patientID;     // unique, cannot be changed

    // Instance fields
    private String name;
    private int age;
    private String ailment;

    // 2. This in constructor
    public Patient(String name, int age, String ailment, int patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;  // final initialized once
        totalPatients++;             // increase count whenever a patient is created
    }

    // Method to display patient details
    public void displayDetails() {
        System.out.println("Hospital Name: " + hospitalName);
        System.out.println("Patient ID: " + patientID);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Ailment: " + ailment);
        System.out.println("-----------------------------");
    }

    // 4. instanceof usage
    public static void showDetailsIfPatient(Object obj) {
        if (obj instanceof Patient) {         // check before using
            Patient p = (Patient) obj;        // safe cast
            System.out.println("Object is a Patient. Showing details:");
            p.displayDetails();
        } else {
            System.out.println("Given object is not a Patient. Cannot show details.");
        }
    }

    public static void main(String[] args) {

        // Create Patient objects
        Patient p1 = new Patient("Rahul Kumar", 30, "Fever", 1001);
        Patient p2 = new Patient("Priya Singh", 25, "Fracture", 1002);

        // Display details directly
        p1.displayDetails();
        p2.displayDetails();

        // Show total patients using static method
        System.out.println("Total patients admitted: " + Patient.getTotalPatients());

        // instanceof usage
        showDetailsIfPatient(p1);               // valid Patient
        showDetailsIfPatient("Not a patient");  // not Patient
    }
}
