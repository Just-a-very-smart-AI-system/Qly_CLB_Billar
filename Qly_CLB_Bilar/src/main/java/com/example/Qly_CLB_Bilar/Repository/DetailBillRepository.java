package com.example.Qly_CLB_Bilar.Repository;

import com.example.Qly_CLB_Bilar.Entity.Bill;
import com.example.Qly_CLB_Bilar.Entity.Booking;
import com.example.Qly_CLB_Bilar.Entity.DetailBill;
import com.example.Qly_CLB_Bilar.Entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailBillRepository extends JpaRepository<DetailBill, String> {
    Iterable<DetailBill> findByBill(Bill bill);
    Iterable<DetailBill> findByGoods(Goods goods);
    Iterable<DetailBill> findByBooking(Booking booking);
    @Query(value = "SELECT * FROM detail_bill WHERE Quantity >= :quantity", nativeQuery = true)
    Iterable<DetailBill> findByQuantity(@Param("quantity") int quantity);
}
