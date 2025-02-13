package com.ZomatoProject.Zomato_app.entity;


import java.time.LocalDateTime;

import com.ZomatoProject.Zomato_app.entity.enums.TransactionMethod;
import com.ZomatoProject.Zomato_app.entity.enums.TransactionType;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WalletTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @Enumerated(EnumType.STRING)
    private TransactionMethod transactionMethod;

    @ManyToOne
    private Order order;

    private String transactionId;

    @ManyToOne
    private Wallet wallet;

    @CreationTimestamp
    private LocalDateTime timeStamp;

}

