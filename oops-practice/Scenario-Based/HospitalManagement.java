import java.util.*;
// Encapsulation
abstract class Patient {
    private int id;
    private String name;
    private int age;

    public Patient(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // getters/setters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }

    // Polymorphism
    public abstract void displayInfo();
}
// Abstraction
interface IPayable {
    double calculateAmount();
}
class InPatient extends Patient {
    private int daysAdmitted;
    private double roomChargePerDay;

    public InPatient(int id, String name, int age,
                     int daysAdmitted, double roomChargePerDay) {
        super(id, name, age);
        this.daysAdmitted = daysAdmitted;
        this.roomChargePerDay = roomChargePerDay;
    }

    public int getDaysAdmitted() { return daysAdmitted; }
    public double getRoomChargePerDay() { return roomChargePerDay; }

    @Override
    public void displayInfo() {
        System.out.println("InPatient: " + getId() + ", " + getName()
                + ", Age: " + getAge()
                + ", Days: " + daysAdmitted
                + ", Room/Day: " + roomChargePerDay);
    }
}
class OutPatient extends Patient {
    private double consultationFee;

    public OutPatient(int id, String name, int age, double consultationFee) {
        super(id, name, age);
        this.consultationFee = consultationFee;
    }

    public double getConsultationFee() { return consultationFee; }

    @Override
    public void displayInfo() {
        System.out.println("OutPatient: " + getId() + ", " + getName()
                + ", Age: " + getAge()
                + ", Consultation Fee: " + consultationFee);
    }
}

class Doctor {
    private int id;
    private String name;
    private String specialization;

    public Doctor(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getSpecialization() { return specialization; }

    public void displayInfo() {
        System.out.println("Doctor: " + id + ", " + name
                + ", Spec: " + specialization);
    }
}
class Bill implements IPayable {
    private int billId;
    private Patient patient;
    private Doctor doctor;
    private double extraCharges; // tests, medicines etc.

    public Bill(int billId, Patient patient, Doctor doctor, double extraCharges) {
        this.billId = billId;
        this.patient = patient;
        this.doctor = doctor;
        this.extraCharges = extraCharges;
    }

    public int getBillId() { return billId; }
    public Patient getPatient() { return patient; }
    public Doctor getDoctor() { return doctor; }

    @Override
    public double calculateAmount() {
        double base = 0.0;
        if (patient instanceof InPatient inPat) {
            base = inPat.getDaysAdmitted() * inPat.getRoomChargePerDay();
        } else if (patient instanceof OutPatient outPat) {
            base = outPat.getConsultationFee();
        }
        return base + extraCharges;
    }

    public void displayBill() {
        System.out.println("Bill ID: " + billId);
        patient.displayInfo();              // polymorphism
        doctor.displayInfo();
        System.out.println("Total Amount: " + calculateAmount());
    }
}


class HospitalSystem {
    private List<Patient> patients = new ArrayList<>();
    private List<Doctor> doctors = new ArrayList<>();
    private List<Bill> bills = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    // CREATE patient
    public void addPatient() {
        System.out.print("1. InPatient  2. OutPatient: ");
        int type = sc.nextInt();
        System.out.print("Id: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Age: ");
        int age = sc.nextInt();

        Patient p;
        if (type == 1) {
            System.out.print("Days admitted: ");
            int days = sc.nextInt();
            System.out.print("Room charge per day: ");
            double charge = sc.nextDouble();
            p = new InPatient(id, name, age, days, charge);
        } else {
            System.out.print("Consultation fee: ");
            double fee = sc.nextDouble();
            p = new OutPatient(id, name, age, fee);
        }
        patients.add(p);
        System.out.println("Patient added.");
    }

    // READ patients
    public void listPatients() {
        for (Patient p : patients) {
            p.displayInfo();
        }
    }

    // UPDATE patient (change name, age)
    public void updatePatient() {
        System.out.print("Enter patient id to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        Patient p = findPatientById(id);
        if (p == null) {
            System.out.println("Not found.");
            return;
        }
        System.out.print("New name: ");
        String name = sc.nextLine();
        System.out.print("New age: ");
        int age = sc.nextInt();
        p.setName(name);
        p.setAge(age);
        System.out.println("Updated.");
    }

    // DELETE patient
    public void deletePatient() {
        System.out.print("Enter patient id to delete: ");
        int id = sc.nextInt();
        Patient p = findPatientById(id);
        if (p != null) {
            patients.remove(p);
            System.out.println("Deleted.");
        } else {
            System.out.println("Not found.");
        }
    }

    private Patient findPatientById(int id) {
        for (Patient p : patients) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    // Similar CRUD methods can be added for Doctor and Bill...
}
public class HospitalManagement {
    public static void main(String[] args) {
        HospitalSystem hs = new HospitalSystem();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Add Patient");
            System.out.println("2. List Patients");
            System.out.println("3. Update Patient");
            System.out.println("4. Delete Patient");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> hs.addPatient();
                case 2 -> hs.listPatients();
                case 3 -> hs.updatePatient();
                case 4 -> hs.deletePatient();
            }
        } while (choice != 0);
    }
}



