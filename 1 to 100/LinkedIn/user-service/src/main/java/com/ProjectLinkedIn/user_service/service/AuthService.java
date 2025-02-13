package com.ProjectLinkedIn.user_service.service;

import com.ProjectLinkedIn.user_service.dto.LoginRequestDto;
import com.ProjectLinkedIn.user_service.dto.SignUpRequestDto;
import com.ProjectLinkedIn.user_service.dto.UserDto;
import com.ProjectLinkedIn.user_service.entity.User;
import com.ProjectLinkedIn.user_service.exception.BadRequestException;
import com.ProjectLinkedIn.user_service.exception.ResourceNotFoundException;
import com.ProjectLinkedIn.user_service.repo.UserRepo;
import com.ProjectLinkedIn.user_service.utils.PasswordUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final UserRepo userRepo;
    private final ModelMapper modelMapper;
    private final JwtService jwtService;


    public UserDto signUp(SignUpRequestDto signUpRequestDto) {

        boolean exist = userRepo.existsByEmail(signUpRequestDto.getEmail());

        if (exist){
            throw new BadRequestException("user already exists , can't create again.");
        }

        User user = modelMapper.map(signUpRequestDto, User.class);
        user.setPassword(PasswordUtil.hashPassword(signUpRequestDto.getPassword()));

       User savedUser =  userRepo.save(user);
       return modelMapper.map(savedUser, UserDto.class);
    }

    public String login(LoginRequestDto loginRequestDto) {

        User user = userRepo.findByEmail(loginRequestDto.getEmail())
                .orElseThrow(()->new ResourceNotFoundException("user not found with mail:"+loginRequestDto.getEmail()));
         boolean isPasswordMatch = PasswordUtil.checkPassword(loginRequestDto.getPassword(),user.getPassword());
         if (!isPasswordMatch){
             throw new BadRequestException("Incorrect password");
         }

         return jwtService.generateAccessTokens(user);
    }
}
