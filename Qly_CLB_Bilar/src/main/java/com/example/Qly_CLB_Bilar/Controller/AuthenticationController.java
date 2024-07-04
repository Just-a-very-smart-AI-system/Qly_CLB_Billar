package com.example.Qly_CLB_Bilar.Controller;

import com.example.Qly_CLB_Bilar.DTO.JWT.IntrospectRequest;
import com.example.Qly_CLB_Bilar.DTO.JWT.LogInRequest;
import com.example.Qly_CLB_Bilar.DTO.Response.ApiResponse;
import com.example.Qly_CLB_Bilar.DTO.JWT.AuthenticationResponse;
import com.example.Qly_CLB_Bilar.DTO.JWT.IntrospectResponse;
import com.example.Qly_CLB_Bilar.Service.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;
    @PostMapping("/token")
    ApiResponse<AuthenticationResponse> Authenticate(@RequestBody LogInRequest logInRequest){
        AuthenticationResponse result = authenticationService.Authenticate(logInRequest);
        return ApiResponse.<AuthenticationResponse>builder()
                .result(result)
                .build();
    }
    @PostMapping("/introspect")
    ApiResponse<IntrospectResponse> Authenticate(@RequestBody IntrospectRequest request)
            throws ParseException, JOSEException {
        var result =  authenticationService.introspect(request);
        return ApiResponse.<IntrospectResponse>builder()
                .result(result)
                .build();
    }
}
