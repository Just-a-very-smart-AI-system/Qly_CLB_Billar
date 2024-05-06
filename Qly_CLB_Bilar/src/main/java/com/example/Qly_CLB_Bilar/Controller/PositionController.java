package com.example.Qly_CLB_Bilar.Controller;

import com.example.Qly_CLB_Bilar.Entity.Position;
import com.example.Qly_CLB_Bilar.Repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/position")
public class PositionController {
    @Autowired
    private PositionRepository positionRepository;

    @GetMapping("/getall")
    public Iterable<Position> GetAll(){
        return positionRepository.findAll();
    }
    @GetMapping("/findid/{Id}")
    public Position FindId(@PathVariable("Id") String Id){
        return positionRepository.findById(Id).orElseThrow(() -> new IllegalArgumentException("Không tìm thấy ID:" + Id));
    }
    @PutMapping("/create")
    public Position Create(@RequestBody Position position){
        return positionRepository.save(position);
    }
    @PutMapping("/update/{Id}")
    public Position Update(@PathVariable("Id") String Id, @RequestBody Position newPosition){
        Position position = FindId(Id);
        position.setPaidHour(newPosition.getPaidHour());
        position.setTypeSalary(newPosition.getTypeSalary());
        return positionRepository.save(position);
    }
}
