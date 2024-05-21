package com.example.Qly_CLB_Bilar.Repository;

import com.example.Qly_CLB_Bilar.Entity.Customer;
import com.example.Qly_CLB_Bilar.Entity.Enum.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

    Iterable<Customer> findByAddress(String address);
    @Query(value = "SELECT * FROM customer WHERE Name LIKE %:name%", nativeQuery = true)
    Iterable<Customer> findByName(@Param("name") String name);
    Iterable<Customer> findByGender(Gender gender);
    Iterable<Customer> findBySdt(String Sdt);
    @Query(value = "select * from customer where money_paid >= :money", nativeQuery = true)
    Iterable<Customer> findByMoneyPaid(@Param("money") float money);
    @Query(value = "select * from customer where total_money >= :money", nativeQuery = true)
    Iterable<Customer> findByTotalMoney(@Param("money") float money);
}
