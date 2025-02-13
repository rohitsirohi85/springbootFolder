package com.ZomatoProject.Zomato_app.dto;

import com.ZomatoProject.Zomato_app.entity.enums.TransactionMethod;
import com.ZomatoProject.Zomato_app.entity.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalletTransactionDto {
    private Long id;

    private double amount;

    private TransactionType transactionType;

    private TransactionMethod transactionMethod;


    private OrderDto order;

    private String transactionId;


    private WalletDto wallet;


    private LocalDateTime timeStamp;
}
