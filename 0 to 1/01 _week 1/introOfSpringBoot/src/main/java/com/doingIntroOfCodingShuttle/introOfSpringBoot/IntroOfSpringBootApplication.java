package com.doingIntroOfCodingShuttle.introOfSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication  //it always dedicate the main class..it's only one in entire program before main class
public class IntroOfSpringBootApplication implements CommandLineRunner {

	// @Autowired
	//  apple obj1;

	//  @Autowired
	//  apple obj2;

	 /*  next lect 3... dependency injection */

	 @Autowired
	 databaseService dbs;

	public static void main(String[] args) {
		SpringApplication.run(IntroOfSpringBootApplication.class, args);
		 
	}
	@Override
	public void run(String... args) throws Exception {
		
		// obj1.eating(); 
		// System.out.println(obj1.hashCode());  // hashcode is a unique value for every object
		// obj2.eating();
		
		// System.out.println(obj2.hashCode());
		
		/* for lecture 3... */
		System.out.println(dbs.getdata());

	}

}
