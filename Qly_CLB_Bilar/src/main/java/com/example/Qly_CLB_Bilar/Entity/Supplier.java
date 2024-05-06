package com.example.Qly_CLB_Bilar.Entity;

import jakarta.persistence.*;

@Entity
public class Supplier {

    @Id
    @Column(name = "Supplier_ID", nullable = false, length = 50)
    private String supplierId;

    @Column(name = "Name", nullable = false, length = 50)
    private String name;

    @Column(name = "TotalLoan", nullable = false)
    private float totalLoan;

    @ManyToOne
    @JoinColumn(name = "Goods_ID", nullable = false)
    private Goods goods;

    @Column(name = "SDT", nullable = false, length = 50)
    private String sdt;

    @Column(name = "Address", nullable = false, length = 50)
    private String address;

    public Supplier() {
    }

    public Supplier(String supplierId, String name, float totalLoan, Goods goods, String sdt, String address) {
        this.supplierId = supplierId;
        this.name = name;
        this.totalLoan = totalLoan;
        this.goods = goods;
        this.sdt = sdt;
        this.address = address;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getTotalLoan() {
        return totalLoan;
    }

    public void setTotalLoan(float totalLoan) {
        this.totalLoan = totalLoan;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
