package com.ZomatoProject.Zomato_app.entity;

import com.ZomatoProject.Zomato_app.entity.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RazorPay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String razorPayOrderId;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    private double amount;
    private String currency;

    @ManyToOne
    private Customer customer;  // Assuming the customer places the order

}
