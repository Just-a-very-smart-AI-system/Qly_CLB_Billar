package com.example.Qly_CLB_Bilar.DTO.Request;

import com.example.Qly_CLB_Bilar.Entity.Enum.GoodsType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsRequest {

    private String goodsId;

    private String name;

    private float price;

    private float cost;

    private short inventory;

    private String unit;

    private GoodsType type;

}
