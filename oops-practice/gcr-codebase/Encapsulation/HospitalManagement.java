import java.util.ArrayList;
import java.util.List;

interface MedicalRecord {

    void addRecord(String record);
    List<String> viewRecords();
}
abstract class Patient {
    
    private final String patientId;
    final private String name;
    final private int age;

    // (encapsulation)
    private String diagnosis;
    private String medicalHistory;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // Abstract method for polymorphic billing
    public abstract double calculateBill();

    // Concrete method
    public String getPatientDetails() {
        return "Patient ID: " + patientId +
               ", Name: " + name +
               ", Age: " + age;
    }

    // Encapsulated getters
    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Sensitive fields with controlled access
    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        // You can add validation / authorization checks here
        this.diagnosis = diagnosis;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        // You can add validation / authorization checks here
        this.medicalHistory = medicalHistory;
    }
}

class InPatient extends Patient implements MedicalRecord {

    final private int daysAdmitted;
    final private double roomChargePerDay;
    final private double treatmentCost;

    private List<String> records = new ArrayList<>();

    public InPatient(String patientId, String name, int age,
                     int daysAdmitted, double roomChargePerDay, double treatmentCost) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.roomChargePerDay = roomChargePerDay;
        this.treatmentCost = treatmentCost;
    }

    @Override
    public double calculateBill() {
        return (daysAdmitted * roomChargePerDay) + treatmentCost;
    }

    @Override
    public void addRecord(String record) {
        records.add(record);
    }

    @Override
    public List<String> viewRecords() {
        return new ArrayList<>(records); // return copy to preserve encapsulation
    }
}
class OutPatient extends Patient implements MedicalRecord {

    private final double consultationFee;
    private final double testCharges;

    private List<String> records = new ArrayList<>();

    public OutPatient(String patientId, String name, int age,
                      double consultationFee, double testCharges) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.testCharges = testCharges;
    }

    @Override
    public double calculateBill() {
        return consultationFee + testCharges;
    }

    @Override
    public void addRecord(String record) {
        records.add(record);
    }

    @Override
    public List<String> viewRecords() {
        return new ArrayList<>(records);
    }
}


public class HospitalManagement {
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();

        InPatient inPatient = new InPatient("P101", "Rahul", 30,
                5, 2000.0, 8000.0);
        inPatient.setDiagnosis("Pneumonia");
        inPatient.addRecord("Admitted to ward A on 01-01-2026");

        OutPatient outPatient = new OutPatient("P102", "Sneha", 25,
                500.0, 1200.0);
        outPatient.setDiagnosis("Seasonal flu");
        outPatient.addRecord("Visited OPD on 02-01-2026");

        patients.add(inPatient);
        patients.add(outPatient);

        // Polymorphism: same method call, different implementations
        for (Patient p : patients) {
            System.out.println(p.getPatientDetails());
            System.out.println("Bill amount: " + p.calculateBill());

            if (p instanceof MedicalRecord) {
                MedicalRecord mr = (MedicalRecord) p;
                System.out.println("Medical Records: " + mr.viewRecords());
            }

            System.out.println("--------------------------------");
        }
    }
}




