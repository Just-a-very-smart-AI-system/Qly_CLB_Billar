package com.example.Qly_CLB_Bilar.DTO;

import com.example.Qly_CLB_Bilar.Entity.Enum.BillStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class BillRequset {

    private String billId;

    private LocalTime TimeArrive;

    private LocalTime TimeOut;

    private BillStatus status;

    private String note;

    private float cost;

    private float discount;

    private float paid;

    private Date date;

}
