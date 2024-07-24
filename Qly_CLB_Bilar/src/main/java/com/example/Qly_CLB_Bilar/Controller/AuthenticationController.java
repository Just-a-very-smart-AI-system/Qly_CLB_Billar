package com.example.Qly_CLB_Bilar.Controller;

import com.example.Qly_CLB_Bilar.DTO.JWT.IntrospectRequest;
import com.example.Qly_CLB_Bilar.DTO.JWT.LogInRequest;
import com.example.Qly_CLB_Bilar.DTO.Response.ApiResponse;
import com.example.Qly_CLB_Bilar.DTO.JWT.AuthenticationResponse;
import com.example.Qly_CLB_Bilar.DTO.JWT.IntrospectResponse;
import com.example.Qly_CLB_Bilar.Service.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;


@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;
    @PostMapping("/token")
    AuthenticationResponse Authenticate(@RequestBody LogInRequest logInRequest){
        AuthenticationResponse result = authenticationService.Authenticate(logInRequest);
        return AuthenticationResponse.builder().token(result.getToken()).Signed(result.isSigned())
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
