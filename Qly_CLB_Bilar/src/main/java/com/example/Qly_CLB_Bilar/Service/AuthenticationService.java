package com.example.Qly_CLB_Bilar.Service;

import com.example.Qly_CLB_Bilar.DTO.Request.LogInRequest;
import com.example.Qly_CLB_Bilar.DTO.Response.AuthenticationResponse;
import com.example.Qly_CLB_Bilar.Repository.UserRepository;
//import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;
    public boolean Authenticate(LogInRequest request){
        var user = userRepository.findById(request.getUser_name())
                .orElseThrow(()->new RuntimeException("Không tồn tại UserName ID:" + request.getUser_name()));

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        return passwordEncoder.matches(request.getPassword(), user.getPassword());
    }
}
