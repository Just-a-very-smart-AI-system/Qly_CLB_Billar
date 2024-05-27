package com.example.Qly_CLB_Bilar.Repository;

import com.example.Qly_CLB_Bilar.Entity.Staff;
import com.example.Qly_CLB_Bilar.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,String> {
    boolean existsByStaff(Staff staff);
}
