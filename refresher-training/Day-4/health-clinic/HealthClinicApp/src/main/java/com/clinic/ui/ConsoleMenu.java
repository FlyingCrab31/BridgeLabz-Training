package com.clinic.ui;

import com.clinic.dao.*;
import com.clinic.dto.*;
import com.clinic.service.AppointmentService;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class ConsoleMenu {

    private final Scanner scanner = new Scanner(System.in);
    private final PatientDAO patientDAO = new PatientDAOImpl();
    private final DoctorDAO doctorDAO = new DoctorDAOImpl();
    private final SpecializationDAO specializationDAO = new SpecializationDAOImpl();
    private final AppointmentDAO appointmentDAO = new AppointmentDAOImpl();
    private final BillingDAO billingDAO = new BillingDAOImpl();
    private final VisitHistoryDAO visitHistoryDAO = new VisitHistoryDAOImpl();
    private final AppointmentService appointmentService = new AppointmentService();

    public void start() {
        boolean running = true;
        while (running) {
            printHeader();
            System.out.println(" 1. Register Patient");
            System.out.println(" 2. Register Doctor");
            System.out.println(" 3. Add Specialization");
            System.out.println(" 4. Book Appointment");
            System.out.println(" 5. Complete Appointment (Service Layer)");
            System.out.println(" 6. View All Patients");
            System.out.println(" 7. View All Doctors");
            System.out.println(" 8. View All Appointments");
            System.out.println(" 9. View Visit History");
            System.out.println(" 10. View Billing Records");
            System.out.println(" 11. Exit");
            System.out.print("\nSelect an option (1-11): ");

            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                switch (choice) {
                    case 1 -> registerPatient();
                    case 2 -> registerDoctor();
                    case 3 -> addSpecialization();
                    case 4 -> bookAppointment();
                    case 5 -> completeAppointment();
                    case 6 -> viewAllPatients();
                    case 7 -> viewAllDoctors();
                    case 8 -> viewAllAppointments();
                    case 9 -> viewVisitHistory();
                    case 10 -> viewBillingRecords();
                    case 11 -> {
                        running = false;
                        System.out.println("\nThank you for using HealthClinicApp. Goodbye!");
                    }
                    default -> System.out.println("\n❌ Invalid choice! Please select between 1 and 11.");
                }
            } catch (NumberFormatException e) {
                System.out.println("\n❌ Invalid input! Please enter a numeric choice.");
            }
        }
    }

    private void printHeader() {
        System.out.println("\n==================================================");
        System.out.println("         🏥 Health Clinic Console Menu           ");
        System.out.println("==================================================");
    }

    private void registerPatient() {
        System.out.println("\n--- 👤 Register New Patient ---");
        System.out.print("First Name: ");
        String first = scanner.nextLine().trim();
        System.out.print("Last Name: ");
        String last = scanner.nextLine().trim();
        System.out.print("Email: ");
        String email = scanner.nextLine().trim();
        System.out.print("Phone: ");
        String phone = scanner.nextLine().trim();

        Patient p = new Patient(first, last, email);
        p.setPhone(phone);

        int id = patientDAO.insertPatient(p);
        if (id > 0) {
            System.out.println("✅ Patient registered successfully with ID: " + id);
        } else {
            System.out.println("❌ Patient registration failed. Please check inputs or duplicate email.");
        }
    }

    private void registerDoctor() {
        System.out.println("\n--- 🩺 Register New Doctor ---");
        System.out.print("Doctor Name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Email: ");
        String email = scanner.nextLine().trim();
        System.out.print("Phone: ");
        String phone = scanner.nextLine().trim();

        // List specializations first
        List<Specialization> specs = specializationDAO.getAllSpecializations();
        System.out.println("Available Specializations:");
        for (Specialization s : specs) {
            System.out.printf("  [%d] %s - %s\n", s.getSpecialtyId(), s.getName(), s.getDescription());
        }
        System.out.print("Specialty ID: ");
        int specId = Integer.parseInt(scanner.nextLine().trim());

        Doctor doc = new Doctor(name, email, phone, specId);
        int id = doctorDAO.insertDoctor(doc);
        if (id > 0) {
            System.out.println("✅ Doctor registered successfully with ID: " + id);
        } else {
            System.out.println("❌ Doctor registration failed.");
        }
    }

    private void addSpecialization() {
        System.out.println("\n--- 📋 Add Specialization ---");
        System.out.print("Specialty Name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Description: ");
        String desc = scanner.nextLine().trim();

        Specialization spec = new Specialization(name, desc);
        int id = specializationDAO.insertSpecialization(spec);
        if (id > 0) {
            System.out.println("✅ Specialization added with ID: " + id);
        } else {
            System.out.println("❌ Failed to add specialization.");
        }
    }

    private void bookAppointment() {
        System.out.println("\n--- 📅 Book Appointment ---");
        System.out.print("Patient ID: ");
        int patientId = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Doctor ID: ");
        int doctorId = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Appointment Date & Time (yyyy-MM-dd HH:mm): ");
        String dateStr = scanner.nextLine().trim();
        System.out.print("Reason for visit: ");
        String reason = scanner.nextLine().trim();

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            java.util.Date parsedDate = dateFormat.parse(dateStr);
            Timestamp apptTime = new Timestamp(parsedDate.getTime());

            Appointment appt = new Appointment(patientId, doctorId, apptTime, reason);
            int id = appointmentDAO.insertAppointment(appt);
            if (id > 0) {
                System.out.println("✅ Appointment booked successfully with ID: " + id);
            } else {
                System.out.println("❌ Appointment booking failed.");
            }
        } catch (ParseException e) {
            System.out.println("❌ Invalid date format. Use 'yyyy-MM-dd HH:mm' (e.g. 2026-08-10 14:30).");
        }
    }

    private void completeAppointment() {
        System.out.println("\n--- 💳 Complete Appointment ---");
        System.out.print("Appointment ID: ");
        int apptId = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Bill Amount ($): ");
        BigDecimal amount = new BigDecimal(scanner.nextLine().trim());
        System.out.print("Diagnosis / Treatment Notes: ");
        String diagnosis = scanner.nextLine().trim();

        boolean success = appointmentService.completeAppointment(apptId, amount, diagnosis);
        if (success) {
            System.out.println("🎉 Appointment #" + apptId + " completed! Status updated, bill generated, & visit logged.");
        } else {
            System.out.println("❌ Transaction failed! All changes have been safely rolled back.");
        }
    }

    private void viewAllPatients() {
        System.out.println("\n--- 📜 All Registered Patients ---");
        List<Patient> patients = patientDAO.getAllPatients();
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
        } else {
            for (Patient p : patients) {
                System.out.println(p);
            }
        }
    }

    private void viewAllDoctors() {
        System.out.println("\n--- 🩺 All Registered Doctors ---");
        List<Doctor> doctors = doctorDAO.getAllDoctors();
        if (doctors.isEmpty()) {
            System.out.println("No doctors found.");
        } else {
            for (Doctor d : doctors) {
                System.out.println(d);
            }
        }
    }

    private void viewAllAppointments() {
        System.out.println("\n--- 📅 All Appointments ---");
        List<Appointment> appts = appointmentDAO.getAllAppointments();
        if (appts.isEmpty()) {
            System.out.println("No appointments found.");
        } else {
            for (Appointment a : appts) {
                System.out.println(a);
            }
        }
    }

    private void viewVisitHistory() {
        System.out.println("\n--- 📖 Visit History ---");
        List<VisitHistory> visits = visitHistoryDAO.getAllVisits();
        if (visits.isEmpty()) {
            System.out.println("No visit records found.");
        } else {
            for (VisitHistory v : visits) {
                System.out.println(v);
            }
        }
    }

    private void viewBillingRecords() {
        System.out.println("\n--- 💰 Billing Records ---");
        List<Billing> billings = billingDAO.getAllBillings();
        if (billings.isEmpty()) {
            System.out.println("No billing records found.");
        } else {
            for (Billing b : billings) {
                System.out.println(b);
            }
        }
    }
}
