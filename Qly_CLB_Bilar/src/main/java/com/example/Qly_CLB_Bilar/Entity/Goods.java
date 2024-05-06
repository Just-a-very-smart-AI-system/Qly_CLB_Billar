package com.example.Qly_CLB_Bilar.Entity;


import com.example.Qly_CLB_Bilar.Entity.Enum.GoodsType;
import jakarta.persistence.*;

@Entity
public class Goods {

    @Id
    @Column(name = "Goods_ID", nullable = false, length = 50)
    private String goodsId;

    @Column(name = "Name", nullable = false, length = 50)
    private String name;

    @Column(name = "Price", nullable = false)
    private float price;

    @Column(name = "Cost", nullable = false)
    private float cost;

    @Column(name = "Inventory", nullable = false)
    private short inventory;

    @Column(name = "Unit", nullable = false, length = 50)
    private String unit;

    @Enumerated(EnumType.STRING)
    @Column(name = "Type", nullable = false, length = 10)
    private GoodsType type;

    // Getters and setters

    public Goods(String goodsId, String name, float price, float cost, short inventory, String unit, GoodsType type) {
        this.goodsId = goodsId;
        this.name = name;
        this.price = price;
        this.cost = cost;
        this.inventory = inventory;
        this.unit = unit;
        this.type = type;
    }

    public Goods(){
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public short getInventory() {
        return inventory;
    }

    public void setInventory(short inventory) {
        this.inventory = inventory;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public GoodsType getType() {
        return type;
    }

    public void setType(GoodsType type) {
        this.type = type;
    }
}

