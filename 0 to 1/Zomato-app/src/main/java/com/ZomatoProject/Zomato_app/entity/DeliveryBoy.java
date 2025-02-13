package com.ZomatoProject.Zomato_app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.locationtech.jts.geom.Point;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryBoy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private double ratings;

    private Boolean available;

    @Column(columnDefinition = "Geometry(Point, 4326)")   // only work when you have jts core and hibernate spatial dependencies
    private  Point currentLocation;

}
