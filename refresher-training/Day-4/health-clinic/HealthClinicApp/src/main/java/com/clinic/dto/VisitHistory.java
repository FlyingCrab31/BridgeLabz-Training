package com.clinic.dto;

import java.sql.Timestamp;

public class VisitHistory {
    private int visitId;
    private int appointmentId;
    private int patientId;
    private int doctorId;
    private String diagnosis;
    private Timestamp visitDate;

    public VisitHistory() {}

    public VisitHistory(int appointmentId, int patientId, int doctorId, String diagnosis) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.diagnosis = diagnosis;
    }

    public VisitHistory(int visitId, int appointmentId, int patientId, int doctorId, String diagnosis, Timestamp visitDate) {
        this.visitId = visitId;
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.diagnosis = diagnosis;
        this.visitDate = visitDate;
    }

    public int getVisitId() {
        return visitId;
    }

    public void setVisitId(int visitId) {
        this.visitId = visitId;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Timestamp getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Timestamp visitDate) {
        this.visitDate = visitDate;
    }

    @Override
    public String toString() {
        return "VisitHistory{" +
                "visitId=" + visitId +
                ", appointmentId=" + appointmentId +
                ", patientId=" + patientId +
                ", doctorId=" + doctorId +
                ", diagnosis='" + diagnosis + '\'' +
                ", visitDate=" + visitDate +
                '}';
    }
}
