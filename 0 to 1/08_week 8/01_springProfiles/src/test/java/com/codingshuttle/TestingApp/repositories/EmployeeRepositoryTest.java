package com.codingshuttle.TestingApp.repositories;

import com.codingshuttle.TestingApp.TestContainerConfiguration;
import com.codingshuttle.TestingApp.entities.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest  // it will run the whole application (but make test some slower )

@Import(TestContainerConfiguration.class)  // importing the testContainerConfiguration class
@DataJpaTest  // useful for testing repositories , entities and their interaction with database without make program slower

//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY) // it will use the h2 database for test instead of real database
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // bcz we don't want to use h2 database while using docket and testContainers
class EmployeeRepositoryTest {


    @Autowired
    private EmployeeRepository employeeRepository;

    private Employee employee;

    @BeforeEach
    void setUp(){
        employee = Employee.builder()
                .id(1L)
                .name("rohit")
                .email("rohit@gmail.com")
                .salary(100L)
                .build();
    }

    @Test
    void findByEmail_whenEmailIsPresent_thenReturnEmployee() {  // in this test we have to check that a email is valid(not empty) inside database

// given(Arrange)

        employeeRepository.save(employee);  // insert the data of a dummy employee inside database

//        when(Act)

      List<Employee> employeeList = employeeRepository.findByEmail(employee.getEmail());  // here we check findByEmail method that it is checking that email is valid or not , and returning a list of employee

//        then(Assert)   what need to be returned

        assertThat(employeeList).isNotNull(); // it is compulsory that email is not null
        assertThat(employeeList).isNotEmpty(); // not empty
        assertThat(employeeList.get(0).getEmail()).isEqualTo(employee.getEmail());  // check if email is equal to the given email or not

    }

    @Test
    void findByEmail_whenEmailNotFound_thenReturnEmptyEmployeeList(){ // in this test we have to check that a email is not available(empty) inside database
// given
        String email = "jdks@gmail.com";  // creating a random email to test

        // when

        List<Employee>employeeList = employeeRepository.findByEmail(email);  // check that email is present inside database or not

        // then   so we need that data is not null but should be empty bcz email should not be found inside database bcz we did;nt save that email inside database and this is we want with this test case to return empty if email is not found

        assertThat(employeeList).isNotNull();
        assertThat(employeeList).isEmpty();

    }
}