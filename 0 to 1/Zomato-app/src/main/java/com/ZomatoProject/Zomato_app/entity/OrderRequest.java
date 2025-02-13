package com.ZomatoProject.Zomato_app.entity;

import com.ZomatoProject.Zomato_app.entity.enums.OrderRequestStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     @OneToOne
     private Cart cart;

     @Enumerated(EnumType.STRING)
     private OrderRequestStatus orderRequestStatus;

     @ManyToOne
     private Customer customer;

     @CreationTimestamp
     private LocalDateTime requestedTime;

     private double deliveryCharges;
     private double grandTotal;

 @Column(columnDefinition = "Geometry(Point, 4326)")   // only work when you have jts core and hibernate spatial dependencies
 private  Point deliveryAddress;



}
