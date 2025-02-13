package com.ZomatoProject.Zomato_app.dto;

import com.ZomatoProject.Zomato_app.entity.Menu;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuItemDto {
    private Long id;

    private MenuDto menu;

    private String name;

    private Double price;

    private String preparationTime;
}
