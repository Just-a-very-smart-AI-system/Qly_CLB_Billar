package com.example.Qly_CLB_Bilar.Service;

import com.example.Qly_CLB_Bilar.DTO.Request.DetailBillRequest;
import com.example.Qly_CLB_Bilar.Entity.DetailBill;
import com.example.Qly_CLB_Bilar.Mapper.DetailBillMapper;
import com.example.Qly_CLB_Bilar.Repository.DetailBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailBillService {
    @Autowired
    private DetailBillRepository detailBillRepository;
    @Autowired
    private DetailBillMapper detailBillMapper;

    public Iterable<DetailBill> GetAll(){
        return detailBillRepository.findAll();
    }
    public DetailBill FindId(String Id){
        return detailBillRepository.findById(Id).orElseThrow(()->new RuntimeException("Không tồn tại Id;" + Id));
    }
    public DetailBill Create(DetailBillRequest detailBillRequest){
        DetailBill newDetailBill = detailBillMapper.toDetailBill(detailBillRequest);
        return detailBillRepository.save(newDetailBill);
    }
    public DetailBill Update(String Id, DetailBillRequest detailBillRequest){
        DetailBill newDetailBill = FindId(Id);
        newDetailBill = detailBillMapper.toDetailBill(detailBillRequest);
        return detailBillRepository.save(newDetailBill);
    }
}
