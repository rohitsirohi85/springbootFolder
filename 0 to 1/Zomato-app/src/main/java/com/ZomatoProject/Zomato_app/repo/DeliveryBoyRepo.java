package com.ZomatoProject.Zomato_app.repo;

import com.ZomatoProject.Zomato_app.entity.DeliveryBoy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryBoyRepo extends JpaRepository<DeliveryBoy,Long> {
}
