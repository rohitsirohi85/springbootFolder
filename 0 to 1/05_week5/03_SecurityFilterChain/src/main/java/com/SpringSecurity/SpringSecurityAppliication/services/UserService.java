package com.SpringSecurity.SpringSecurityAppliication.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.SpringSecurity.SpringSecurityAppliication.exceptions.ResourceNotFoundException;
import com.SpringSecurity.SpringSecurityAppliication.repo.UserRepo;

import lombok.RequiredArgsConstructor;

// @Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

         private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       return userRepo.findByEmail(username).orElseThrow(()->
                     new ResourceNotFoundException("user with email"+username+"not found")
       );
    }
    
}
