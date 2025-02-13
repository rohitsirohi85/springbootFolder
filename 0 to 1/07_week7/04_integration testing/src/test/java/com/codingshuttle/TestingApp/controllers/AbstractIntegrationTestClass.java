package com.codingshuttle.TestingApp.controllers;

import com.codingshuttle.TestingApp.TestContainerConfiguration;
import com.codingshuttle.TestingApp.dto.EmployeeDto;
import com.codingshuttle.TestingApp.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.reactive.server.WebTestClient;

@AutoConfigureWebTestClient(timeout = "100000")  // it will configure webTestClient automatically without configure it by making bean
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)  // use this annotation bcz in IT test we want to use whole application and wth webEnvironment we define the port of our application
@Import(TestContainerConfiguration.class)
public class AbstractIntegrationTestClass {

    @Autowired
    WebTestClient webTestClient;


   Employee testEmployee = Employee.builder()
            .id(1L)
                 .name("Rohit")
                 .email("rohit@gmail.com")
                 .build();

   EmployeeDto testEmployeeDto = EmployeeDto.builder()
            .id(1L)
                 .name("Rohit")
                 .email("rohit@gmail.com")
                 .build();

}
