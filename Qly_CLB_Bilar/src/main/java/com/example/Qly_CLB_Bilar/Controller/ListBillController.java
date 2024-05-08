package com.example.Qly_CLB_Bilar.Controller;

import com.example.Qly_CLB_Bilar.Entity.ListBill;
import com.example.Qly_CLB_Bilar.Repository.ListBillRepository;
import com.example.Qly_CLB_Bilar.Service.ListBillService;
import org.hibernate.annotations.processing.Find;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/listbill")
public class ListBillController {
    @Autowired
    private ListBillRepository listBillRepository;
    @Autowired
    private ListBillService listBillService;

    @GetMapping("/getall")
    public Iterable<ListBill> GetAll(){
        return listBillRepository.findAll();
    }
    @GetMapping("/findid/{Id}")
    public ListBill FindId(@PathVariable("Id") String Id){
        return listBillRepository.findById(Id).orElseThrow(()->new RuntimeException("Không tìm thấy ID:" + Id));
    }
    @PutMapping("/update/{Id}")
    public ListBill Update(@PathVariable("Id") String Id, @RequestBody ListBill newList){
        ListBill oldList = FindId(Id);

        oldList.setCustomer(newList.getCustomer());
        oldList.setBill(newList.getBill());
        oldList.setChange(newList.getChange());
        oldList.setTotalMoney(newList.getTotalMoney());
        oldList.setPayMethod(newList.getPayMethod());

        return listBillRepository.save(oldList);
    }
    @PostMapping("/create")
    public ListBill Create(@RequestBody ListBill listBill){
        if(listBillRepository.existsById(listBill.getList_id())){
            throw new RuntimeException("Id đã tồn tại");
        }
        else{
            return listBillRepository.save(listBill);
        }
    }
}
