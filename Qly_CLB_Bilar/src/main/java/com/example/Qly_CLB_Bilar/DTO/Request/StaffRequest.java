package com.example.Qly_CLB_Bilar.DTO.Request;

import com.example.Qly_CLB_Bilar.Entity.Enum.Gender;
import com.example.Qly_CLB_Bilar.Entity.Position;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class StaffRequest {
    private String staffId;
    private Position position;
    private String name;
    private String sdt;
    private LocalDate dateStart;
    private LocalDate birthday;
    private String address;
    private Gender gender;
    private int timeWorking;

}
