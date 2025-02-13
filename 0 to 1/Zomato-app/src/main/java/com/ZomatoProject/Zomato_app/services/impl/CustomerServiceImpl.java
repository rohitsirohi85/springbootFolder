package com.ZomatoProject.Zomato_app.services.impl;

import com.ZomatoProject.Zomato_app.dto.CustomerDto;
import com.ZomatoProject.Zomato_app.dto.DeliveryBoyDto;
import com.ZomatoProject.Zomato_app.dto.OrderDto;
import com.ZomatoProject.Zomato_app.dto.OrderRequestDto;
import com.ZomatoProject.Zomato_app.entity.Customer;
import com.ZomatoProject.Zomato_app.entity.User;
import com.ZomatoProject.Zomato_app.services.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public class CustomerServiceImpl implements CustomerService {
    @Override
    public OrderRequestDto requestOrder(OrderRequestDto orderRequestDto) {
        return null;
    }

    @Override
    public OrderDto cancelOrder(Long orderId) {
        return null;
    }

    @Override
    public DeliveryBoyDto rateDeliveryBoy(Long rideId, Integer rating) {
        return null;
    }

    @Override
    public CustomerDto getMyProfile() {
        return null;
    }

    @Override
    public Page<OrderDto> getAllMyOrders(PageRequest pageRequest) {
        return null;
    }

    @Override
    public Customer createNewCustomer(User user) {
        return null;
    }

    @Override
    public Customer getCurrentCustomer() {
        return null;
    }
}
