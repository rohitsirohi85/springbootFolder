package com.ZomatoProject.Zomato_app.strategies;

import com.ZomatoProject.Zomato_app.dto.OrderRequestDto;
import com.ZomatoProject.Zomato_app.entity.DeliveryBoy;
import com.ZomatoProject.Zomato_app.entity.OrderRequest;

import java.util.List;

public interface DeliveryBoyMatchingStrategy {

    List<DeliveryBoy> findMatchingDeliveryBoy(OrderRequest orderRequest);

}
