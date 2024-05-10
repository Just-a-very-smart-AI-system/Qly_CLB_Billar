package com.example.Qly_CLB_Bilar.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class SupplierRequest {
    private String supplierId;
    private String name;
    private float totalLoan;
    private String sdt;
    private String address;
}
