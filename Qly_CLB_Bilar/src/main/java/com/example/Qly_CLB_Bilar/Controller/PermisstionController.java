package com.example.Qly_CLB_Bilar.Controller;

import com.example.Qly_CLB_Bilar.Entity.Permisstion;
import com.example.Qly_CLB_Bilar.Service.PermisstionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/permisstion")
@PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
public class PermisstionController {
    @Autowired
    private PermisstionService permisstionService;

    @GetMapping("/getall")
    public Iterable<Permisstion> GetAll(){
        return permisstionService.GetAll();
    }
    @PostMapping("/create")
    public Permisstion Create(@RequestBody Permisstion permisstion){
        return permisstionService.Create(permisstion);
    }
}
