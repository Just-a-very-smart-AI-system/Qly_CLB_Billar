package com.example.Qly_CLB_Bilar.Mapper;

import com.example.Qly_CLB_Bilar.DTO.Request.PayrollRequest;
import com.example.Qly_CLB_Bilar.Entity.Payroll;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PayrollMapper {
    Payroll toPayroll(PayrollRequest payrollRequest);
}
