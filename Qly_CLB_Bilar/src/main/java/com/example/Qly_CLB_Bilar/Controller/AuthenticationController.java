package com.example.Qly_CLB_Bilar.Controller;

import com.example.Qly_CLB_Bilar.DTO.Request.LogInRequest;
import com.example.Qly_CLB_Bilar.DTO.Response.ApiResponse;
import com.example.Qly_CLB_Bilar.DTO.Response.AuthenticationResponse;
import com.example.Qly_CLB_Bilar.Service.AuthenticationService;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;
//    @PostMapping("/login")
//    ApiResponse<AuthenticationResponse> Authenticate(@RequestBody LogInRequest logInRequest){
//        boolean result =  authenticationService.Authenticate(logInRequest);
//        return ApiResponse.<AuthenticationResponse>builder()
//                .result(AuthenticationResponse.builder()
//                        .Signed()
//                        .build())
//                .build();
//    }
}
