package com.ZomatoProject.Zomato_app.services;

import com.ZomatoProject.Zomato_app.dto.DeliveryBoyDto;
import com.ZomatoProject.Zomato_app.dto.SignUpDto;
import com.ZomatoProject.Zomato_app.dto.UserDto;


public interface AuthService {

    String[] login(String email,String password);

    UserDto signup(SignUpDto signUpDto);

    DeliveryBoyDto onBoardNewDeliveryBoy(Long userId);

    String refreshToken(String refreshToken);

}
