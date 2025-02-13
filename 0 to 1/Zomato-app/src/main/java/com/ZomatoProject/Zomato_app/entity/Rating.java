package com.ZomatoProject.Zomato_app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     @OneToOne
     private Order order;

     @ManyToOne
     private Customer customer;

     @ManyToOne
     private DeliveryBoy deliveryBoy;

     private Integer customerRating;
     private Integer deliveryBoyRating;

}
