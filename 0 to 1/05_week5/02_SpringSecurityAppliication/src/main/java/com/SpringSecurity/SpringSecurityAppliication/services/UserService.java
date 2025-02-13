package com.SpringSecurity.SpringSecurityAppliication.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.SpringSecurity.SpringSecurityAppliication.exceptions.ResourceNotFoundException;
import com.SpringSecurity.SpringSecurityAppliication.repo.UserRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService { // implements the USerDetailsService

         private final UserRepo userRepo;

         // here if you go the api link now so you have to make sure that your data inside database bcz it will try to find the data inside database if user not found login failed
         // http://localhost:8080/posts

    @Override  // abstract method of UserDetailsService
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       return userRepo.findByEmail(username).orElseThrow(()->
                     new ResourceNotFoundException("user with email"+username+"not found")
       );
    }
    
}
