package com.ZomatoProject.Zomato_app.dto;

import com.ZomatoProject.Zomato_app.entity.Order;
import com.ZomatoProject.Zomato_app.entity.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private Long id;

    private UserDto user;

    private double ratings;

    private List<OrderDto> orders;

}
