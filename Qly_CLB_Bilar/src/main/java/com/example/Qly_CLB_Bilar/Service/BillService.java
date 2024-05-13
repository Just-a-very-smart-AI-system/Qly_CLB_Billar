package com.example.Qly_CLB_Bilar.Service;

import com.example.Qly_CLB_Bilar.DTO.BillRequset;
import com.example.Qly_CLB_Bilar.Entity.Bill;
import com.example.Qly_CLB_Bilar.Mapper.BillMapper;
import com.example.Qly_CLB_Bilar.Repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

@Service
@Configurable
public class BillService {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private BillMapper billMapper;

    public Iterable<Bill> GetAll() {
        return billRepository.findAll();
    }
    public Bill FindId(String Id){
        return billRepository.findById(Id).orElseThrow(() -> new IllegalArgumentException("Không tìm thấy ID:" + Id));
    }
    public Bill CreateBill(BillRequset updatedBill){
        Bill bill = billMapper.toBill(updatedBill);
        return billRepository.save(bill);
    }

    public Bill Update(String Id, BillRequset updatedBill){
        Bill bill = FindId(Id);
        bill = billMapper.toBill(updatedBill);
        return billRepository.save(bill);
    }
    public void Delete(String Id){
        if(billRepository.existsById(Id)){
            billRepository.deleteById(Id);
        }
        else {
            throw new IllegalArgumentException("Không tìm thấy bill có ID: " + Id);
        }
    }

    
}
