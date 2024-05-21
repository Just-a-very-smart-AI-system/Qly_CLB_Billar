package com.example.Qly_CLB_Bilar.Mapper;

import com.example.Qly_CLB_Bilar.DTO.Request.TimeKeepingRequest;
import com.example.Qly_CLB_Bilar.Entity.TimeKeeping;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TimeKeepingMapper {
    TimeKeeping toTimeKeeping(TimeKeepingRequest timeKeepingRequest);
}
