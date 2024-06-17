package com.example.Qly_CLB_Bilar.Repository;

import com.example.Qly_CLB_Bilar.Entity.Staff;
import com.example.Qly_CLB_Bilar.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserRepository extends JpaRepository<User,String> {
    boolean existsByStaff(Staff staff);
    @Query(value = "select user.* from user join staff on user.Staff_ID = staff.Staff_ID where staff.Position_ID = 'P00101'", nativeQuery = true)
    List<User> findByStaffAdmin();
}
