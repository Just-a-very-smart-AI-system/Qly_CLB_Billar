package com.example.Qly_CLB_Bilar.Repository;

import com.example.Qly_CLB_Bilar.Entity.Enum.GoodsType;
import com.example.Qly_CLB_Bilar.Entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, String> {
    Iterable<Goods> findByName(String name);
    Iterable<Goods> findByType(GoodsType goodsType);
    @Query(value = "SELECT * FROM goods WHERE Price >= :x", nativeQuery = true)
    Iterable<Goods> findByPrice(@Param("x") float x);
    @Query(value = "SELECT * FROM goods WHERE Cost >= :x", nativeQuery = true)
    Iterable<Goods> findByCost(@Param("x") float x);
    @Query(value = "SELECT * FROM goods WHERE Inventory <= :x", nativeQuery = true)
    Iterable<Goods> findByInventoryAfter(@Param("x") int x);
    @Query(value = "SELECT * FROM goods WHERE Inventory >= :x", nativeQuery = true)
    Iterable<Goods> findByInventoryBefore(@Param("x") int x);
}
