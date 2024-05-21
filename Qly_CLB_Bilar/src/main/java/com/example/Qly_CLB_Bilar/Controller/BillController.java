package com.example.Qly_CLB_Bilar.Controller;

import com.example.Qly_CLB_Bilar.DTO.Request.BillRequset;
import com.example.Qly_CLB_Bilar.Entity.Bill;
import com.example.Qly_CLB_Bilar.Entity.Customer;
import com.example.Qly_CLB_Bilar.Entity.DetailBill;
import com.example.Qly_CLB_Bilar.Service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;

@RestController
@RequestMapping("/bill")
public class BillController {
    @Autowired
    private BillService billService;

    @GetMapping("/getall")
    public Iterable<Bill> getAll(){
        return billService.GetAll();
    }

    @GetMapping("/findId/{Id}")
    public Bill getId(@PathVariable("Id") String Id){
        return billService.FindId(Id);
    }
    @GetMapping("/findstatust/{status}")
    public Iterable<Bill> FindByStatust(@PathVariable("status") boolean status){
        return billService.FindStatust(status);
    }
    @GetMapping("/findpaid")
    public Iterable<Bill> FindByPaid(@RequestParam("paid") float paid){
        return billService.FindByPaid(paid);
    }
    @GetMapping("/finddate")
    public Iterable<Bill>FindByDate(@RequestParam("date")LocalDate date){
        return billService.FindByDate(date);
    }
    @GetMapping("/findatebw")
    public Iterable<Bill>FindByDateBW(@RequestParam LocalDate dateStart, @RequestParam() LocalDate dateEnd){
        return billService.FindByDateBW(dateStart, dateEnd);
    }
    @GetMapping("/findtime")
    public Iterable<Bill> FindByTime(@RequestParam() LocalDate date, @RequestParam() LocalTime start , @RequestParam() LocalTime end){
        return billService.FindByTime(date, start, end);
    }
    @GetMapping("/findcustomer/{Id}")
    public Iterable<Bill> FindbyCustomer(@PathVariable("Id") Customer customer){
        return billService.FindByCustomer(customer);
    }
    @GetMapping("/getdetail/{Id}")
    public Iterable<DetailBill> FindDetailBill(@PathVariable("Id") Bill bill){
        return billService.FindDetailBill(bill);
    }
    @PostMapping("/create")
    public Bill Create(@RequestBody BillRequset bill){
        return billService.CreateBill(bill);
    }

    @DeleteMapping("/delete/{Id}")
    public void Delete (@PathVariable String Id){
        billService.Delete(Id);
    }

    @PutMapping("/update/{Id}")
    public Bill Update(@PathVariable("Id") String Id, @RequestBody BillRequset bill){
        return billService.Update(Id, bill);
    }

}
