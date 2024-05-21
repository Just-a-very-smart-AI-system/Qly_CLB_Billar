package com.example.Qly_CLB_Bilar.Repository;

import com.example.Qly_CLB_Bilar.Entity.Enum.BillStatus;
import com.example.Qly_CLB_Bilar.Entity.Goods;
import com.example.Qly_CLB_Bilar.Entity.ImportInvoice;
import com.example.Qly_CLB_Bilar.Entity.Staff;
import com.example.Qly_CLB_Bilar.Entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ImportRepository extends JpaRepository<ImportInvoice, String> {
    Iterable<ImportInvoice> findByGoods(Goods goods);
    Iterable<ImportInvoice> findByStaff(Staff staff);
    Iterable<ImportInvoice> findBySupplier(Supplier supplier);
    Iterable<ImportInvoice> findByStatus(BillStatus billStatus);
    @Query(value = "SELECT * FROM import_invoice where Address LIKE %:x%", nativeQuery = true)
    Iterable<ImportInvoice> findByAddress(@Param("x") String x);
    @Query(value = "SELECT * FROM import_invoice WHERE Quantity <= :x", nativeQuery = true)
    Iterable<ImportInvoice> findByQuantityAfter(@Param("x") int x);
    @Query(value = "SELECT * FROM import_invoice WHERE Quantity >= :x", nativeQuery = true)
    Iterable<ImportInvoice> findByQuantityBefore(@Param("x") int x);
    @Query(value = "SELECT * FROM import_invoice WHERE Time BETWEEN :start and :end", nativeQuery = true)
    Iterable<ImportInvoice> findByDateBW(@Param("start") LocalDate start,@Param("end") LocalDate end);
    @Query(value = "SELECT * FROM import_invoice WHERE Price >= :x", nativeQuery = true)
    Iterable<ImportInvoice> findByPriceBefore(@Param("x") float x);
    @Query(value = "SELECT * FROM import_invoice WHERE Price <= :x  ", nativeQuery = true)
    Iterable<ImportInvoice> findByPriceAfter(@Param("x") float x);
    @Query(value = "SELECT * FROM import_invoice WHERE Cost >= :x", nativeQuery = true)
    Iterable<ImportInvoice> findByCostBefore(@Param("x") float x);
    @Query(value = "SELECT * FROM import_invoice WHERE Cost <= :x", nativeQuery = true)
    Iterable<ImportInvoice> findByCostAfter(@Param("x") float x);
}
    