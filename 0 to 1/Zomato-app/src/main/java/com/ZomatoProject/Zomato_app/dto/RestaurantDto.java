package com.ZomatoProject.Zomato_app.dto;

import com.ZomatoProject.Zomato_app.entity.Menu;
import com.ZomatoProject.Zomato_app.entity.RestaurantOwner;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDto {
    private Long id;

    private List<MenuDto> menu;

    private String name;

    private RestaurantOwnerDto owner;

    private String aboutUs;
}
