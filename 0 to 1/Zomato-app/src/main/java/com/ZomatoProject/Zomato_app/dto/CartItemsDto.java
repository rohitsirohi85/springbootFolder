package com.ZomatoProject.Zomato_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemsDto {
    private Long id;


    private CartDto cart;

    private double quantity;

    private MenuItemDto menuItem;
}
