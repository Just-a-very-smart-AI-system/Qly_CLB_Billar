package com.example.Qly_CLB_Bilar.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Booking {

    @Id
    @Column(name = "Booking_ID", nullable = false, length = 50)
    private String bookingId;

    @ManyToOne
    @JoinColumn(name = "Customer_ID", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "Staff_ID", nullable = false)
    private Staff staff;

    @ManyToOne
    @JoinColumn(name = "Table_ID", nullable = false)
    private Table_Data Table_Data;

    @Column(name = "TimeArrive", nullable = false)
    private LocalTime timeArrive;

    @Column(name = "TimePlay", nullable = false)
    private LocalTime timePlay;

    @Column(name = "Note", columnDefinition = "TEXT")
    private String note;

    @Column(name = "Slot", nullable = false)
    private byte slot;


    @Column(name = "Date", nullable = false)
    private LocalDate date;

    public Booking() {
    }
    public Booking(String bookingId, Customer customer, Staff staff, Table_Data tableData, LocalTime timeArrive, LocalTime timePlay, String note, byte slot) {
        this.bookingId = bookingId;
        this.customer = customer;
        this.staff = staff;
        Table_Data = tableData;
        this.timeArrive = timeArrive;
        this.timePlay = timePlay;
        this.note = note;
        this.slot = slot;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public Table_Data getTable() {
        return Table_Data;
    }

    public void setTable(Table_Data tableData) {
        Table_Data = tableData;
    }

    public LocalTime getTimeArrive() {
        return timeArrive;
    }

    public void setTimeArrive(LocalTime timeArrive) {
        this.timeArrive = timeArrive;
    }

    public LocalTime getTimePlay() {
        return timePlay;
    }

    public void setTimePlay(LocalTime timePlay) {
        this.timePlay = timePlay;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public byte getSlot() {
        return slot;
    }

    public void setSlot(byte slot) {
        this.slot = slot;
    }
}
