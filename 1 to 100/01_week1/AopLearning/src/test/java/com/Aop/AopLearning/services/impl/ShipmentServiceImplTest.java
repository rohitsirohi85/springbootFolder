package com.Aop.AopLearning.services.impl;

import com.Aop.AopLearning.services.ShipmentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class ShipmentServiceImplTest {

      @Autowired
      private ShipmentService shipmentService;

    @Test
    void testOrderPackage() {
        shipmentService.orderPackage(1L);
    }

    @Test
    void testTrackOrder() {
       String s = shipmentService.trackOrder(-1L);
       log.info(s);
    }
}