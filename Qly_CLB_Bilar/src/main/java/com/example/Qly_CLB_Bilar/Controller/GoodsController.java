package com.example.Qly_CLB_Bilar.Controller;

import com.example.Qly_CLB_Bilar.DTO.GoodsRequest;
import com.example.Qly_CLB_Bilar.Entity.Goods;
import com.example.Qly_CLB_Bilar.Mapper.GoodsMapper;
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
    @Autowired
    GoodsMapper goodsMapper;

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
    public Goods Update(@PathVariable("Id") String Id, @RequestBody GoodsRequest newGoods){
        Goods oldGoods = goodsMapper.toGoods(newGoods);
        return goodsRepository.save(oldGoods);
    }

}
