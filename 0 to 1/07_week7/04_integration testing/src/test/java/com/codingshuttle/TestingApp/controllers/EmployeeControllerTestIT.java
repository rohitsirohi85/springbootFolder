package com.codingshuttle.TestingApp.controllers;

import com.codingshuttle.TestingApp.TestContainerConfiguration;
import com.codingshuttle.TestingApp.dto.EmployeeDto;
import com.codingshuttle.TestingApp.entities.Employee;
import com.codingshuttle.TestingApp.repositories.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;

// note:this class is extended by AbstractIntegrationTestClass means that we made this extended class so all the repeated libraries , objects , annotations  for this main class which is useful for every test case are moved inside that extended class and that class is extended by this mai class so ,we do it for neat and clean code (just a simple inheritance)
class EmployeeControllerTestIT extends AbstractIntegrationTestClass{    // in this class name IT means(integration testing) so that we can understand which test is a unit and which is integration



     @Autowired
     private EmployeeRepository employeeRepository;




     @BeforeEach
     void setUp(){

          employeeRepository.deleteAll();  // for deleting the employee data everytime when using save method so ,it will not throw error
     }

     @Test
    void testGetEmployeeById_success(){
          Employee savedEmployee = employeeRepository.save(testEmployee);
          webTestClient.get()
                  .uri("/employees/{id}",savedEmployee.getId())
                  .exchange()
                  .expectBody()
                  .jsonPath("$.id").isEqualTo(savedEmployee.getId())
                  .jsonPath("$.email").isEqualTo(savedEmployee.getEmail());

     }

     @Test
    void testGetEmployeeById_failure(){
         webTestClient.get()
                 .uri("/employees/1")
                 .exchange()
                 .expectStatus().isNotFound();
     }

     @Test
    void testCreateNewEmployee_whenEmployeeAlreadyExist_thenThrowException(){
         Employee savedEmployee = employeeRepository.save(testEmployee);
         webTestClient.post()
                 .uri("/employees")
                 .bodyValue(testEmployeeDto)
                 .exchange()
                 .expectStatus().is5xxServerError();

     }

     @Test
    void testCreateNewEmployee_whenEmployeeAlreadyNotExist_thenCreateEmployee(){

         webTestClient.post()
                 .uri("/employees")
                 .bodyValue(testEmployeeDto)
                 .exchange()
                 .expectStatus().isCreated()
                 .expectBody()
                 .jsonPath("$.email").isEqualTo(testEmployeeDto.getEmail()); //check if the created email is equal to provided email if yes so we are success to create a new data in database

     }

     @Test
     void testUpdateEmployee_whenEmployeeNotExist_thenThrowException(){

         webTestClient.put()
                 .uri("/employees/99") //giving a random id which have not any data inside database
                 .bodyValue(testEmployeeDto)
                 .exchange()
                 .expectStatus().isNotFound();
     }


     @Test
    void testUpdateEmployee_whenAttemptingToChangeEmail_thenThrowException(){
         Employee savedEmployee = employeeRepository.save(testEmployee);
         testEmployeeDto.setEmail("random@gmail.com"); // attempting to change email
         testEmployeeDto.setName("rahul"); // name changing is valid but email is not
         webTestClient.put()
                 .uri("/employees/{id}",savedEmployee.getId())
                 .bodyValue(testEmployeeDto)
                 .exchange()
                 .expectStatus().is5xxServerError();
     }

    @Test
    void testUpdateEmployee_whenValidEmployeeChange_thenUpdateEmployee(){
        Employee savedEmployee = employeeRepository.save(testEmployee);
        testEmployeeDto.setName("rahul"); // name changing is valid but email is not

        webTestClient.put()
                .uri("/employees/{id}",savedEmployee.getId())
                .bodyValue(testEmployeeDto)
                .exchange()
                .expectStatus().isOk()
                .expectBody(EmployeeDto.class)
                .isEqualTo(testEmployeeDto);
    }

    @Test
    void testDeleteEmployee_whenEmployeeNotExist_thenThrowException(){
         webTestClient.delete()
                 .uri("/employees/23")
                 .exchange()
                 .expectStatus().isNotFound();

    }

    @Test
    void testDeleteEmployee_whenEmployeeExist_thenDelete(){

         Employee savedEmployee = employeeRepository.save(testEmployee);

        webTestClient.delete()
                .uri("/employees/{id}",savedEmployee.getId())
                .exchange()
                .expectStatus().isNoContent()
                .expectBody(Void.class);
    }


}