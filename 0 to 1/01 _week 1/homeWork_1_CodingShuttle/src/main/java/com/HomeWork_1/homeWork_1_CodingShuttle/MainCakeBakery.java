package com.HomeWork_1.homeWork_1_CodingShuttle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication


public class MainCakeBakery implements CommandLineRunner {

@Autowired
ServiceConfig scf;


    public static void main(String[] args) {
        SpringApplication.run(MainCakeBakery.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
      System.out.println(scf.bakecake());
    }
}
