package com.ZomatoProject.Zomato_app.repo;

import com.ZomatoProject.Zomato_app.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepo extends JpaRepository<MenuItem,Long> {
}
