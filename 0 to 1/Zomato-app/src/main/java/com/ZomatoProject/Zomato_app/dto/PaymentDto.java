package com.ZomatoProject.Zomato_app.dto;

import com.ZomatoProject.Zomato_app.entity.Customer;
import com.ZomatoProject.Zomato_app.entity.Order;
import com.ZomatoProject.Zomato_app.entity.enums.PaymentMethod;
import com.ZomatoProject.Zomato_app.entity.enums.PaymentStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {
    private Long id;

    private CustomerDto customer;

    private OrderDto order;

    private double amount;

    private PaymentMethod paymentMethod;

    private PaymentStatus paymentStatus;
}
