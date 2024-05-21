package com.example.Qly_CLB_Bilar.Repository;

import com.example.Qly_CLB_Bilar.Entity.Staff;
import com.example.Qly_CLB_Bilar.Entity.TimeKeeping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface TimeKeepingRepository extends JpaRepository<TimeKeeping, String> {
    Iterable<TimeKeeping> findByStaff(Staff staff);
    Iterable<TimeKeeping> findByWorkingDay(LocalDate date);
    @Query(value = "SELECT TIMESTAMPDIFF(HOUR, time_in, time_out) FROM time_keeping WHERE working_day = :date and Staff_ID = :staff", nativeQuery = true)
    int getByTimeWorking(@Param("date") LocalDate date,@Param("staff") Staff staff);
}
