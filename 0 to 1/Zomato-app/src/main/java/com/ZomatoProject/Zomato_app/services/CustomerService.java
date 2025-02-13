package com.ZomatoProject.Zomato_app.services;

import com.ZomatoProject.Zomato_app.dto.CustomerDto;
import com.ZomatoProject.Zomato_app.dto.DeliveryBoyDto;
import com.ZomatoProject.Zomato_app.dto.OrderDto;
import com.ZomatoProject.Zomato_app.dto.OrderRequestDto;
import com.ZomatoProject.Zomato_app.entity.Customer;
import com.ZomatoProject.Zomato_app.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface CustomerService {

    OrderRequestDto requestOrder(OrderRequestDto orderRequestDto);

    OrderDto cancelOrder(Long orderId);

    DeliveryBoyDto rateDeliveryBoy(Long rideId , Integer  rating);

    CustomerDto getMyProfile();

    Page<OrderDto> getAllMyOrders(PageRequest pageRequest);

    Customer createNewCustomer(User user);

    Customer getCurrentCustomer();

}
