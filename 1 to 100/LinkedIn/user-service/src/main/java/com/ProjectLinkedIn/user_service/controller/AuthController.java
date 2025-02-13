package com.ProjectLinkedIn.user_service.controller;

import com.ProjectLinkedIn.user_service.dto.LoginRequestDto;
import com.ProjectLinkedIn.user_service.dto.SignUpRequestDto;
import com.ProjectLinkedIn.user_service.dto.UserDto;
import com.ProjectLinkedIn.user_service.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<UserDto> signUp(@RequestBody SignUpRequestDto signUpRequestDto){
        UserDto userDto = authService.signUp(signUpRequestDto);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto loginRequestDto){
       String token = authService.login(loginRequestDto);
        return ResponseEntity.ok(token);
    }

}
