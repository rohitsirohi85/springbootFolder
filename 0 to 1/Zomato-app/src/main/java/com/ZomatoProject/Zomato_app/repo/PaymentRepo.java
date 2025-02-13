package com.ZomatoProject.Zomato_app.repo;

import com.ZomatoProject.Zomato_app.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepo extends JpaRepository<Payment,Long> {
}
