package com.example.Qly_CLB_Bilar.Mapper;

import com.example.Qly_CLB_Bilar.DTO.Request.BillRequset;
import com.example.Qly_CLB_Bilar.Entity.Bill;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BillMapper {
    @Mapping(target = "customer", ignore = true)
    Bill toBill(BillRequset billRequset);
}