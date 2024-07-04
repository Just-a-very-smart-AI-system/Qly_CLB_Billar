package com.example.Qly_CLB_Bilar.DTO.Request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class RoleRequest {
    private String name;
    private String discription;
    private Set<String> permisstionName;
}
