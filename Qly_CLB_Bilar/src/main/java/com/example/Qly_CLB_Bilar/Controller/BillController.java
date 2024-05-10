package com.example.Qly_CLB_Bilar.Controller;

import com.example.Qly_CLB_Bilar.DTO.BillRequset;
import com.example.Qly_CLB_Bilar.Entity.Bill;
import com.example.Qly_CLB_Bilar.Repository.BillRepository;
import com.example.Qly_CLB_Bilar.Service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/bill")
public class BillController {
    @Autowired
    private BillService billService;

    @Autowired
    private BillRepository test;

    @GetMapping("/getall")
    public Iterable<Bill> getAll(){
        return billService.GetAll();
    }

    @GetMapping("/findId/{Id}")
    public Bill getId(@PathVariable("Id") String Id){
        return billService.FindId(Id);
    }

    @PostMapping("/create")
    public Bill Create(@RequestBody Bill bill){
        return billService.CreateBill(bill);
    }

    @DeleteMapping("/delete/{Id}")
    public void Delete (@PathVariable String Id){
        billService.Delete(Id);
    }

    @PutMapping("/update")
    public Bill Update(@RequestBody BillRequset bill){
        return billService.Update(bill);
    }


}
