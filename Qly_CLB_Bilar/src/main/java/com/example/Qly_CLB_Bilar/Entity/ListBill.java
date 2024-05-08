package com.example.Qly_CLB_Bilar.Entity;

import com.example.Qly_CLB_Bilar.Entity.Enum.PaymentMethod;
import jakarta.persistence.*;

@Entity
public class ListBill {

    @Id
    @Column(name = "list_id", nullable = false, length = 50)
    private String list_id;
    @ManyToOne
    @JoinColumn(name = "Bill_ID", nullable = false)
    private Bill bill;
    @ManyToOne
    @JoinColumn(name = "Customer_ID", nullable = false)
    private Customer customer;

    @Enumerated(EnumType.STRING)
    @Column(name = "PayMethod", nullable = false, length = 20)
    private PaymentMethod payMethod;

    @Column(name = "Change", nullable = false)
    private float change;

    @Column(name = "TotalMoney", nullable = false)
    private float totalMoney;

    public ListBill() {
    }

    public ListBill(Bill bill, Customer customer, PaymentMethod payMethod, float change, float totalMoney) {
        this.bill = bill;
        this.customer = customer;
        this.payMethod = payMethod;
        this.change = change;
        this.totalMoney = totalMoney;
    }

    public String getList_id() {
        return list_id;
    }

    public void setList_id(String list_id) {
        this.list_id = list_id;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill billId) {
        this.bill = billId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customerId) {
        this.customer = customerId;
    }

    public PaymentMethod getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(PaymentMethod payMethod) {
        this.payMethod = payMethod;
    }

    public float getChange() {
        return change;
    }

    public void setChange(float change) {
        this.change = change;
    }

    public float getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(float totalMoney) {
        this.totalMoney = totalMoney;
    }
}

