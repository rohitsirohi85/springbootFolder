package com.ZomatoProject.Zomato_app.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    private Long id;

    private CustomerDto customer;

    private List<CartItemsDto> cartItems;
    private double totalAmount;
}
