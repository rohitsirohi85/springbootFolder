package com.SpringSecurity.SpringSecurityAppliication.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringSecurity.SpringSecurityAppliication.dto.LoginDto;
import com.SpringSecurity.SpringSecurityAppliication.dto.SignupDto;
import com.SpringSecurity.SpringSecurityAppliication.dto.UserDto;
import com.SpringSecurity.SpringSecurityAppliication.services.AuthService;
import com.SpringSecurity.SpringSecurityAppliication.services.UserService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    
     private final UserService userService;
     private final AuthService authService;

     // here all is done in postman when you go to postman and signup when so you have to use email,password for login and it will check into database for you info. and info. found so it will provide you a token which you can use to get the non-sensitive data of user which you define in the jwt service you have to paste token in the bearer token section inside postman when ty to get request getUserById

     @PostMapping(path="/signup")
          public ResponseEntity<UserDto> signup(@RequestBody SignupDto signupDto){
            UserDto userDto = userService.signup(signupDto);
            return ResponseEntity.ok(userDto);
          }


          @PostMapping(path = "/login")
          public ResponseEntity<String> login(@RequestBody LoginDto loginDto  , HttpServletRequest request , HttpServletResponse response){
            String token=authService.login(loginDto);
            Cookie cookie = new Cookie("token", token);
            cookie.setHttpOnly(true);
            response.addCookie(cookie);

            return ResponseEntity.ok(token);
          }
}
