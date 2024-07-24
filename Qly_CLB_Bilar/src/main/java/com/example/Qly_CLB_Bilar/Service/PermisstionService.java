package com.example.Qly_CLB_Bilar.Service;

import com.example.Qly_CLB_Bilar.Entity.Permisstion;
import com.example.Qly_CLB_Bilar.Repository.PermissrionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermisstionService{
    @Autowired
    private PermissrionRepository permissrionRepository;

    public Permisstion Create(Permisstion permisstion){
        return permissrionRepository.save(permisstion);
    }
    public Iterable<Permisstion> GetAll(){
        return permissrionRepository.findAll();
    }

}
