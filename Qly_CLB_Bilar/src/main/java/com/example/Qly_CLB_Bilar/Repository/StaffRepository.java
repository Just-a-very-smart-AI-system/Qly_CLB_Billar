package com.example.Qly_CLB_Bilar.Repository;

import com.example.Qly_CLB_Bilar.Entity.Enum.Gender;
import com.example.Qly_CLB_Bilar.Entity.Position;
import com.example.Qly_CLB_Bilar.Entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface StaffRepository extends JpaRepository<Staff, String> {
    @Query(value = "SELECT * FROM staff where address like %x%", nativeQuery = true)
    Iterable<Staff> findByAddress(@Param("x") String x);
    Iterable<Staff> findByName(String name);
    Iterable<Staff> findBySdt(String SDT);
    Iterable<Staff> findByGender(Gender gender);
    Iterable<Staff> findByPosition(Position position);
    @Query(value = "SELECT * FROM staff where Birthday >= :date", nativeQuery = true)
    Iterable<Staff> findByBirthdayAfter(@Param("date") LocalDate date);
}
