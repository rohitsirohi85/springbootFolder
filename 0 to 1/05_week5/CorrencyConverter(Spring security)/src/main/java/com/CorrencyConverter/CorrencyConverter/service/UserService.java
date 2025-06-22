package com.CorrencyConverter.CorrencyConverter.service;

import com.CorrencyConverter.CorrencyConverter.Dto.LoginRequestDto;
import com.CorrencyConverter.CorrencyConverter.Dto.UserResponseDto;
import com.CorrencyConverter.CorrencyConverter.entity.UserEntity;
import com.CorrencyConverter.CorrencyConverter.exception.ResourceNotFoundException;
import com.CorrencyConverter.CorrencyConverter.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {   // 2. implement the userDetailsService
    
    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user =  userRepo.findByEmail(username);

        if (user==null){
            throw new ResourceNotFoundException("user not found with email"+username);
        }
        return user;

    }



}
