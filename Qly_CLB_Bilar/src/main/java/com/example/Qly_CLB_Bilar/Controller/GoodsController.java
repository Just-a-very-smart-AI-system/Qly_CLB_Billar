package com.example.Qly_CLB_Bilar.Controller;

import com.example.Qly_CLB_Bilar.Entity.Goods;
import com.example.Qly_CLB_Bilar.Repository.GoodsRepository;
import com.example.Qly_CLB_Bilar.Service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsRepository goodsRepository;
    @Autowired
    private GoodsService goodsService;

    @GetMapping("/getall")
    public Iterable<Goods> GetAll(){
        return goodsRepository.findAll();
    }
    @GetMapping("/findid/{Id}")
    public Goods FindId(@PathVariable("Id") String Id){
        return goodsRepository.findById(Id).orElseThrow(()->new RuntimeException("Không tìm thấy ID:"+ Id));
    }
    @PostMapping("/create")
    public Goods Create(@RequestBody Goods goods){
        if(goodsRepository.existsById(goods.getGoodsId())){
            throw new RuntimeException("Id đã tồn tại");
        }
        else{
            return goodsRepository.save(goods);
        }
    }
    @PostMapping("/update/{Id}")
    public Goods Update(@PathVariable("Id") String Id, @RequestBody Goods newGoods){
        Goods oldGoods = FindId(Id);

        oldGoods.setCost(newGoods.getCost());
        oldGoods.setName(newGoods.getName());
        oldGoods.setInventory(newGoods.getInventory());
        oldGoods.setType(newGoods.getType());
        oldGoods.setPrice(newGoods.getPrice());
        oldGoods.setUnit(newGoods.getUnit());

        return goodsRepository.save(oldGoods);
    }

}
