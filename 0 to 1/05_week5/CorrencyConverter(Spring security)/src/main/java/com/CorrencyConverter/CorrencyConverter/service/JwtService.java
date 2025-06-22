package com.CorrencyConverter.CorrencyConverter.service;

import com.CorrencyConverter.CorrencyConverter.entity.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {    // 5. create jwt services to create and take token

    @Value("${jwt.secretKey}")
    private String jwtKey;


    private SecretKey getSecretKey(){
        return Keys.hmacShaKeyFor(jwtKey.getBytes(StandardCharsets.UTF_8));
    }


    public String generateToken(UserEntity userEntity){
      return  Jwts.builder()
                .subject(userEntity.getId().toString())
                .claim("email",userEntity.getEmail())
                .claim("name",userEntity.getName())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+1000*60))  // (1000*60)  60 sec
                .signWith(getSecretKey())
                .compact();
    }


    public Long getUserIdFromToken(String token){
        Claims claims = Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return Long.valueOf(claims.getSubject());

    }


}
