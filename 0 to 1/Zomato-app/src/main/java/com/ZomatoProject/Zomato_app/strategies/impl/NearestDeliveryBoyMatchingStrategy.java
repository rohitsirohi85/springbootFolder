package com.ZomatoProject.Zomato_app.strategies.impl;

import com.ZomatoProject.Zomato_app.entity.DeliveryBoy;
import com.ZomatoProject.Zomato_app.entity.OrderRequest;
import com.ZomatoProject.Zomato_app.strategies.DeliveryBoyMatchingStrategy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NearestDeliveryBoyMatchingStrategy implements DeliveryBoyMatchingStrategy {
    @Override
    public List<DeliveryBoy> findMatchingDeliveryBoy(OrderRequest orderRequest) {
        return null;
    }
}
