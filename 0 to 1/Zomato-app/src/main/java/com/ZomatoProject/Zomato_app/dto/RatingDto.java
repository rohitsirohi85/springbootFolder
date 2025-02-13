package com.ZomatoProject.Zomato_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingDto {
    private Long id;

    private OrderDto order;

    private CustomerDto customer;

    private DeliveryBoyDto deliveryBoy;

    private Integer customerRating;
    private Integer deliveryBoyRating;
}
