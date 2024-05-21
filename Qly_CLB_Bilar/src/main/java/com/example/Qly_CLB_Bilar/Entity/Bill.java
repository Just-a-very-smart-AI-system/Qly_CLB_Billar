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
    private LocalTime time_arrive;

    @Column(name = "time_out")
    private LocalTime time_out;

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
    @ManyToOne
    @JoinColumn(name = "customer_id" )
    private Customer customer;
    public Bill(String billId, LocalTime timearrive, LocalTime timeOut, BillStatus status, String note, float cost, float discount, float paid) {
        this.billId = billId;
        this.time_arrive = timearrive;
        this.time_out = timeOut;
        this.status = status;
        this.note = note;
        this.cost = cost;
        this.discount = discount;
        this.paid = paid;
    }

    public Bill() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public LocalTime getTime_arrive() {
        return time_arrive;
    }

    public void setTime_arrive(LocalTime time_arrive) {
        this.time_arrive = time_arrive;
    }

    public LocalTime getTime_out() {
        return time_out;
    }

    public void setTime_out(LocalTime time_out) {
        this.time_out = time_out;
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
