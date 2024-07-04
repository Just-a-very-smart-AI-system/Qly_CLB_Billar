package com.example.Qly_CLB_Bilar.Service;

import com.example.Qly_CLB_Bilar.DTO.Request.RoleRequest;
import com.example.Qly_CLB_Bilar.Entity.Permisstion;
import com.example.Qly_CLB_Bilar.Entity.Roles;
import com.example.Qly_CLB_Bilar.Mapper.RoleMapper;
import com.example.Qly_CLB_Bilar.Repository.PermissrionRepository;
import com.example.Qly_CLB_Bilar.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissrionRepository permissrionRepository;
    public RoleRequest Craete(RoleRequest request){
        Roles newRole = roleMapper.toRoles(request);

        Set<Permisstion> permisstions = new HashSet<>(
                permissrionRepository.findAllById(request.getPermisstionName()));

        newRole.setPermisstion(permisstions);
        roleRepository.save(newRole);
        return request;
    }

    public Iterable<Roles> GetAll(){
        return (roleRepository.findAll());
    }
}
