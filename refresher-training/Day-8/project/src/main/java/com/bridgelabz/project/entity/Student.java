package com.bridgelabz.project.entity;
import jakarta.persistence.*;
import com.bridgelabz.project.annotation.ValidGender;
@Entity
@Table(name = "student")
public class Student {

    public Integer getStudentId() {
        return studentId;
    }
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "roll_number")
    private String rollNumber;

    @Column(name = "first_name")
    private String firstName;
    @ValidGender
    @Column(name = "gender")
    private String gender;


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "last_name")
    private String lastName;

    private String email;
    private String address;
    private String city;
    private String state;
    private String course;
    private String department;
    @Column(name = "admission_year")
    private Integer admissionYear;

    // getters and setters
}