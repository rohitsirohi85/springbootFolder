package com.JPA.jpa_hibernate.repo;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.JPA.jpa_hibernate.entities.productEntity;
import java.util.List;
@Repository
public interface productRepo extends JpaRepository<productEntity ,Long> {

  // here we create the method to find the data in a sorted way(order by) by price
    List<productEntity> findByOrderByPrice();  //for defining that method in repo ..this method do that it will return the data entries in a sorted manner according to price


    // now we want that we create a sorting technique so that we can directly can inserted the parameter at web server for making our work easily we can use sorting params

    List<productEntity>findBy(Sort sort);   // Sort means the filed which we want ton give for sorting


    /* combining all info */

    List<productEntity>findByTitleContainingIgnoreCase(String title ,Pageable pageable);
  

 
    
}
