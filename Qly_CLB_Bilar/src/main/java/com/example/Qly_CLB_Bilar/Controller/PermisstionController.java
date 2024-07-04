package com.example.Qly_CLB_Bilar.Controller;

import com.example.Qly_CLB_Bilar.Entity.Permisstion;
import com.example.Qly_CLB_Bilar.Service.PermisstionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/permisstion")
public class PermisstionController {
    @Autowired
    private PermisstionService permisstionService;

    @GetMapping("/getall")
    public Iterable<Permisstion> GetAll(){
        return permisstionService.GetAll();
    }
    @PostMapping("/create")
    public Permisstion Create(Permisstion permisstion){
        return permisstionService.Create(permisstion);
    }
}
