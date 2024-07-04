package com.example.Qly_CLB_Bilar.Repository;

import com.example.Qly_CLB_Bilar.Entity.Permisstion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissrionRepository extends JpaRepository<Permisstion, String> {
}
