package com.JPA.jpa_hibernate.repo;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.JPA.jpa_hibernate.entities.productEntity;
import java.util.List;
import java.util.Optional;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Repository
public interface productRepo extends JpaRepository<productEntity ,Long> {

    List<productEntity> findByOrderBYPrice(String title);  //for defining that method in repo ..this method do that it will return the data entries which name is match with title parameter but in a sorted manner according to price

  // List<productEntity> findByCreatedAtAfter(LocalDateTime createdAt); // for define the query method 

  // List<productEntity> findBySkuAndPrice(String Sku, BigDecimal price);
   
   List<productEntity> findBySkuContaining(String Sku);

   // so like this we can create more logical methods which is not need to define query adn logic hibernate automatic read and make logic 


   /* if you want to create the own custom query logic */

   @Query("select e from productEntity e where e.sku=:sku and e.title=:title")  //logic for find the data which sku adn title is matched
   Optional<productEntity>findBySkuAndTitle(String sku , String title);
    
}
