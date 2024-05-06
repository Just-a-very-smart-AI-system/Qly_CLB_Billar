package com.example.Qly_CLB_Bilar.Service;

import com.example.Qly_CLB_Bilar.Entity.Bill;
import com.example.Qly_CLB_Bilar.Repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

@Service
@Configurable
public class BillService {
    @Autowired
    private BillRepository billRepository;

    public Iterable<Bill> GetAll() {
        return billRepository.findAll();
    }
    public Bill FindId(String Id){
        return billRepository.findById(Id).orElseThrow(() -> new IllegalArgumentException("Không tìm thấy ID:" + Id));
    }
    public Bill CreateBill(Bill bill){
        return billRepository.save(bill);
    }

    public Bill Update(Bill updatedBill, String Id){
        Bill bill = FindId(Id);
        bill.setBillId(updatedBill.getBillId());
        bill.setNote(updatedBill.getNote());
        bill.setCost(updatedBill.getCost());
        bill.setPaid(updatedBill.getPaid());
        bill.setDiscount(updatedBill.getDiscount());
        bill.setTimeArrive(updatedBill.getTimeArrive());
        bill.setTimeOut(updatedBill.getTimeOut());
        billRepository.save(bill);
        return bill;
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
