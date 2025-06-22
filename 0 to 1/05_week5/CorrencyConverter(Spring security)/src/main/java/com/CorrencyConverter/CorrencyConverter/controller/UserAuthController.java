package com.CorrencyConverter.CorrencyConverter.controller;

import com.CorrencyConverter.CorrencyConverter.Dto.LoginRequestDto;
import com.CorrencyConverter.CorrencyConverter.Dto.UserResponseDto;
import com.CorrencyConverter.CorrencyConverter.entity.UserEntity;
import com.CorrencyConverter.CorrencyConverter.service.AuthService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserAuthController {

    private final AuthService authService;



    @PostMapping("/signup")
    public ResponseEntity<UserResponseDto> signUp(@RequestBody UserEntity userEntity){
        UserResponseDto userResponseDto = authService.signUp(userEntity);
        return ResponseEntity.ok(userResponseDto);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto loginRequestDto , HttpServletResponse response){
        String token = authService.login(loginRequestDto);
        Cookie cookie = new Cookie("token",token);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
        return ResponseEntity.ok(token);
    }


}
