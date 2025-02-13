package com.codingshuttle.TestingApp.services.impl;

import com.codingshuttle.TestingApp.TestContainerConfiguration;
import com.codingshuttle.TestingApp.dto.EmployeeDto;
import com.codingshuttle.TestingApp.entities.Employee;
import com.codingshuttle.TestingApp.exceptions.ResourceNotFoundException;
import com.codingshuttle.TestingApp.repositories.EmployeeRepository;
import com.codingshuttle.TestingApp.services.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

//@SpringBootTest
@Import(TestContainerConfiguration.class)  // importing the testContainerConfiguration class
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // bcz we don't want to use h2 database while using docker and testContainers
@ExtendWith(MockitoExtension.class) // means that we want to inject mocks so that we don't need to use @SpringBootTest
class EmployeeServiceImplTest {

    @Mock  // use for inject the needed classes
    private EmployeeRepository employeeRepository;

    @Spy // we don't need to use @Mock here bcz modelMapper is a dependency it's already tested by springBoot so here only we want to use modelMapper instead of testing that's why we use @Spy
    private ModelMapper modelMapper;

    @InjectMocks  // used for inject the test class we want
    private EmployeeServiceImpl employeeService; // we use EmployeeServiceImpl instead of EmployeeService bcz employee service is an interface and mock did'nt understand that we have a impl of employee service so it gives an error bcz an instance of an interface can't be created so that's why only use exact class for mocks


    private Employee mockedEmployee;
    private EmployeeDto mockedEmployeeDto;


    @BeforeEach
   void setUp() {
        mockedEmployee = Employee.builder()
                .id(1L)
                .name("Rohit")
                .email("rohit@gmail.com")
                .build();

      mockedEmployeeDto = modelMapper.map(mockedEmployee, EmployeeDto.class);
    }


    @Test
     void testGetEmployeeById_whenEmployeeIsPresent_thenReturnEmployeeDto(){
//    assign

          Long id=mockedEmployee.getId();
        when(employeeRepository.findById(id)).thenReturn(Optional.of(mockedEmployee));  // stubbing

//        act

        EmployeeDto employeeDto = employeeService.getEmployeeById(mockedEmployee.getId());

//        assert
        assertThat(employeeDto).isNotNull();
           assertThat(employeeDto.getId()).isEqualTo(mockedEmployee.getId());
           assertThat(employeeDto.getEmail()).isEqualTo(mockedEmployee.getEmail());
           verify(employeeRepository).findById(id);   // verify that findById from employee repository called or not if not called throw an error
           verify(employeeRepository,only()).findById(id);   // verify that findById from employee repository called only and no other method called if it is called throw an error
           verify(employeeRepository,atLeast(1)).findById(id);   // verify that findById from employee repository called by atLeast given number of times if not called throw an error
           verify(employeeRepository,atMost(2)).findById(id);   // verify that findById from employee repository called by maximum given times or less if called more than given times throw an error
     }

     @Test
     void testGetEmployeeById_whenEmployeeIsNotPresent_thenThrowException(){
        //assign

          when(employeeRepository.findById(anyLong())).thenReturn(Optional.empty());

         ///act adn assert

         assertThatThrownBy(()->employeeService.getEmployeeById(1L))
                 .isInstanceOf(ResourceNotFoundException.class)
                 .hasMessage("Employee not found with id: 1");

         verify(employeeRepository).findById(1L);

     }

     @Test
    void testCreateNewEmployee_whenValidEmployee_thenReturnEmployeeDto(){
        // assign

         when(employeeRepository.findByEmail(anyString())).thenReturn(List.of());
         when(employeeRepository.save(any(Employee.class))).thenReturn(mockedEmployee);

         //act

           EmployeeDto employeeDto = employeeService.createNewEmployee(mockedEmployeeDto);

         //assert
         // Asserts that the 'employeeDto' object is not null
         assertThat(employeeDto).isNotNull();

// Asserts that the email in 'employeeDto' is equal to the email in 'mockedEmployeeDto'
         assertThat(employeeDto.getEmail()).isEqualTo(mockedEmployeeDto.getEmail());

// Creates an ArgumentCaptor to capture the Employee object passed to the 'save' method of employeeRepository
         ArgumentCaptor<Employee> employeeArgumentCaptor = ArgumentCaptor.forClass(Employee.class);

// Verifies that the 'save' method of 'employeeRepository' was called, and captures the Employee object passed to it
         verify(employeeRepository).save(employeeArgumentCaptor.capture());

// Retrieves the Employee object captured by the ArgumentCaptor
         Employee capturedEmployee = employeeArgumentCaptor.getValue();

// Asserts that the email of the captured Employee object is equal to the email of 'mockedEmployee'
         assertThat(capturedEmployee.getEmail()).isEqualTo(mockedEmployee.getEmail());

     }

