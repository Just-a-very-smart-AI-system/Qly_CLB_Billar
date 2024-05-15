package com.example.Qly_CLB_Bilar.Repository;

import com.example.Qly_CLB_Bilar.Entity.Bill;
import com.example.Qly_CLB_Bilar.Entity.Enum.BillStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, String> {

    Iterable<Bill> findByStatus(@Param("billStatus") BillStatus billStatus);
    @Query(value = "SELECT * FROM bill WHERE Paid >= :paid", nativeQuery = true)
    Iterable<Bill> findByPaid(@Param("paid") float paid);
    @Query(value = "select * from bill where date = :date", nativeQuery = true)
    List<Bill> findByDate(@Param("date") LocalDate date);
    @Query(value = "SELECT * FROM Bill WHERE date BETWEEN :x AND :y", nativeQuery = true)
    List<Bill> findBillsBetwenDates(@Param("x") LocalDate x, @Param("y") LocalDate y);
    @Query(value = "SELECT * FROM bill WHERE time_arrive >= :x AND time_out <= :y AND date = :date", nativeQuery = true)
    List<Bill> findBillByTime(@Param("date") LocalDate date, @Param("x") LocalTime x,@Param("y") LocalTime y);
}
