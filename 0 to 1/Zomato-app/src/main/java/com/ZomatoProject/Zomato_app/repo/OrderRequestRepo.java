package com.ZomatoProject.Zomato_app.repo;

import com.ZomatoProject.Zomato_app.entity.OrderRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRequestRepo extends JpaRepository<OrderRequest,Long> {
}
