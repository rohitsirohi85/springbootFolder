package com.JPA.jpa_hibernate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.JPA.jpa_hibernate.entities.productEntity;
import com.JPA.jpa_hibernate.repo.productRepo;



@SpringBootTest
class JpaHibernateApplicationTests {

    @Autowired
    productRepo pRepo;

   @Test
   void testingdata(){
       productEntity productentity=productEntity.builder()  // note:it is important that which value you given are exactly the same in data.sql and also the database.tableName is correct and also the database name in application.properties
       .sku("chotu don")
       .title( "tattu chetan")
       .price(BigDecimal.valueOf(23.34))
       .build();
       productEntity saved=pRepo.save(productentity);
       System.out.println(saved);
       
   }

   @Test
   void getEntitites(){
    //  List<productEntity>entities=pRepo.findAll();  // normal predefine method to find the all entities

   // List<productEntity>entities=pRepo.findByTitle("parleg");

   /*  we use this bcz hibernate can read the method name and start working according to name like here we told that find the entity title is parleg in databases and print that so you don't need to use any query you think this is normal but the fun-fact it's not a method yes it's not an official method it's the we only write by assuming and hibernate read that method and understand that we want to find by title bcz title is in the entity but for this you need to define the condition in repo also. we can do the same thing with others like..*/

  // List<productEntity>entities=pRepo.findByCreatedAtAfter(LocalDateTime.of(2020, 2, 4, 0, 0, 0));

  // List<productEntity>entities =pRepo.findBySkuAndPrice("bomb231" , BigDecimal.valueOf(13));  // it will give the data which sku and price match the given

   List<productEntity>entities =pRepo.findBySkuContaining("bom"); // find the data inside this word of sku value containing

  
  for (productEntity productEntity : entities) {
      System.out.println(productEntity);
    }
    
}

/* for using ouw own custom quey logical method */
@Test
void customQuery(){
    Optional<productEntity>prd=pRepo.findBySkuAndTitle("bomb231" , "parmaducvv");
    prd.ifPresent(System.out::println);  // sout the data if sku and title match

}


}
