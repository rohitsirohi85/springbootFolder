package com.ZomatoProject.Zomato_app.dto;

import com.ZomatoProject.Zomato_app.entity.Customer;
import com.ZomatoProject.Zomato_app.entity.enums.PaymentStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RazorPayDto {
    private Long id;

    private String razorPayOrderId;

    private PaymentStatus paymentStatus;

    private double amount;
    private String currency;

    private CustomerDto customer;
}
