package com.ZomatoProject.Zomato_app.services.impl;

import com.ZomatoProject.Zomato_app.dto.CustomerDto;
import com.ZomatoProject.Zomato_app.dto.DeliveryBoyDto;
import com.ZomatoProject.Zomato_app.dto.OrderDto;
import com.ZomatoProject.Zomato_app.entity.DeliveryBoy;
import com.ZomatoProject.Zomato_app.services.DeliveryBoyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeliveryBoyServiceImpl implements DeliveryBoyService {
    @Override
    public OrderDto acceptOrder(Long orderRequestId) {
        return null;
    }

    @Override
    public OrderDto cancelOrder(Long orderId) {
        return null;
    }

    @Override
    public OrderDto startOrder(Long orderId) {
        return null;
    }

    @Override
    public OrderDto endOrder(Long orderId, String otp) {
        return null;
    }

    @Override
    public CustomerDto rateCustomer(Long orderId, Integer rating) {
        return null;
    }

    @Override
    public DeliveryBoyDto getMyProfile() {
        return null;
    }

    @Override
    public Page<OrderDto> getAllMyOrder(PageRequest pageRequest) {
        return null;
    }

    @Override
    public DeliveryBoy getCurrentDeliveryBoy() {
        return null;
    }

    @Override
    public DeliveryBoy updateDeliveryBoyAvailability(DeliveryBoy deliveryBoy, boolean available) {
        return null;
    }

    @Override
    public DeliveryBoy createNewDeliveryBoy(DeliveryBoy deliveryBoy) {
        return null;
    }
}
