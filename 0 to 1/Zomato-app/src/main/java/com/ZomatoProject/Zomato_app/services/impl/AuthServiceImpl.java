package com.ZomatoProject.Zomato_app.services.impl;

import com.ZomatoProject.Zomato_app.dto.DeliveryBoyDto;
import com.ZomatoProject.Zomato_app.dto.SignUpDto;
import com.ZomatoProject.Zomato_app.dto.UserDto;
import com.ZomatoProject.Zomato_app.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    @Override
    public String[] login(String email, String password) {
        return new String[0];
    }

    @Override
    public UserDto signup(SignUpDto signUpDto) {
        return null;
    }

    @Override
    public DeliveryBoyDto onBoardNewDeliveryBoy(Long userId) {
        return null;
    }

    @Override
    public String refreshToken(String refreshToken) {
        return null;
    }
}
