package com.ZomatoProject.Zomato_app.repo;

import com.ZomatoProject.Zomato_app.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepo extends JpaRepository<Wallet,Long> {
}
