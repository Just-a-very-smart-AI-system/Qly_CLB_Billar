package com.example.Qly_CLB_Bilar.Mapper;

import com.example.Qly_CLB_Bilar.DTO.JWT.UserRequest;
import com.example.Qly_CLB_Bilar.Entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface  UserMapper {
    User toUser(UserRequest userRequest);
}
