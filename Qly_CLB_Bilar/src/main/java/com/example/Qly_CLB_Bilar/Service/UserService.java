package com.example.Qly_CLB_Bilar.Service;

import com.example.Qly_CLB_Bilar.DTO.JWT.UserRequest;
import com.example.Qly_CLB_Bilar.Entity.Roles;
import com.example.Qly_CLB_Bilar.Entity.Staff;
import com.example.Qly_CLB_Bilar.Entity.User;
import com.example.Qly_CLB_Bilar.Mapper.UserMapper;
import com.example.Qly_CLB_Bilar.Repository.RoleRepository;
import com.example.Qly_CLB_Bilar.Repository.StaffRepository;
import com.example.Qly_CLB_Bilar.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private RoleRepository roleRepository;

    public User Create(UserRequest userRequest){
        if(userRepository.existsById(userRequest.getUser_name())){
            throw new RuntimeException("User name đã tồn tại!");
        }

        Staff staff = staffRepository.findById(userRequest.getStaffId())
                .orElseThrow(()->new RuntimeException("Không tồn tại staff ID:" + userRequest.getStaffId()));

        if(userRepository.existsByStaff(staff)){
            throw new RuntimeException("Nhân viên đã có tài khoản!");
        }

        Set<Roles> roles = new HashSet<>(roleRepository.findAllById(userRequest.getRoles()));

        User newUser = userMapper.toUser(userRequest);
        newUser.setRoles(roles);
        newUser.setStaff(staff);

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        newUser.setPassword(passwordEncoder.encode(userRequest.getPassword()));

        return userRepository.save(newUser);
    }
    public Iterable<User> FindAll() {
        return userRepository.findAll();
    }
    public User FindId(String request){
        return userRepository.findById(request).orElseThrow(()->new RuntimeException("Không tìm thấy user"));
    }
    public User Update(UserRequest request){
        User newUser = FindId(request.getUser_name());
        newUser = userMapper.toUser(request);

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        newUser.setPassword(passwordEncoder.encode(request.getPassword()));

        Staff staff = staffRepository.findById(request.getStaffId())
                .orElseThrow(()->new RuntimeException("Không tồn tại staff ID:" + request.getStaffId()));

        Set<Roles> roles = new HashSet<>(roleRepository.findAllById(request.getRoles()));

        newUser.setRoles(roles);
        newUser.setStaff(staff);

        return userRepository.save(newUser);
    }
}
