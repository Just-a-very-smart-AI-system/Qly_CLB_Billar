package com.example.Qly_CLB_Bilar.Entity;

import com.example.Qly_CLB_Bilar.Entity.Enum.BillStatus;
import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalTime;

@Entity
public class Bill {

    @Id
    @Column(name = "Bill_ID", nullable = false, length = 50)
    private String billId;

    @Column(name = "time_arrive", nullable = false)
    private LocalTime TimeArrive;

    @Column(name = "time_out")
    private LocalTime TimeOut;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status", nullable = false, length = 20)
    private BillStatus status;

    @Column(name = "Note", columnDefinition = "TEXT")
    private String note;

    @Column(name = "Cost", nullable = false)
    private float cost;

    @Column(name = "Discount", nullable = false)
    private float discount;

    @Column(name = "Paid", nullable = false)
    private float paid;
    @Column(name = "date")
    private Date date;
    public Bill(String billId, LocalTime timeArrive, LocalTime timeOut, BillStatus status, String note, float cost, float discount, float paid) {
        this.billId = billId;
        this.TimeArrive = timeArrive;
        this.TimeOut = timeOut;
        this.status = status;
        this.note = note;
        this.cost = cost;
        this.discount = discount;
        this.paid = paid;
    }

    public Bill() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public LocalTime getTimeArrive() {
        return TimeArrive;
    }

    public void setTimeArrive(LocalTime timeArrive) {
        this.TimeArrive = timeArrive;
    }

    public LocalTime getTimeOut() {
        return TimeOut;
    }

    public void setTimeOut(LocalTime timeOut) {
        this.TimeOut = timeOut;
    }

    public BillStatus getStatus() {
        return status;
    }

    public void setStatus(BillStatus status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getPaid() {
        return paid;
    }

    public void setPaid(float paid) {
        this.paid = paid;
    }
}
