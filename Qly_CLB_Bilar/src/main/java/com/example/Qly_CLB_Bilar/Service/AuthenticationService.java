package com.example.Qly_CLB_Bilar.Service;

import com.example.Qly_CLB_Bilar.DTO.JWT.IntrospectRequest;
import com.example.Qly_CLB_Bilar.DTO.JWT.LogInRequest;
import com.example.Qly_CLB_Bilar.DTO.JWT.AuthenticationResponse;
import com.example.Qly_CLB_Bilar.DTO.JWT.IntrospectResponse;
import com.example.Qly_CLB_Bilar.Entity.User;
import com.example.Qly_CLB_Bilar.Repository.UserRepository;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Date;
import java.util.StringJoiner;

@Service
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;
    @Value("${spring.security.oauth2.resourceserver.jwt.signerKey}")
    private String SIGNER_KEY;
    public AuthenticationResponse Authenticate(LogInRequest request){
        var user = userRepository.findById(request.getUser_name())
                .orElseThrow(()->new RuntimeException("Không tồn tại UserName:" + request.getUser_name()));

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        boolean authenticated = passwordEncoder.matches(request.getPassword(), user.getPassword());
        if(!authenticated){
            throw new RuntimeException("Xác minh không thành công!");
        }
        var token = generateToken(user);

        return AuthenticationResponse.builder()
                .token(token)
                .Signed(true)
                .build();
    }
    private String generateToken(User user){
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);
            JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(user.getUser_name())
                .issuer("Issued by god")
                .issueTime(new Date())
                .expirationTime(new Date(
                        Instant.now().plus(1, ChronoUnit.HOURS).toEpochMilli()))
                .claim("scope", buildScope(user))
                .build();
        Payload payload = new Payload(jwtClaimsSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(header, payload);
        try {
            jwsObject.sign(new MACSigner(SIGNER_KEY.getBytes()));
            return jwsObject.serialize();
        } catch (JOSEException e) {
            throw new RuntimeException("Không thể tạo token", e);
        }
    }
    public IntrospectResponse introspect(IntrospectRequest request) throws JOSEException, ParseException {
        var token = request.getToken();
        JWSVerifier verifier = new MACVerifier(SIGNER_KEY);

        SignedJWT signedJWT = SignedJWT.parse(token);

        Date expTime = signedJWT.getJWTClaimsSet().getExpirationTime();

        var verified =  signedJWT.verify(verifier);
        return IntrospectResponse.builder()
                .valid(verified && expTime.after(new Date()))
                .build();

    }
    private String buildScope(User user){
        StringJoiner stringJoiner = new StringJoiner(" ");
        if(!CollectionUtils.isEmpty(user.getRoles())){
            user.getRoles().forEach(roles -> {
                stringJoiner.add("ROLE_"+roles.getName());
                if(!CollectionUtils.isEmpty(roles.getPermisstion()))
                    roles.getPermisstion().forEach(permisstion -> stringJoiner.add(permisstion.getName()));
            });

        }
        return stringJoiner.toString();
    }
}
