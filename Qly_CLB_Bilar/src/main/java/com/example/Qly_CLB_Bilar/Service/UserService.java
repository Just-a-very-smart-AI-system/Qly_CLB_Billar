package com.example.Qly_CLB_Bilar.Service;

import com.example.Qly_CLB_Bilar.DTO.Request.UserRequest;
import com.example.Qly_CLB_Bilar.Entity.Staff;
import com.example.Qly_CLB_Bilar.Entity.User;
import com.example.Qly_CLB_Bilar.Mapper.UserMapper;
import com.example.Qly_CLB_Bilar.Repository.StaffRepository;
import com.example.Qly_CLB_Bilar.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StaffRepository staffRepository;

    public User Create(UserRequest userRequest){
        if(userRepository.existsById(userRequest.getUser_name())){
            throw new RuntimeException("User đã tồn tại!");
        }
        Staff staff = staffRepository.findById(userRequest.getStaffId()).orElseThrow(()->new RuntimeException("Không tồn tại staff ID:" + userRequest.getStaffId()));
        User newUser = userMapper.toUser(userRequest);
        newUser.setStaff(staff);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        newUser.setPassword(passwordEncoder.encode(userRequest.getPassword()));

        return userRepository.save(newUser);
    }
}
