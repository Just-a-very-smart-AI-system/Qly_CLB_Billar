package com.example.Qly_CLB_Bilar.Entity;

import com.example.Qly_CLB_Bilar.Entity.Enum.BillStatus;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "import_invoice")
public class ImportInvoice {

    @Id
    @Column(name = "Import_Invoice_ID", length = 50, nullable = false)
    private String importInvoiceId;

    @ManyToOne
    @JoinColumn(name = "Supplier_ID", nullable = false)
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "Goods_ID", nullable = false)
    private Goods goods;

    @ManyToOne
    @JoinColumn(name = "Staff_ID", nullable = false)
    private Staff staff;

    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

    @Column(name = "Discount")
    private Float discount;

    @Column(name = "Price", nullable = false)
    private Float price;

    @Column(name = "Cost", nullable = false)
    private Float cost;

    @Column(name = "Time", nullable = false)
    private LocalDate time;

    @Column(name = "Address", length = 50, nullable = false)
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status", length = 50, nullable = false)
    private BillStatus status;

    public ImportInvoice() {
    }

    public String getImportInvoiceId() {
        return importInvoiceId;
    }

    public void setImportInvoiceId(String importInvoiceId) {
        this.importInvoiceId = importInvoiceId;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BillStatus getStatus() {
        return status;
    }

    public void setStatus(BillStatus status) {
        this.status = status;
    }

    // Getters and setters
    // ...
}