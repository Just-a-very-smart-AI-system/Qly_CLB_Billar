package com.example.Qly_CLB_Bilar.Mapper;

import com.example.Qly_CLB_Bilar.DTO.DetailBillRequest;
import com.example.Qly_CLB_Bilar.Entity.DetailBill;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DetailBillMapper {
    DetailBill toDetailBill(DetailBillRequest detailBillRequest);
}
