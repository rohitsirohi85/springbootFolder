package com.ZomatoProject.Zomato_app.dto;

import com.ZomatoProject.Zomato_app.entity.Cart;
import com.ZomatoProject.Zomato_app.entity.enums.OrderRequestStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDto {
    private Long id;

    private CartDto cart;

    private OrderRequestStatus orderRequestStatus;

    private CustomerDto customerDto;

    private LocalDateTime requestedTime;

    private double deliveryCharges;
    private double grandTotal;
}
