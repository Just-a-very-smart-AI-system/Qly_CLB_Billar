package com.example.Qly_CLB_Bilar.Entity;

import com.example.Qly_CLB_Bilar.Entity.Enum.SalaryType;
import jakarta.persistence.*;


@Entity
public class Position {

    @Id
    @Column(name = "Position_ID", nullable = false, length = 50)
    private String positionId;

    @Enumerated(EnumType.STRING)
    @Column(name = "TypeSalary", nullable = false, length = 10)
    private SalaryType typeSalary;

    @Column(name = "PaidHour", nullable = false)
    private float paidHour;

    public Position() {
    }

    public Position(String positionId, SalaryType typeSalary, float paidHour) {
        this.positionId = positionId;
        this.typeSalary = typeSalary;
        this.paidHour = paidHour;
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public SalaryType getTypeSalary() {
        return typeSalary;
    }

    public void setTypeSalary(SalaryType typeSalary) {
        this.typeSalary = typeSalary;
    }

    public float getPaidHour() {
        return paidHour;
    }

    public void setPaidHour(float paidHour) {
        this.paidHour = paidHour;
    }
}

