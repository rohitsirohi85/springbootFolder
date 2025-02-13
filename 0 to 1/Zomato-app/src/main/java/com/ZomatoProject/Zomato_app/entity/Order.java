package com.ZomatoProject.Zomato_app.entity;

import com.ZomatoProject.Zomato_app.entity.enums.DeliveryStatus;
import com.ZomatoProject.Zomato_app.entity.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_customer")  // Avoid using "order" as it's a reserved word
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @CreationTimestamp
    private LocalDateTime deliveryTime;

    @OneToOne
    private OrderRequest orderRequest;

    private String otp;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

    private double grandTotal;

    // Make sure the relationship with Customer is defined correctly
    @ManyToOne
    @JoinColumn(name = "customer_id")  // This will create customer_id column in Order table
    private Customer customer;

    @ManyToOne
    private DeliveryBoy deliveryBoy;
}
