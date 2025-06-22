package com.CorrencyConverter.CorrencyConverter.service;

import com.CorrencyConverter.CorrencyConverter.Dto.LoginRequestDto;
import com.CorrencyConverter.CorrencyConverter.Dto.UserResponseDto;
import com.CorrencyConverter.CorrencyConverter.entity.UserEntity;
import com.CorrencyConverter.CorrencyConverter.repo.UserRepo;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepo userRepo;

    public UserResponseDto signUp(UserEntity userEntity) {

        UserEntity user = userRepo.findByEmail(userEntity.getEmail());

        if(user!=null){
            throw new RuntimeException("user with this mail already exist");
        }
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));  // for using spring security it is mandatory to store password after encoding otherwise it will not work
        UserEntity savedUser = userRepo.save(userEntity);
        return modelMapper.map(savedUser, UserResponseDto.class);


    }

    public String login(LoginRequestDto loginRequestDto) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.getEmail(),loginRequestDto.getPassword())
        );

        UserEntity user = (UserEntity) authentication.getPrincipal();
        return jwtService.generateToken(user);

    }

}
