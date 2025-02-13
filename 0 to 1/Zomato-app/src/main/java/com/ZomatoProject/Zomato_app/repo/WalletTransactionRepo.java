package com.ZomatoProject.Zomato_app.repo;

import com.ZomatoProject.Zomato_app.entity.WalletTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletTransactionRepo extends JpaRepository<WalletTransaction,Long> {
}
