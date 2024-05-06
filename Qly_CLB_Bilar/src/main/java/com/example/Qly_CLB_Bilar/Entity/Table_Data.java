package com.example.Qly_CLB_Bilar.Entity;


import com.example.Qly_CLB_Bilar.Entity.Enum.TableStatus;
import jakarta.persistence.*;

@Entity
public class Table_Data {

    @Id
    @Column(name = "Table_ID", nullable = false, length = 50)
    private String tableId;

    @Column(name = "Seats", nullable = false)
    private int seats;

    @Column(name = "Note", columnDefinition = "TEXT")
    private String note;

    @Column(name = "Area", nullable = false, length = 50)
    private String area;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status", nullable = false, length = 10)
    private TableStatus status;

    public Table_Data() {
    }

    public Table_Data(String tableId, int seats, String note, String area, TableStatus status) {
        this.tableId = tableId;
        this.seats = seats;
        this.note = note;
        this.area = area;
        this.status = status;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public TableStatus getStatus() {
        return status;
    }

    public void setStatus(TableStatus status) {
        this.status = status;
    }
}


