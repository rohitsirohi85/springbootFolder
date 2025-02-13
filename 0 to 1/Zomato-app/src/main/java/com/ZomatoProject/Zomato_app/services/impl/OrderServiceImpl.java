package com.ZomatoProject.Zomato_app.services.impl;

import com.ZomatoProject.Zomato_app.entity.Customer;
import com.ZomatoProject.Zomato_app.entity.DeliveryBoy;
import com.ZomatoProject.Zomato_app.entity.Order;
import com.ZomatoProject.Zomato_app.entity.OrderRequest;
import com.ZomatoProject.Zomato_app.entity.enums.OrderStatus;
import com.ZomatoProject.Zomato_app.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    @Override
    public Order getOrderById(Long orderId) {
        return null;
    }

    @Override
    public Order createNewOrder(OrderRequest orderRequest) {
        return null;
    }

    @Override
    public Order updateOrderStatus(Order order, OrderStatus orderStatus) {
        return null;
    }

    @Override
    public Page<Order> getAllOrdersOfCustomer(Customer customer, PageRequest pageRequest) {
        return null;
    }

    @Override
    public Page<Order> getAllOrdersOfDeliveryBoy(DeliveryBoy deliveryBoy, PageRequest pageRequest) {
        return null;
    }
}
