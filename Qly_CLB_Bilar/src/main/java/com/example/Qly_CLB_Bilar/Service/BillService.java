package com.example.Qly_CLB_Bilar.Service;

import com.example.Qly_CLB_Bilar.DTO.BillRequset;
import com.example.Qly_CLB_Bilar.Entity.Bill;
import com.example.Qly_CLB_Bilar.Mapper.BillMapper;
import com.example.Qly_CLB_Bilar.Repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.sql.Timestamp;

import static com.example.Qly_CLB_Bilar.Entity.Enum.BillStatus.CHƯA_THANH_TOÁN;
import static com.example.Qly_CLB_Bilar.Entity.Enum.BillStatus.ĐÃ_THANH_TOÁN;

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
    public Iterable<Bill> FindStatust(boolean billStatus){
        if(!billStatus){
            return billRepository.findByStatus(CHƯA_THANH_TOÁN);
        }else{
            return billRepository.findByStatus(ĐÃ_THANH_TOÁN);
        }
    }
    public Iterable<Bill> FindByPaid(float paid){
        if(paid < 0){
            throw new RuntimeException("Giá tiền không được âm!");
        }
        else{
            return billRepository.findByPaid(paid);
        }
    }
    public Iterable<Bill> FindByDate(LocalDate date){
        List<Bill> list = billRepository.findByDate(date);
        if(list.isEmpty()){
            throw new RuntimeException("Không có ngày này trong dữ liệu!");
        }
        else{
            return list;
        }
    }
    public Iterable<Bill> FindByDateBW(LocalDate start, LocalDate end){
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        List<Bill> list = billRepository.findBillsBetwenDates(start, end);
        if(start.isAfter(currentTime.toLocalDateTime().toLocalDate())){
            throw new RuntimeException("Ngày bắt đầu vượt quá thời gian hiện tại!");
        }
         else if(list.isEmpty()){
            throw new RuntimeException("Không có những ngày này trong dữ liệu!");
        }
        else{
            return list;
        }
    }
    public Iterable<Bill> FindByTime(LocalDate date, LocalTime start, LocalTime end){
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        List<Bill> list = billRepository.findBillByTime(date, start, end);
        if(date.isAfter(currentTime.toLocalDateTime().toLocalDate())){
            throw new RuntimeException("Ngày bắt đầu vượt quá thời gian hiện tại!");
        }
        else if(list.isEmpty()){
            throw new RuntimeException("Không có những ngày này trong dữ liệu!");
        }
        else{
            return list;
        }
    }
}
