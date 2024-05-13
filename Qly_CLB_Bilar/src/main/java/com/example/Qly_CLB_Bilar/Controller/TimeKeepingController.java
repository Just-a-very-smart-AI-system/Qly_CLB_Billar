package com.example.Qly_CLB_Bilar.Controller;

import com.example.Qly_CLB_Bilar.DTO.TimeKeepingRequest;
import com.example.Qly_CLB_Bilar.Entity.TimeKeeping;
import com.example.Qly_CLB_Bilar.Service.TimeKeepingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/timekeeping")
public class TimeKeepingController {
    @Autowired
    private TimeKeepingService timeKeepingService;

    @GetMapping("/getall")
    public Iterable<TimeKeeping> GetAll(){
        return timeKeepingService.GetAll();
    }
    @GetMapping("/findid/{Id}")
    public TimeKeeping FindId(@PathVariable("Id") String Id){
        return timeKeepingService.FindId(Id);
    }
    @PutMapping("/create")
    public TimeKeeping Create(@RequestBody TimeKeepingRequest timeKeepingRequest){
        return timeKeepingService.Create(timeKeepingRequest);
    }
    @PostMapping("/Update/{Id}")
    public TimeKeeping Update(@PathVariable("Id") String Id, @RequestBody TimeKeepingRequest timeKeepingRequest){
        return timeKeepingService.Update(Id,timeKeepingRequest);
    }
}
