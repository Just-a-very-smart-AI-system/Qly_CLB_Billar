package com.example.Qly_CLB_Bilar.Mapper;

import com.example.Qly_CLB_Bilar.DTO.Request.GoodsRequest;
import com.example.Qly_CLB_Bilar.Entity.Goods;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GoodsMapper {
    Goods toGoods(GoodsRequest goodsRequset);
}
