package com.example.Qly_CLB_Bilar.Entity;

import jakarta.persistence.*;
import java.time.LocalTime;
import java.time.LocalDate;

@Entity
public class TimeKeeping {

    @Id
    @Column(name = "Time_Keeping_ID", nullable = false, length = 50)
    private String timeKeepingId;

    @ManyToOne
    @JoinColumn(name = "Staff_ID", nullable = false)
    private Staff staff;

    @Column(name = "TimeIn", nullable = false)
    private LocalTime timeIn;

    @Column(name = "TimeOut", nullable = false)
    private LocalTime timeOut;

    @Column(name = "working_day", nullable = false)
    private LocalDate workingDay;

    public TimeKeeping(String timeKeepingId, Staff staff, LocalTime timeIn, LocalTime timeOut, LocalDate workingDay) {
        this.timeKeepingId = timeKeepingId;
        this.staff = staff;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.workingDay = workingDay;
    }

    public TimeKeeping() {
    }

    public String getTimeKeepingId() {
        return timeKeepingId;
    }

    public void setTimeKeepingId(String timeKeepingId) {
        this.timeKeepingId = timeKeepingId;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public LocalTime getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(LocalTime timeIn) {
        this.timeIn = timeIn;
    }

    public LocalTime getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(LocalTime timeOut) {
        this.timeOut = timeOut;
    }

    public LocalDate getWorkingDay() {
        return workingDay;
    }

    public void setWorkingDay(LocalDate workingDay) {
        this.workingDay = workingDay;
    }
}
