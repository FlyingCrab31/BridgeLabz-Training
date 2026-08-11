package com.clinic.service;

import com.clinic.config.DatabaseConnection;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AppointmentService {

    /**
     * Completes an appointment in a single atomic transaction.
     * 1. Marks appointment status as 'Completed'
     * 2. Inserts a billing record
     * 3. Inserts a visit history record
     *
     * @param appointmentId ID of the appointment to complete
     * @param amount Bill amount
     * @param diagnosis Diagnosis notes from the doctor
     * @return true if all three writes succeed and commit, false if any step fails (rollback)
     */
    public boolean completeAppointment(int appointmentId, BigDecimal amount, String diagnosis) {
        Connection conn = null;
        try {
            conn = DatabaseConnection.getConnection();
            conn.setAutoCommit(false); // Stop auto-saving after each statement

            // Step A: Retrieve patientId & doctorId from the appointment
            int patientId = -1;
            int doctorId = -1;
            String fetchApptSql = "SELECT patient_id, doctor_id, status FROM appointments WHERE appointment_id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(fetchApptSql)) {
                pstmt.setInt(1, appointmentId);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    patientId = rs.getInt("patient_id");
                    doctorId = rs.getInt("doctor_id");
                } else {
                    System.err.println("Error: Appointment ID " + appointmentId + " not found.");
                    conn.rollback();
                    return false;
                }
            }

            // Write 1: Mark appointment as completed
            String updateSql = "UPDATE appointments SET status = 'Completed' WHERE appointment_id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(updateSql)) {
                pstmt.setInt(1, appointmentId);
                pstmt.executeUpdate();
            }

            // Write 2: Create the bill
            String billSql = "INSERT INTO billing (appointment_id, amount, payment_status) VALUES (?, ?, 'Pending')";
            try (PreparedStatement pstmt = conn.prepareStatement(billSql)) {
                pstmt.setInt(1, appointmentId);
                pstmt.setBigDecimal(2, amount);
                pstmt.executeUpdate();
            }

            // Write 3: Record what happened during the visit
            String visitSql = "INSERT INTO visit_history (appointment_id, patient_id, doctor_id, diagnosis) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(visitSql)) {
                pstmt.setInt(1, appointmentId);
                pstmt.setInt(2, patientId);
                pstmt.setInt(3, doctorId);
                pstmt.setString(4, diagnosis);
                pstmt.executeUpdate();
            }

            // All 3 writes succeeded -> commit changes permanently
            conn.commit();
            return true;

        } catch (SQLException e) {
            System.err.println("Something failed, undoing everything (rollback): " + e.getMessage());
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            return false;
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
