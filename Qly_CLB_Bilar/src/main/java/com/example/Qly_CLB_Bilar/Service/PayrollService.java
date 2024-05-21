package com.example.Qly_CLB_Bilar.Service;

import com.example.Qly_CLB_Bilar.DTO.Request.PayrollRequest;
import com.example.Qly_CLB_Bilar.Entity.Payroll;
import com.example.Qly_CLB_Bilar.Mapper.PayrollMapper;
import com.example.Qly_CLB_Bilar.Repository.PayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayrollService {
    @Autowired
    private PayrollRepository payrollRepository;
    @Autowired
    private PayrollMapper payrollMapper;

    public Iterable<Payroll> GetAll(){
        return payrollRepository.findAll();
    }
    public Payroll FindId(String Id){
        return payrollRepository.findById(Id).orElseThrow(()->new RuntimeException("Không tồn tại Id;" + Id));
    }
    public Payroll Create(PayrollRequest payrollRequest){
        Payroll newPayroll = payrollMapper.toPayroll(payrollRequest);
        return payrollRepository.save(newPayroll);
    }
    public Payroll Update(String Id, PayrollRequest payrollRequest){
        Payroll newPayroll = FindId(Id);
        newPayroll = payrollMapper.toPayroll(payrollRequest);
        return payrollRepository.save(newPayroll);
    }
}
