package com.example.Qly_CLB_Bilar.Controller;

import com.example.Qly_CLB_Bilar.DTO.Request.PayrollRequest;
import com.example.Qly_CLB_Bilar.Entity.Payroll;
import com.example.Qly_CLB_Bilar.Service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payroll")
public class PayrollController {
    @Autowired
    private PayrollService payrollService;
    @GetMapping("/getall")
    public Iterable<Payroll> GetAll(){
        return payrollService.GetAll();
    }
    @GetMapping("/findid/{Id}")
    public Payroll FindId(String Id){
        return payrollService.FindId(Id);
    }
    @PutMapping("/create")
    public Payroll Create(@RequestBody PayrollRequest payrollRequest){
        return payrollService.Create(payrollRequest);
    }
    @PostMapping("/update/{Id}")
    public Payroll Update(@PathVariable("Id") String Id, @RequestBody PayrollRequest payrollRequest){
        return payrollService.Update(Id, payrollRequest);
    }
}
