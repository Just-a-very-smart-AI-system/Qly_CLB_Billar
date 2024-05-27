package com.example.Qly_CLB_Bilar.Controller;

import com.example.Qly_CLB_Bilar.DTO.JWT.UserRequest;
import com.example.Qly_CLB_Bilar.Entity.User;
import com.example.Qly_CLB_Bilar.Repository.UserRepository;
import com.example.Qly_CLB_Bilar.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/getall")
    public Iterable<User> GetAll(){
        return userRepository.findAll();
    }

    @PostMapping("/create")
    public User Craete(@RequestBody UserRequest userRequest){
        return userService.Create(userRequest);
    }
}
