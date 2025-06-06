package com.ZomatoProject.Zomato_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryBoyDto {

    private Long id;

    private UserDto user;

    private double ratings;

    private Boolean available;


}
