package com.example.Qly_CLB_Bilar.DTO;

import com.example.Qly_CLB_Bilar.Entity.Enum.TableStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class TableRequest {
    private String tableId;
    private int seats;
    private String note;
    private String area;
    private TableStatus status;

}
