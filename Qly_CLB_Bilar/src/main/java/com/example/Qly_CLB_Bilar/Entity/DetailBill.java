package com.example.Qly_CLB_Bilar.Entity;

import jakarta.persistence.*;

@Entity
public class DetailBill {

    @Id
    @Column(name = "Detail_Bill_ID", nullable = false, length = 50)
    private String detailBillId;

    @ManyToOne
    @JoinColumn(name = "Bill_ID", nullable = false)
    private Bill bill;

    @ManyToOne
    @JoinColumn(name = "Goods_ID")
    private Goods goods;

    @ManyToOne
    @JoinColumn(name = "Booking_ID")
    private Booking booking;

    @Column(name = "Quantity", nullable = false)
    private int quantity;

    @Column(name = "Note", length = 50)
    private String note;

    public DetailBill(String detailBillId, Bill bill, Goods goods, Booking booking, int quantity, String note) {
        this.detailBillId = detailBillId;
        this.bill = bill;
        this.goods = goods;
        this.booking = booking;
        this.quantity = quantity;
        this.note = note;
    }

    public String getDetailBillId() {
        return detailBillId;
    }

    public void setDetailBillId(String detailBillId) {
        this.detailBillId = detailBillId;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public DetailBill() {
    }
}
