package com.example.Qly_CLB_Bilar.Entity;

import com.example.Qly_CLB_Bilar.Entity.Enum.PaymentMethod;
import jakarta.persistence.*;

@Entity
public class ListBill {

    @Id
    @Column(name = "Bill_ID", nullable = false, length = 50)
    private String billId;

    @Column(name = "Customer_ID", nullable = false, length = 50)
    private String customerId;

    @Enumerated(EnumType.STRING)
    @Column(name = "PayMethod", nullable = false, length = 20)
    private PaymentMethod payMethod;

    @Column(name = "Change", nullable = false)
    private float change;

    @Column(name = "TotalMoney", nullable = false)
    private float totalMoney;

    public ListBill() {
    }

    public ListBill(String billId, String customerId, PaymentMethod payMethod, float change, float totalMoney) {
        this.billId = billId;
        this.customerId = customerId;
        this.payMethod = payMethod;
        this.change = change;
        this.totalMoney = totalMoney;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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

