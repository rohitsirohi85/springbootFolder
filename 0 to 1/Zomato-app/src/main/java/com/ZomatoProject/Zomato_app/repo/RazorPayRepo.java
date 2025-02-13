package com.ZomatoProject.Zomato_app.repo;

import com.ZomatoProject.Zomato_app.entity.RazorPay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RazorPayRepo extends JpaRepository<RazorPay,Long> {
}
