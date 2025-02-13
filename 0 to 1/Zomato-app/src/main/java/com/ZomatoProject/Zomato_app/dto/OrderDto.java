package com.ZomatoProject.Zomato_app.dto;

import com.ZomatoProject.Zomato_app.entity.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long id;

    private OrderStatus orderStatus;

    private LocalDateTime deliveryTime;

    private OrderRequestDto orderRequest;

    private String otp;

    private double grandTotal;

    private CustomerDto customer;

    private DeliveryBoyDto deliveryBoyDto;
}
