package com.ZomatoProject.Zomato_app.services;

import com.ZomatoProject.Zomato_app.dto.CustomerDto;
import com.ZomatoProject.Zomato_app.dto.DeliveryBoyDto;
import com.ZomatoProject.Zomato_app.dto.OrderDto;
import com.ZomatoProject.Zomato_app.entity.DeliveryBoy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface DeliveryBoyService {


    OrderDto acceptOrder(Long orderRequestId);
    OrderDto cancelOrder(Long orderId);

    OrderDto startOrder(Long orderId);

    OrderDto endOrder(Long orderId , String otp);

    CustomerDto rateCustomer(Long orderId,Integer rating);

    DeliveryBoyDto getMyProfile();

    Page<OrderDto> getAllMyOrder(PageRequest pageRequest);

    DeliveryBoy getCurrentDeliveryBoy();

    DeliveryBoy updateDeliveryBoyAvailability(DeliveryBoy deliveryBoy,boolean available);

    DeliveryBoy createNewDeliveryBoy(DeliveryBoy deliveryBoy);

}
