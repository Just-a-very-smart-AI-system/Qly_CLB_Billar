package com.example.Qly_CLB_Bilar.Service;

import com.example.Qly_CLB_Bilar.Repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffService {
    @Autowired
    private StaffRepository staffRepository;
}
