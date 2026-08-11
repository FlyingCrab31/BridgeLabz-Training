package com.clinic.dto;

import java.sql.Timestamp;

public class Doctor {
    private int doctorId;
    private String name;
    private String email;
    private String phone;
    private int specialtyId;
    private String specialtyName;
    private Timestamp createdAt;

    public Doctor() {}

    public Doctor(String name, String email, String phone, int specialtyId) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.specialtyId = specialtyId;
    }

    public Doctor(int doctorId, String name, String email, String phone, int specialtyId, Timestamp createdAt) {
        this.doctorId = doctorId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.specialtyId = specialtyId;
        this.createdAt = createdAt;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(int specialtyId) {
        this.specialtyId = specialtyId;
    }

    public String getSpecialtyName() {
        return specialtyName;
    }

    public void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId=" + doctorId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", specialtyId=" + specialtyId +
                (specialtyName != null ? ", specialtyName='" + specialtyName + '\'' : "") +
                '}';
    }
}
