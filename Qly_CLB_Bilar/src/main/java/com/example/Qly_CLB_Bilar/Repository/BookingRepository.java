package com.example.Qly_CLB_Bilar.Repository;

import com.example.Qly_CLB_Bilar.Entity.Booking;
import com.example.Qly_CLB_Bilar.Entity.Customer;
import com.example.Qly_CLB_Bilar.Entity.Staff;
import com.example.Qly_CLB_Bilar.Entity.Table_Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;

@Repository
public interface BookingRepository extends JpaRepository<Booking,String> {
    Iterable<Booking> findByCustomer(Customer CustomerId);
    Iterable<Booking> findByStaff(Staff staff);
    Iterable<Booking> findByTableData(Table_Data tableData);
    Iterable<Booking> findByDate(LocalDate date);
    @Query(value = "SELECT * from booking where Slot >= :slot", nativeQuery = true)
    Iterable<Booking> findBySlot(@Param("slot") Integer slot);
    @Query(value = "SELECT * FROM booking WHERE time_arrive >= :x AND time_play <= :y AND Date = :date", nativeQuery = true)
    Iterable<Booking> findByTime(@Param("date") LocalDate date, @Param("x") LocalTime x, @Param("y") LocalTime y);
}
