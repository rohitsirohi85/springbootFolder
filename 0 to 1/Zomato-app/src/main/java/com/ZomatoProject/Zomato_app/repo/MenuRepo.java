package com.ZomatoProject.Zomato_app.repo;

import com.ZomatoProject.Zomato_app.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepo extends JpaRepository<Menu,Long> {
}
