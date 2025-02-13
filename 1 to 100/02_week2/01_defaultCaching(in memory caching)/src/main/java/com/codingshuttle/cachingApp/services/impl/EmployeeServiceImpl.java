package com.codingshuttle.cachingApp.services.impl;

import com.codingshuttle.cachingApp.dto.EmployeeDto;
import com.codingshuttle.cachingApp.entities.Employee;
import com.codingshuttle.cachingApp.exceptions.ResourceNotFoundException;
import com.codingshuttle.cachingApp.repositories.EmployeeRepository;
import com.codingshuttle.cachingApp.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Override
    @Cacheable(cacheNames = "employees" , key = "#id")  // used to store the data in caching so that can give us the faster result everytime we hit
    public EmployeeDto getEmployeeById(Long id) {
        log.info("Fetching employee with id: {}", id);
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Employee not found with id: {}", id);
                    return new ResourceNotFoundException("Employee not found with id: " + id);
                });
        log.info("Successfully fetched employee with id: {}", id);
        return modelMapper.map(employee, EmployeeDto.class);
    }

    @Override
    @CachePut(cacheNames = "employees",key = "#result.id")  // result.id - is a hardcore value for returning the result as key basis to id (cachePut is used when we want to update the cache while database info change so ,it will not give the wrong info(unchanged info))
    @Transactional
    public EmployeeDto createNewEmployee(EmployeeDto employeeDto) {
        log.info("Creating new employee with email: {}", employeeDto.getEmail());
        List<Employee> existingEmployees = employeeRepository.findByEmail(employeeDto.getEmail());

        if (!existingEmployees.isEmpty()) {
            log.error("Employee already exists with email: {}", employeeDto.getEmail());
            throw new RuntimeException("Employee already exists with email: " + employeeDto.getEmail());
        }
        Employee newEmployee = modelMapper.map(employeeDto, Employee.class);
        Employee savedEmployee = employeeRepository.save(newEmployee);


        log.info("Successfully created new employee with id: {}", savedEmployee.getId());
        return modelMapper.map(savedEmployee, EmployeeDto.class);
    }

    @Override
    @CachePut(value = "employees",key = "#id")
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        log.info("Updating employee with id: {}", id);
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Employee not found with id: {}", id);
                    return new ResourceNotFoundException("Employee not found with id: " + id);
                });

        if (!employee.getEmail().equals(employeeDto.getEmail())) {
            log.error("Attempted to update email for employee with id: {}", id);
            throw new RuntimeException("The email of the employee cannot be updated");
        }

        modelMapper.map(employeeDto, employee);
        employee.setId(id);

        Employee savedEmployee = employeeRepository.save(employee);
        log.info("Successfully updated employee with id: {}", id);
        return modelMapper.map(savedEmployee, EmployeeDto.class);
    }

    @Override
    @CacheEvict(value = "employees",key = "#id")  // used to delete the cache also when we delete the data of a employee so wse don't want to store any waste data inside cache so when we delete the employee data we want that his cache data also be deleted (but remember don't se all entries method bcz it will delete the whole employee all data)
    public void deleteEmployee(Long id) {
        log.info("Deleting employee with id: {}", id);
        boolean exists = employeeRepository.existsById(id);
        if (!exists) {
            log.error("Employee not found with id: {}", id);
            throw new ResourceNotFoundException("Employee not found with id: " + id);
        }

        employeeRepository.deleteById(id);
        log.info("Successfully deleted employee with id: {}", id);
    }
}