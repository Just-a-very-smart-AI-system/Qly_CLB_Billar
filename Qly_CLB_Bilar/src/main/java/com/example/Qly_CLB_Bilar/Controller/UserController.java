package com.example.Qly_CLB_Bilar.Controller;

import com.example.Qly_CLB_Bilar.DTO.JWT.UserRequest;
import com.example.Qly_CLB_Bilar.Entity.User;
import com.example.Qly_CLB_Bilar.Repository.UserRepository;
import com.example.Qly_CLB_Bilar.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @PreAuthorize("hasAuthority('SCOPE_GET_DATA') and hasAuthority('SCOPE_ROLE_ADMIN')")
    @GetMapping("/getall")
    public Iterable<User> GetAll(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("UserName: {}", authentication.getName());
        authentication.getAuthorities().forEach(grantedAuthority -> log.info(grantedAuthority.getAuthority()));
        return userService.FindAll();
    }
    @GetMapping("/getmyinfo")
    public User GetMyUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String user_name = authentication.getName();
        return userRepository.findById(user_name).orElseThrow(()-> new RuntimeException("Không tìm thấy User:" + user_name));
    }
    @PostMapping("/create")
    public User Craete(@RequestBody UserRequest userRequest){
        return userService.Create(userRequest);
    }
    @PutMapping("/update")
    @PreAuthorize("hasAnyAuthority('SCOPE_UPDATE_DATA')")
    public User Update(@RequestBody UserRequest request){
        return userService.Update(request);
    }
}
