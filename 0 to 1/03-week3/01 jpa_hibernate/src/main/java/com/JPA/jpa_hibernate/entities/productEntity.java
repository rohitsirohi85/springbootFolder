package com.JPA.jpa_hibernate.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(
    name = "Product_R2",
    uniqueConstraints = {  // used to make some constraints unique
        @UniqueConstraint( name="SKU_VALUE" ,columnNames = {"sku"}),  
        @UniqueConstraint(name="Title_price_unique" , columnNames={"Title_Name" , "price"})  // means only 1 product can have a similar price like parle with price 20 and parle with price 30 okk ,but same parle with price 20 product can't be existed
        // we can add many unique constraint we want
    },
    indexes = { // used to enhance our query
              @Index(name="sku_index" , columnList = "sku")  // we can add many indexes we  want
    }
)
public class productEntity {
    

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
          private long id;

          private BigDecimal price;

          @Column(nullable=false , length=20)
          private String sku;


          @Column(name = "Title_Name" , length = 20)  // not it is only title field bu it's real name is Title_Name
          private String title;


          @CreationTimestamp
          private LocalDateTime createdAt;

          @UpdateTimestamp
          private LocalDateTime UpdatedAt;

}
