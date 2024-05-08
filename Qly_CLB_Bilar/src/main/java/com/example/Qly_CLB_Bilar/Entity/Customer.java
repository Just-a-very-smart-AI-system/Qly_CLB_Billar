package com.example.Qly_CLB_Bilar.Entity;

import com.example.Qly_CLB_Bilar.Entity.Enum.Gender;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Customer {

    @Id
    @Column(name = "Customer_ID", nullable = false, length = 10)
    private String customerId;

    @Column(name = "Name", nullable = false, length = 50)
    private String name;

    @Column(name = "Address", length = 50)
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(name = "Gender", nullable = false, length = 10)
    private Gender gender;

    @Column(name = "MoneyPaid", nullable = false)
    private float moneyPaid;

    @Column(name = "Birthday", nullable = false)
    private LocalDate birthday;

    @Column(name = "TotalMoney", nullable = false)
    private Float totalMoney;

    @Column(name = "SDT", nullable = false, length = 10)
    private String sdt;

    public Customer() {
    }

    public Customer(String customerId, String name, String address, Gender gender, float moneyPaid, LocalDate birthday, Float totalMoney, String sdt) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.moneyPaid = moneyPaid;
        this.birthday = birthday;
        this.totalMoney = totalMoney;
        this.sdt = sdt;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public float getMoneyPaid() {
        return moneyPaid;
    }

    public void setMoneyPaid(float moneyPaid) {
        this.moneyPaid = moneyPaid;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Float getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Float totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
}
