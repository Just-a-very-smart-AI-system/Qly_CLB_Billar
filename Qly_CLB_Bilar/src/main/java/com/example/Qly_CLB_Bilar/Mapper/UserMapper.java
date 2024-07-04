package com.example.Qly_CLB_Bilar.Mapper;

import com.example.Qly_CLB_Bilar.DTO.JWT.UserRequest;
import com.example.Qly_CLB_Bilar.Entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface  UserMapper {
    @Mapping(target = "roles", ignore = true)
    User toUser(UserRequest userRequest);
    @Mapping(target = "roles", ignore = true)
    UserRequest toUserRequest(User user);
}
