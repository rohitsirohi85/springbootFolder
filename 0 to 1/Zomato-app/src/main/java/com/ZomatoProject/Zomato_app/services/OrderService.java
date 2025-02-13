package com.ZomatoProject.Zomato_app.services;

import com.ZomatoProject.Zomato_app.entity.Customer;
import com.ZomatoProject.Zomato_app.entity.DeliveryBoy;
import com.ZomatoProject.Zomato_app.entity.Order;
import com.ZomatoProject.Zomato_app.entity.OrderRequest;
import com.ZomatoProject.Zomato_app.entity.enums.OrderStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface OrderService {

    Order getOrderById(Long orderId);

    Order createNewOrder(OrderRequest orderRequest);

    Order updateOrderStatus(Order order , OrderStatus orderStatus);


    Page<Order> getAllOrdersOfCustomer(Customer customer, PageRequest pageRequest);

    Page<Order>getAllOrdersOfDeliveryBoy(DeliveryBoy deliveryBoy, PageRequest pageRequest);

}
