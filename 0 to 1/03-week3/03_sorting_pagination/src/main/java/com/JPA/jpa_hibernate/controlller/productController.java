package com.JPA.jpa_hibernate.controlller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.JPA.jpa_hibernate.entities.productEntity;
import com.JPA.jpa_hibernate.repo.productRepo;

@RestController
@RequestMapping(path = "/products")
public class productController {
    private final productRepo productRepo;

    public productController(com.JPA.jpa_hibernate.repo.productRepo productRepo) {
        this.productRepo = productRepo;
    }

    /* get the sorted data */
    // @GetMapping
    // public List<productEntity> getAll(){
    // return productRepo.findByOrderByPrice(); // so it will give the price data
    // but in a sorted way by price
    // }

    /* sorted the data on web-server directly which want */

    // @GetMapping
    // public List<productEntity>getAllProducts(@RequestParam(defaultValue = "id")
    // String sortBy){ // means it will run thid program on web server and we can
    // the direct sortby which is String but if we don't provide any value of sortBy
    // it will sort the by id default
    // // return productRepo.findBy(Sort.by(sortBy)); // sort.by for sorting

    // return productRepo.findBy(Sort.by(Sort.Direction.DESC ,sortBy , "price")); //
    // means sort in descending order but if two data has same sortBy filed so that
    // will sort according to price..
    // }

    /* give the number of sorted data ina page according to size of page number */

    // int PAGE_SIZE=5;
    // @GetMapping
    // public List<productEntity> gettingData(@RequestParam(defaultValue = "id") String sortBy,
    //         @RequestParam(defaultValue = "0") Integer pageNumber) { //default indexing of page is 0
    //                   Pageable pageable =PageRequest.of(pageNumber, PAGE_SIZE,Sort.by(sortBy)); // for printing in sorted manner
    //                   return productRepo.findAll(pageable).getContent();
    // }


    /* now combining all knowledge we known about sorting and paging.. */

    int PAGE_SIZE=5;
     
    //http://localhost:8080/products?sortBy=price&pageNumber=1
    // NOTE: we can change the sortBy according to our choice that what order we want
    // in a single page print data according to PAGE_SIZE

    @GetMapping
    public List<productEntity>ResponseData(
                        @RequestParam(defaultValue = "") String title,
                         @RequestParam(defaultValue = "id") String sortBy,
                           @RequestParam(defaultValue = "0") Integer pageNumber){
  return productRepo.findByTitleContainingIgnoreCase(title , PageRequest.of(pageNumber, PAGE_SIZE, Sort.by(sortBy)));
    }
}
