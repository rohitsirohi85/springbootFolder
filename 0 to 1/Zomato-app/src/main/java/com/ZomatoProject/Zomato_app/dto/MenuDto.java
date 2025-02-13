package com.ZomatoProject.Zomato_app.dto;

import com.ZomatoProject.Zomato_app.entity.MenuItem;
import com.ZomatoProject.Zomato_app.entity.Restaurant;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuDto {
    private Long id;

    private List<MenuItemDto> menuItem;

    private String menuName;

    private RestaurantDto restaurant;

    private boolean active;
}