     @Test
    void testCreateNewEmployee_whenEmployeeEmailISAlreadyPresent_thenThrowException(){
        //assign

           when(employeeRepository.findByEmail(mockedEmployeeDto.getEmail())).thenReturn(List.of(mockedEmployee));

         //act and assert

         assertThatThrownBy(()->employeeService.createNewEmployee(mockedEmployeeDto))
                 .isInstanceOf(RuntimeException.class)
                 .hasMessage("Employee already exists with email: "+mockedEmployee.getEmail());
         verify(employeeRepository).findByEmail(mockedEmployeeDto.getEmail());  // verify that findByEmail method is must be running
         verify(employeeRepository,never()).save(mockedEmployee); // verifying that .save() must never running
     }

     @Test
    void testUpdateEmployee_whenEmployeeNotPresent_thenReturnException(){
        //assign

          when(employeeRepository.findById(1L)).thenReturn(Optional.empty());

         //act and assert

         assertThatThrownBy(()->employeeService.updateEmployee(1L,mockedEmployeeDto))
                 .isInstanceOf(ResourceNotFoundException.class)
                 .hasMessage("Employee not found with id: 1");
         verify(employeeRepository).findById(1L);
         verify(employeeRepository,never()).save(mockedEmployee);

     }

     @Test
    void testUpdateEmployee_whenAttemptingToChangeEmail_thenThrowException(){
        //assign

         when(employeeRepository.findById(mockedEmployeeDto.getId())).thenReturn(Optional.of(mockedEmployee));
         mockedEmployeeDto.setName("Naman");  // name can be updated
         mockedEmployeeDto.setEmail("Naman@gmail.com"); // email can't be updated has to throw an error

         //act and assert

          assertThatThrownBy(()->employeeService.updateEmployee(mockedEmployeeDto.getId(),mockedEmployeeDto))
                  .isInstanceOf(RuntimeException.class)
                  .hasMessage("The email of the employee cannot be updated");
         verify(employeeRepository).findById(1L);
         verify(employeeRepository,never()).save(mockedEmployee);

     }

     @Test
    void testUpdateEmployee_whenEmployeeValid_thenReturnEmployeeDto(){
        //assign

         when(employeeRepository.findById(mockedEmployeeDto.getId())).thenReturn(Optional.of(mockedEmployee));
         mockedEmployeeDto.setName("sameer");  // name can be updated
         mockedEmployeeDto.setSalary(123L);

         Employee newEmployee = modelMapper.map(mockedEmployeeDto, Employee.class);
         when(employeeRepository.save(any(Employee.class))).thenReturn(newEmployee);

         //act

         EmployeeDto updatedemployeeDto = employeeService.updateEmployee(mockedEmployeeDto.getId(),mockedEmployeeDto);

         //assert
         assertThat(updatedemployeeDto).isEqualTo(mockedEmployeeDto);
         verify(employeeRepository).findById(1L);
         verify(employeeRepository).save(any());
     }

     @Test
    void testDeleteEmployee_whenEmployeeNotPresent_thenThrowException(){
        //assign

         when(employeeRepository.existsById(1L)).thenReturn(false);

         //act and assert

         assertThatThrownBy(()->employeeService.deleteEmployee(1L))
                 .isInstanceOf(ResourceNotFoundException.class)
                 .hasMessage("Employee not found with id: 1");
         verify(employeeRepository).existsById(1L);
     }

     @Test
      void testDeleteEmployee_whenEmployeePresent_thenDeleteEmployee(){
        //assign
         when(employeeRepository.existsById(1L)).thenReturn(true);

         assertThatCode(()->employeeService.deleteEmployee(1L)).doesNotThrowAnyException(); //check that this does not have to throw any exception

        verify(employeeRepository).deleteById(1L);




     }

}