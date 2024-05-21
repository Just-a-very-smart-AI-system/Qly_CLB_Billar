package com.example.Qly_CLB_Bilar.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Payroll {

    @Id
    @Column(name = "Payroll_ID", nullable = false, length = 50)
    private String payrollId;

    @ManyToOne
    @JoinColumn(name = "Staff_ID", nullable = false)
    private Staff staff;

    @Column(name = "Date", nullable = false)
    private LocalDate date;

    @Column(name = "TotalMoney", nullable = false)
    private float totalMoney;

    public Payroll(String payrollId, Staff staff, Position position, LocalDate date, float totalMoney) {
        this.payrollId = payrollId;
        this.staff = staff;
        this.date = date;
        this.totalMoney = totalMoney;
    }

    public Payroll() {
    }

    public String getPayrollId() {
        return payrollId;
    }

    public void setPayrollId(String payrollId) {
        this.payrollId = payrollId;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public float getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(float totalMoney) {
        this.totalMoney = totalMoney;
    }
}
