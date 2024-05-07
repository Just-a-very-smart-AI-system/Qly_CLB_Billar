package com.example.Qly_CLB_Bilar.Entity;

import com.example.Qly_CLB_Bilar.Entity.Enum.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
public class Staff {

    @Id
    @Column(name = "Staff_ID", nullable = false, length = 10)
    private String staffId;
    @OneToOne
    @JoinColumn(name = "Position_ID", nullable = false)
    private Position position;

    @Column(name = "Name", nullable = false, length = 50)
    private String name;
    @Column(name = "SDT", nullable = false, length = 10)
    private String sdt;

    @Column(name = "date_start", nullable = false)
    private LocalDate dateStart;

    @Column(name = "Birthday", nullable = false)
    private LocalDate birthday;

    @Column(name = "Address", nullable = false, length = 50)
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(name = "Gender", nullable = false, length = 10)
    private Gender gender;

    @Column(name = "TimeWorking", nullable = false)
    private int timeWorking;

    public Staff(String staffId, Position position, String name, String sdt, LocalDate dateStart, LocalDate birthday, String address, Gender gender, int timeWorking) {
        this.staffId = staffId;
        this.position = position;
        this.name = name;
        this.sdt = sdt;
        this.dateStart = dateStart;
        this.birthday = birthday;
        this.address = address;
        this.gender = gender;
        this.timeWorking = timeWorking;
    }

    public Staff() {
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position positionId) {
        this.position = positionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
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

    public int getTimeWorking() {
        return timeWorking;
    }

    public void setTimeWorking(int timeWorking) {
        this.timeWorking = timeWorking;
    }
}


