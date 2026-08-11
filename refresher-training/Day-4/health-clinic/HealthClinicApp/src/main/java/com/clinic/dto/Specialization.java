package com.clinic.dto;

public class Specialization {
    private int specialtyId;
    private String name;
    private String description;

    public Specialization() {}

    public Specialization(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Specialization(int specialtyId, String name, String description) {
        this.specialtyId = specialtyId;
        this.name = name;
        this.description = description;
    }

    public int getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(int specialtyId) {
        this.specialtyId = specialtyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Specialization{" +
                "specialtyId=" + specialtyId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
