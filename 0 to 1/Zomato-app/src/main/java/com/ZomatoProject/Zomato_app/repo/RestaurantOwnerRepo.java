package com.ZomatoProject.Zomato_app.repo;

import com.ZomatoProject.Zomato_app.entity.RestaurantOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantOwnerRepo extends JpaRepository<RestaurantOwner,Long> {
}
