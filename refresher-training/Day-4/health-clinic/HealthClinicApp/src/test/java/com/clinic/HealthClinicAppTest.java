package com.clinic;

import com.clinic.config.DatabaseConnection;
import com.clinic.dao.*;
import com.clinic.dto.*;
import com.clinic.service.AppointmentService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HealthClinicAppTest {

    private PatientDAO patientDAO;
    private DoctorDAO doctorDAO;
    private SpecializationDAO specializationDAO;
    private AppointmentDAO appointmentDAO;
    private BillingDAO billingDAO;
    private VisitHistoryDAO visitHistoryDAO;
    private AppointmentService appointmentService;

    @BeforeAll
    public void setUp() throws Exception {
        // Configure DatabaseConnection to use H2 in MySQL compatibility mode
        DatabaseConnection.setCredentials(
                "jdbc:h2:mem:health_clinic_db;MODE=MySQL;DATABASE_TO_LOWER=TRUE;DB_CLOSE_DELAY=-1",
                "sa",
                ""
        );

        // Initialize Schema in H2
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute("CREATE TABLE IF NOT EXISTS specialties (" +
                    "specialty_id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(100) NOT NULL UNIQUE, " +
                    "description TEXT)");

            stmt.execute("CREATE TABLE IF NOT EXISTS doctors (" +
                    "doctor_id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(100) NOT NULL, " +
                    "email VARCHAR(100) UNIQUE NOT NULL, " +
                    "phone VARCHAR(20), " +
                    "specialty_id INT, " +
                    "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP)");

            stmt.execute("CREATE TABLE IF NOT EXISTS patients (" +
                    "patient_id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "first_name VARCHAR(50) NOT NULL, " +
                    "last_name VARCHAR(50) NOT NULL, " +
                    "email VARCHAR(100) UNIQUE NOT NULL, " +
                    "phone VARCHAR(20), " +
                    "date_of_birth DATE, " +
                    "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP)");

            stmt.execute("CREATE TABLE IF NOT EXISTS appointments (" +
                    "appointment_id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "patient_id INT NOT NULL, " +
                    "doctor_id INT NOT NULL, " +
                    "appointment_date TIMESTAMP NOT NULL, " +
                    "status VARCHAR(20) DEFAULT 'Scheduled', " +
                    "reason TEXT, " +
                    "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP)");

            stmt.execute("CREATE TABLE IF NOT EXISTS billing (" +
                    "bill_id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "appointment_id INT UNIQUE NOT NULL, " +
                    "amount DECIMAL(10, 2) NOT NULL, " +
                    "payment_status VARCHAR(20) DEFAULT 'Pending', " +
                    "payment_date TIMESTAMP, " +
                    "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP)");

            stmt.execute("CREATE TABLE IF NOT EXISTS visit_history (" +
                    "visit_id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "appointment_id INT NOT NULL, " +
                    "patient_id INT, " +
                    "doctor_id INT, " +
                    "diagnosis TEXT NOT NULL, " +
                    "visit_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP)");
        }

        patientDAO = new PatientDAOImpl();
        doctorDAO = new DoctorDAOImpl();
        specializationDAO = new SpecializationDAOImpl();
        appointmentDAO = new AppointmentDAOImpl();
        billingDAO = new BillingDAOImpl();
        visitHistoryDAO = new VisitHistoryDAOImpl();
        appointmentService = new AppointmentService();
    }

    @Test
    public void testPatientDAO() {
        Patient patient = new Patient("Ramesh", "Kumar", "ramesh.kumar@example.com");
        patient.setPhone("9876543210");
        int patientId = patientDAO.insertPatient(patient);

        assertTrue(patientId > 0, "Patient ID should be generated and > 0");

        Patient fetched = patientDAO.getPatientById(patientId);
        assertNotNull(fetched, "Fetched patient should not be null");
        assertEquals("Ramesh", fetched.getFirstName());
        assertEquals("Kumar", fetched.getLastName());
        assertEquals("ramesh.kumar@example.com", fetched.getEmail());
    }

    @Test
    public void testSpecializationAndDoctorDAO() {
        Specialization spec = new Specialization("Cardiology", "Heart & vascular care");
        int specId = specializationDAO.insertSpecialization(spec);
        assertTrue(specId > 0, "Specialty ID should be > 0");

        Doctor doctor = new Doctor("Dr. Aisha Sharma", "aisha.sharma@clinic.com", "9988776655", specId);
        int doctorId = doctorDAO.insertDoctor(doctor);
        assertTrue(doctorId > 0, "Doctor ID should be > 0");

        Doctor fetchedDoc = doctorDAO.getDoctorById(doctorId);
        assertNotNull(fetchedDoc, "Doctor should be retrieved");
        assertEquals("Dr. Aisha Sharma", fetchedDoc.getName());
        assertEquals(specId, fetchedDoc.getSpecialtyId());
    }

    @Test
    public void testCompleteAppointmentTransactionSuccess() {
        // 1. Create Patient
        Patient patient = new Patient("Anita", "Roy", "anita.roy@example.com");
        int patientId = patientDAO.insertPatient(patient);

        // 2. Create Doctor
        Doctor doctor = new Doctor("Dr. Vikram Patel", "vikram.patel@clinic.com", "9123456789", -1);
        int doctorId = doctorDAO.insertDoctor(doctor);

        // 3. Book Appointment
        Timestamp apptTime = new Timestamp(System.currentTimeMillis());
        Appointment appt = new Appointment(patientId, doctorId, apptTime, "General Health Checkup");
        int apptId = appointmentDAO.insertAppointment(appt);
        assertTrue(apptId > 0, "Appointment ID should be > 0");

        // 4. Complete Appointment via AppointmentService (Atomic Transaction)
        BigDecimal billAmount = new BigDecimal("150.00");
        String diagnosis = "Patient is in healthy condition. Prescribed multivitamin supplements.";
        boolean success = appointmentService.completeAppointment(apptId, billAmount, diagnosis);

        assertTrue(success, "Transaction completeAppointment should succeed");

        // 5. Verify Appointment Status Updated to 'Completed'
        Appointment updatedAppt = appointmentDAO.getAppointmentById(apptId);
        assertNotNull(updatedAppt);
        assertEquals("Completed", updatedAppt.getStatus());

        // 6. Verify Billing Record Created
        Billing bill = billingDAO.getBillingByAppointmentId(apptId);
        assertNotNull(bill, "Billing record should be created");
        assertEquals(0, billAmount.compareTo(bill.getAmount()));
        assertEquals("Pending", bill.getPaymentStatus());

        // 7. Verify Visit History Created
        List<VisitHistory> visits = visitHistoryDAO.getVisitsByPatientId(patientId);
        assertFalse(visits.isEmpty(), "Visit history list should not be empty");
        assertEquals(diagnosis, visits.get(0).getDiagnosis());
    }

    @Test
    public void testCompleteAppointmentTransactionRollbackOnInvalidAppt() {
        // Call completeAppointment with non-existent appointment ID - should fail and rollback
        boolean success = appointmentService.completeAppointment(999999, new BigDecimal("200.00"), "Invalid Test");
        assertFalse(success, "completeAppointment should return false for invalid appointment ID");
    }
}
