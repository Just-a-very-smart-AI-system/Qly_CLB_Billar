package com.example.Qly_CLB_Bilar.Repository;

import com.example.Qly_CLB_Bilar.Entity.Payroll;
import com.example.Qly_CLB_Bilar.Entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface PayrollRepository extends JpaRepository<Payroll, String> {
    Iterable<Payroll> findByStaff(Staff staff);
    @Query(value = "SELECT * FROM payroll WHERE Date BETWEEN :start and :end", nativeQuery = true)
    Iterable<Payroll> findByDateBetween(@Param("start") LocalDate start, @Param("end") LocalDate end);
    @Query(value = "SELECT SUM(total_money) FROM payroll WHERE Date BETWEEN :start and :end", nativeQuery = true)
    Float getTotalMoneyBetween(@Param("start") LocalDate start, @Param("end") LocalDate end);
}
