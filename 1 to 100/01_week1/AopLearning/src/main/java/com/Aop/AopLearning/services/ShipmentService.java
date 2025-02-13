package com.Aop.AopLearning.services;

public interface ShipmentService {
    String orderPackage(Long orderId);
    String trackOrder(Long orderId);
}
