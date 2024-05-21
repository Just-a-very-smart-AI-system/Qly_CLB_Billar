package com.example.Qly_CLB_Bilar.DTO.Request;

import com.example.Qly_CLB_Bilar.Entity.Position;
import com.example.Qly_CLB_Bilar.Entity.Staff;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class PayrollRequest {
    private String payrollId;
    private Staff staff;
    private LocalDate date;
    private float totalMoney;

}
