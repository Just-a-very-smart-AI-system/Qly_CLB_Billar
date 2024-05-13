package com.example.Qly_CLB_Bilar.Service;

import com.example.Qly_CLB_Bilar.DTO.TimeKeepingRequest;
import com.example.Qly_CLB_Bilar.Entity.TimeKeeping;
import com.example.Qly_CLB_Bilar.Mapper.TimeKeepingMapper;
import com.example.Qly_CLB_Bilar.Repository.TimeKeepingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeKeepingService {
    @Autowired
    private TimeKeepingRepository timeKeepingRepository;
    @Autowired
    private TimeKeepingMapper timeKeepingMapper;

    public Iterable<TimeKeeping> GetAll(){
        return timeKeepingRepository.findAll();
    }
    public TimeKeeping FindId(String Id){
        return timeKeepingRepository.findById(Id).orElseThrow(()->new RuntimeException("Không tìm thấy ID:" + Id));
    }
    public TimeKeeping Create(TimeKeepingRequest timeKeepingRequest){
        TimeKeeping newTimeKeeping = timeKeepingMapper.toTimeKeeping(timeKeepingRequest);
        return timeKeepingRepository.save(newTimeKeeping);
    }
    public TimeKeeping Update(String Id, TimeKeepingRequest timeKeepingRequest){
        TimeKeeping newTimeKeeping = FindId(Id);
        newTimeKeeping = timeKeepingMapper.toTimeKeeping(timeKeepingRequest);
        return timeKeepingRepository.save(newTimeKeeping);
    }

}
