package com.CorrencyConverter.CorrencyConverter.service;

import com.CorrencyConverter.CorrencyConverter.Dto.LoginRequestDto;
import com.CorrencyConverter.CorrencyConverter.Dto.UserResponseDto;
import com.CorrencyConverter.CorrencyConverter.entity.SessionEntity;
import com.CorrencyConverter.CorrencyConverter.entity.UserEntity;
import com.CorrencyConverter.CorrencyConverter.repo.SessionRepo;
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

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepo userRepo;
    private final SessionRepo sessionRepo;

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

        // Step 1: Authenticate user using Spring Security
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequestDto.getEmail(), loginRequestDto.getPassword())
        );

        // Step 2: Get the authenticated user object
        UserEntity user = (UserEntity) authentication.getPrincipal();

        // Step 3: Fetch all existing sessions for the user, sorted by oldest first
        List<SessionEntity> sessions = sessionRepo.findAllByUserOrderByCreatedAtAsc(user);

        // Step 4: If user already has 2 or more sessions, delete the oldest session
        if (sessions.size() >= 2) {
            sessionRepo.delete(sessions.get(0));
        }

        // Step 5: Generate a new JWT token
        String token = jwtService.generateToken(user);

        // Step 6: Create and save a new session manually (no cascading)
        SessionEntity sessionEntity = SessionEntity.builder()
                .user(user)
                .token(token)
                .build();

        sessionRepo.save(sessionEntity); // Save session explicitly

        return token; // Return JWT to the client
    }
    }
