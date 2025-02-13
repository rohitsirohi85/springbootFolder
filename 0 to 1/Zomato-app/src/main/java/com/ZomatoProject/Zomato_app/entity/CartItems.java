package com.ZomatoProject.Zomato_app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     @ManyToOne
     private Cart cart;

     private double quantity;

     @OneToOne
     private MenuItem menuItem;

}
