//package com.example.Qly_CLB_Bilar.Configuration;
//
//import com.example.Qly_CLB_Bilar.Entity.User;
//import com.example.Qly_CLB_Bilar.Repository.RoleRepository;
//import com.example.Qly_CLB_Bilar.Repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.HashSet;
//import java.util.List;
//
//@Slf4j
//@Configuration
//@RequiredArgsConstructor
//public class ApplicationInitConfig {
//
//    private final UserRepository userRepository;
//    private final RoleRepository roleRepository;
//
//    @Bean
//    ApplicationRunner applicationRunner() {
//        return args -> {
//            List<User> list = userRepository.findByStaffAdmin();
//            HashSet<String> roles = new HashSet<>();
//            roles.add(roleRepository.findById("ADMIN").toString());
//            if (!list.isEmpty()) {
//                for (User user : list) {
////                    user.setRoles(roles);
//                    userRepository.save(user);
//                }
//            } else {
//                User adminUser = new User();
//                adminUser.setUser_name("admin");
//                adminUser.setPassword("admin");
////                adminUser.setRoles();
//                userRepository.save(adminUser);
//            }
//
//            log.warn("Đã tạo vai trò ADMIN cho các user thích hợp.");
//        };
//    }
//}
