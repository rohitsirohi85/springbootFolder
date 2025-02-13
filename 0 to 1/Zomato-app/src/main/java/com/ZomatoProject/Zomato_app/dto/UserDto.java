package com.ZomatoProject.Zomato_app.dto;

import com.ZomatoProject.Zomato_app.entity.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {


    private Long id;
    private String name;
    private String email;
    private String phone;
    private Set<Roles> roles;

}
