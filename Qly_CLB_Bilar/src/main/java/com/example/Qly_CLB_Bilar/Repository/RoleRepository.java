package com.example.Qly_CLB_Bilar.Repository;

import com.example.Qly_CLB_Bilar.Entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Roles, String> {
}
