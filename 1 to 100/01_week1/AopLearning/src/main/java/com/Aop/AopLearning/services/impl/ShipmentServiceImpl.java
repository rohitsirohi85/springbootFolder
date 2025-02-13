package com.Aop.AopLearning.services.impl;

import com.Aop.AopLearning.aspects.MyLogging;
import com.Aop.AopLearning.services.ShipmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class ShipmentServiceImpl implements ShipmentService {
    @Override
    @MyLogging
    public String orderPackage(Long orderId) {
        try{
           log.info("ordering the package");
            System.out.println("order has been proceed success : order ID - :"+orderId);
        }catch (Exception e){
              log.info("error occurred while ordering order :"+e);
        }
        return "order has been proceed success : order ID - :"+orderId;
    }

    @Override
    @Transactional
    public String trackOrder(Long orderId) {
        try{
            log.info("tracking the package");
         throw new RuntimeException("error occurred while tracking");
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
