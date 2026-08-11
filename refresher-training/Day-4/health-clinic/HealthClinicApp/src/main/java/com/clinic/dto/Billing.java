package com.clinic.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Billing {
    private int billId;
    private int appointmentId;
    private BigDecimal amount;
    private String paymentStatus; // Pending, Paid, Cancelled
    private Timestamp paymentDate;
    private Timestamp createdAt;

    public Billing() {}

    public Billing(int appointmentId, BigDecimal amount) {
        this.appointmentId = appointmentId;
        this.amount = amount;
        this.paymentStatus = "Pending";
    }

    public Billing(int billId, int appointmentId, BigDecimal amount, String paymentStatus, Timestamp paymentDate, Timestamp createdAt) {
        this.billId = billId;
        this.appointmentId = appointmentId;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
        this.paymentDate = paymentDate;
        this.createdAt = createdAt;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Timestamp getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Timestamp paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Billing{" +
                "billId=" + billId +
                ", appointmentId=" + appointmentId +
                ", amount=" + amount +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", paymentDate=" + paymentDate +
                '}';
    }
}
