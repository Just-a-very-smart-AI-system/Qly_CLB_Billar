package com.example.Qly_CLB_Bilar.Controller;

import com.example.Qly_CLB_Bilar.Entity.Customer;
import com.example.Qly_CLB_Bilar.Repository.CustomerRepository;
import com.example.Qly_CLB_Bilar.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerService customerService;

    @GetMapping("/getall")
    public Iterable<Customer> GetAll(){
        return customerRepository.findAll();
    }
    @GetMapping("/findid/{Id}")
    public Customer FindId(@PathVariable("Id") String Id){
        return customerRepository.findById(Id).orElseThrow(()->new RuntimeException("Không tìm thấy ID:"+ Id));
    }
    @PostMapping("/create")
    public Customer Craete(@RequestBody Customer customer){
        if(customerRepository.existsById(customer.getCustomerId())){
            throw new RuntimeException("Id đã tồn tại");
        }
        else {
            return customerRepository.save(customer);
        }
    }
    @PutMapping("/update/{Id}")
    public Customer Update(@PathVariable("Id") String Id, @RequestBody Customer newCustomer){
        Customer oldCustomer = FindId(Id);
        oldCustomer.setAddress(newCustomer.getAddress());
        oldCustomer.setName(newCustomer.getName());
        oldCustomer.setBirthday(newCustomer.getBirthday());
        oldCustomer.setGender(newCustomer.getGender());
        oldCustomer.setSdt(newCustomer.getSdt());
        oldCustomer.setMoneyPaid(newCustomer.getMoneyPaid());
        oldCustomer.setTotalMoney(newCustomer.getTotalMoney());

        return customerRepository.save(oldCustomer);
    }
}
