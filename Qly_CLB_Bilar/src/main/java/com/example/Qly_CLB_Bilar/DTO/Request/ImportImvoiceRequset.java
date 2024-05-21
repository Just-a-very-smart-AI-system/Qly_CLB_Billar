package com.example.Qly_CLB_Bilar.DTO.Request;

import com.example.Qly_CLB_Bilar.Entity.Enum.BillStatus;
import com.example.Qly_CLB_Bilar.Entity.Goods;
import com.example.Qly_CLB_Bilar.Entity.Staff;
import com.example.Qly_CLB_Bilar.Entity.Supplier;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ImportImvoiceRequset {
    private String importInvoiceId;
    private Supplier supplier;
    private Goods goods;

    private Staff staff;

    private Integer quantity;

    private Float discount;

    private Float price;

    private Float cost;

    private LocalDate time;

    private String address;

    private BillStatus status;
}
