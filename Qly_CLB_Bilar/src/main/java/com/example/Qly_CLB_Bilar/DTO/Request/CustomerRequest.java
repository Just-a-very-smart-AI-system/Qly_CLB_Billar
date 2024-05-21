package com.example.Qly_CLB_Bilar.DTO.Request;

import com.example.Qly_CLB_Bilar.Entity.Enum.Gender;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class CustomerRequest {
    private String customerId;

    private String name;

    private String address;

    private Gender gender;

    private float moneyPaid;

    private LocalDate birthday;

    private Float totalMoney;

    private String sdt;

}
