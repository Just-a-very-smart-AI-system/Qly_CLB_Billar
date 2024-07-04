package com.example.Qly_CLB_Bilar.Mapper;

import com.example.Qly_CLB_Bilar.DTO.Request.RoleRequest;
import com.example.Qly_CLB_Bilar.Entity.Roles;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permisstion", ignore = true)
    Roles toRoles(RoleRequest roleRequest);

    @Mapping(target = "permisstionName", ignore = true)
    RoleRequest toRequest(Roles roles);
}
