package com.example.Qly_CLB_Bilar.Controller;

import com.example.Qly_CLB_Bilar.DTO.Request.RoleRequest;
import com.example.Qly_CLB_Bilar.Entity.Permisstion;
import com.example.Qly_CLB_Bilar.Entity.Roles;
import com.example.Qly_CLB_Bilar.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RolesController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/getall")
    public Iterable<Roles> GetAll(){
        return roleService.GetAll();
    }
    @PostMapping("/create")
    public RoleRequest Create(RoleRequest roleRequest){
        return roleService.Craete(roleRequest);
    }
}
