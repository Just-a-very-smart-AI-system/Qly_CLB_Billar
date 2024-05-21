package com.example.Qly_CLB_Bilar.Controller;

import com.example.Qly_CLB_Bilar.DTO.Request.DetailBillRequest;
import com.example.Qly_CLB_Bilar.Entity.DetailBill;
import com.example.Qly_CLB_Bilar.Service.DetailBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/detailbill")
public class DetailBillController {
    @Autowired
    private DetailBillService detailBillService;
    @GetMapping("/getall")
    public Iterable<DetailBill> GetAll(){
        return detailBillService.GetAll();
    }
    @GetMapping("/findid/{Id}")
    public DetailBill FindId(String Id){
        return detailBillService.FindId(Id);
    }
    @PutMapping("/create")
    public DetailBill Create(@RequestBody DetailBillRequest detailBillRequest){
        return detailBillService.Create(detailBillRequest);
    }
    @PostMapping("/update/{Id}")
    public DetailBill Update(@PathVariable("Id") String Id, @RequestBody DetailBillRequest detailBillRequest){
        return detailBillService.Update(Id, detailBillRequest);
    }
}
