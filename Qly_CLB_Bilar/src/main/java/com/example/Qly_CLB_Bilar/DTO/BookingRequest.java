package com.example.Qly_CLB_Bilar.DTO;

import com.example.Qly_CLB_Bilar.Entity.Customer;
import com.example.Qly_CLB_Bilar.Entity.Staff;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class BookingRequest {
    private String bookingId;

    private Customer customer;

    private Staff staff;

    private com.example.Qly_CLB_Bilar.Entity.Table_Data Table_Data;

    private LocalTime timeArrive;

    private LocalTime timePlay;

    private String note;

    private byte slot;

    private LocalDate date;
}
