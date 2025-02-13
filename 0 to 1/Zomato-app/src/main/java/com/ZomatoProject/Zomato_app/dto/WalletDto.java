package com.ZomatoProject.Zomato_app.dto;

import com.ZomatoProject.Zomato_app.entity.User;
import com.ZomatoProject.Zomato_app.entity.WalletTransaction;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalletDto {
    private Long id;

    private UserDto user;

    private double balance;

    private List<WalletTransactionDto> transactions;
}
