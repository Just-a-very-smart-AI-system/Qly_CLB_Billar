package com.example.Qly_CLB_Bilar.DTO;

import com.example.Qly_CLB_Bilar.Entity.Bill;
import com.example.Qly_CLB_Bilar.Entity.Booking;
import com.example.Qly_CLB_Bilar.Entity.Goods;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class DetailBillRequest {

    private String detailBillId;

    private Bill bill;

    private Goods goods;

    private Booking booking;

    private int quantity;

    private String note;
}
