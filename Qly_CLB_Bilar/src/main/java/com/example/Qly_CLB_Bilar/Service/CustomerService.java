package com.example.Qly_CLB_Bilar.Service;

import com.example.Qly_CLB_Bilar.Entity.Customer;
import com.example.Qly_CLB_Bilar.Entity.Enum.Gender;
import com.example.Qly_CLB_Bilar.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    public Customer FindById(String Id){
        return customerRepository.findById(Id).orElseThrow(() -> new IllegalArgumentException("Không tìm thấy ID:" + Id));
    }
    public Iterable<Customer> FindByName(String name){
        return customerRepository.findByName(name);
    }
    public Iterable<Customer> FindByAddress(String address){
        return customerRepository.findByAddress(address);
    }
    public Iterable<Customer> FindBySdt(String Sdt){
        return customerRepository.findBySdt(Sdt);
    }
    public Iterable<Customer> FindByGender(Gender gender){
        return customerRepository.findByGender(gender);
    }
    public Iterable<Customer> FindByMoneyPaid(float money){
        return customerRepository.findByMoneyPaid(money);
    }
    public Iterable<Customer> FindByTotalMoney(float money){
        return customerRepository.findByTotalMoney(money);
    }
}
