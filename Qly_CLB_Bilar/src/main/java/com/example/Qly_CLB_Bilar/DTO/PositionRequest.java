package com.example.Qly_CLB_Bilar.DTO;

import com.example.Qly_CLB_Bilar.Entity.Enum.SalaryType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class PositionRequest {
    private String positionId;
    private SalaryType typeSalary;
    private float paidHour;
}
