package com.Week2HHomeWork.demo.service;

import com.Week2HHomeWork.demo.dto.StudentDto;
import com.Week2HHomeWork.demo.entity.Student;
import com.Week2HHomeWork.demo.exceptions.ResourceNotFoundException;
import com.Week2HHomeWork.demo.repo.StudentRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {
    
    private final StudentRepo studentRepo;
    private final ModelMapper modelMapper;
    private final PocketMoneyService pocketMoneyService;

    @CachePut(cacheNames = "students",key = "#result.id")  // result.id - is a hardcore value for returning the result as key basis to id (cachePut is used when we want to update the cache while database info change so ,it will not give the wrong info(unchanged info))
    @Transactional   // to make it as a transactional so maintain consistency of code logic
    public StudentDto createNewStudent(StudentDto studentDto) {
        log.info("Creating new employee with email: {}", studentDto.getEmail());
        List<Student> existingEmployees = studentRepo.findByEmail(studentDto.getEmail());

        if (!existingEmployees.isEmpty()) {
            log.error("Employee already exists with email: {}", studentDto.getEmail());
            throw new RuntimeException("Employee already exists with email: " + studentDto.getEmail());
        }
        Student newStudent = modelMapper.map(studentDto, Student.class);
        Student savedStudent = studentRepo.save(newStudent);

        pocketMoneyService.createPocketMoneyAccount(savedStudent);

        log.info("Successfully created new employee with id: {}", savedStudent.getId());
        return modelMapper.map(savedStudent, StudentDto.class);
    }

    @Cacheable(cacheNames = "student")
    public List<StudentDto> getAllStudent() {
        List<Student> allStudent = studentRepo.findAll();

       return allStudent.stream()
                .map((element) -> modelMapper.map(element, StudentDto.class))
                .collect(Collectors.toList());

    }



    @CacheEvict(value = "employees",key = "#id")  // used to delete the cache also when we delete the data of a employee so wse don't want to store any waste data inside cache so when we delete the employee data we want that his cache data also be deleted (but remember don't se all entries method bcz it will delete the whole employee all data)
    public void deleteStudent(Long id) {
        log.info("Deleting employee with id: {}", id);
        boolean exists = studentRepo.existsById(id);
        if (!exists) {
            log.error("Employee not found with id: {}", id);
            throw new ResourceNotFoundException("Employee not found with id: " + id);
        }

        studentRepo.deleteById(id);
        log.info("Successfully deleted employee with id: {}", id);
    }
}
