package com.example.Qly_CLB_Bilar.Controller;

import com.example.Qly_CLB_Bilar.Entity.ImportInvoice;
import com.example.Qly_CLB_Bilar.Repository.ImportRepository;
import com.example.Qly_CLB_Bilar.Service.ImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/import")
public class ImportController {
    @Autowired
    private ImportRepository importRepository;
    @Autowired
    private ImportService importService;

    @GetMapping("/getall")
    public Iterable<ImportInvoice> GetAll(){
        return importRepository.findAll();
    }
    @GetMapping("/findid/{Id}")
    public ImportInvoice FindId(@PathVariable("Id") String Id){
        return importRepository.findById(Id).orElseThrow(()->new RuntimeException("Không tìm thấy ID:" + Id));
    }
    @PostMapping("/create")
    public ImportInvoice Create(@RequestBody ImportInvoice importInvoice){
        if(importRepository.existsById(importInvoice.getImportInvoiceId())){
            throw new RuntimeException("Id đã tồn tại");
        }
        else{
            return importRepository.save(importInvoice);
        }
    }
    @PutMapping("/update/{Id}")
    public ImportInvoice Update(@PathVariable("Id") String Id, @RequestBody ImportInvoice newImport){
        ImportInvoice oldImport = FindId(Id);
        oldImport.setAddress(newImport.getAddress());
        oldImport.setCost(newImport.getCost());
        oldImport.setGoods(newImport.getGoods());
        oldImport.setPrice(newImport.getPrice());
        oldImport.setDiscount(newImport.getDiscount());
        oldImport.setSupplier(newImport.getSupplier());
        oldImport.setStaff(newImport.getStaff());
        oldImport.setStatus(newImport.getStatus());
        oldImport.setTime(newImport.getTime());
        oldImport.setQuantity(newImport.getQuantity());

        return importRepository.save(oldImport);
    }
}
