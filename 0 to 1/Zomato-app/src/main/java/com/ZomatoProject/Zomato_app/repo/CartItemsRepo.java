package com.ZomatoProject.Zomato_app.repo;

import com.ZomatoProject.Zomato_app.entity.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemsRepo extends JpaRepository<CartItems,Long> {
}
