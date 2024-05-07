package com.example.Qly_CLB_Bilar.Controller;

import com.example.Qly_CLB_Bilar.Entity.Supplier;
import com.example.Qly_CLB_Bilar.Repository.SupplierRepository;
import com.example.Qly_CLB_Bilar.Service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private SupplierService supplierService;
    @GetMapping("/getall")
    public Iterable<Supplier> GetAll(){
        return supplierRepository.findAll();
    }
    @GetMapping("/findid/{Id}")
    public Supplier FindId(@PathVariable("Id") String Id){
        return supplierRepository.findById(Id).orElseThrow(()->new RuntimeException("Không tìm thấy ID:" + Id));
    }
    @PostMapping("/create")
    public Supplier Create(@RequestBody Supplier supplier){
        if(supplierRepository.existsById(supplier.getSupplierId())){
            throw new RuntimeException("Id đã tồn tại");
        }
        else{
            return supplierRepository.save(supplier);
        }
    }
    @PutMapping("/update/{Id}")
    public Supplier Update(@PathVariable("Id") String Id, @RequestBody Supplier newSupplier){
        Supplier oldSupplier = FindId(Id);
        oldSupplier.setAddress(newSupplier.getAddress());
        oldSupplier.setName(newSupplier.getName());
        oldSupplier.setSdt(newSupplier.getSdt());

        return supplierRepository.save(oldSupplier);
    }
}
