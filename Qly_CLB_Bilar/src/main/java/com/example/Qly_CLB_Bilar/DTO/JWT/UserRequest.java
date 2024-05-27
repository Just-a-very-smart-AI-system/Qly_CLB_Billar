package com.example.Qly_CLB_Bilar.DTO.JWT;

import com.example.Qly_CLB_Bilar.Entity.Staff;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UserRequest {
    private String user_name;
    private String password;
    private Staff staff;
    private String staffId;
}
