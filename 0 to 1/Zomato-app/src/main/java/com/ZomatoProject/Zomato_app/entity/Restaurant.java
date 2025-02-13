package com.ZomatoProject.Zomato_app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.locationtech.jts.geom.Point;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "restaurant")
    private List<Menu> menu;

    private String name;


    @Column(columnDefinition = "Geometry(Point, 4326)")   // only work when you have jts core and hibernate spatial dependencies
    private Point address;

    @OneToOne
    private RestaurantOwner owner;

    private String aboutUs;

}
