package com.Week2HHomeWork.demo.controller;

import com.Week2HHomeWork.demo.dto.StudentDto;
import com.Week2HHomeWork.demo.entity.PocketMoney;
import com.Week2HHomeWork.demo.entity.Student;
import com.Week2HHomeWork.demo.service.PocketMoneyService;
import com.Week2HHomeWork.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

       private final StudentService studentService;
       private final PocketMoneyService pocketMoneyService;


    @PostMapping
    public ResponseEntity<StudentDto> createNewEmployee(@RequestBody StudentDto studentDto) {
        StudentDto studentDto1 = studentService.createNewStudent(studentDto);
        return new ResponseEntity<>(studentDto1, HttpStatus.CREATED);
    }

       @GetMapping
      public ResponseEntity<List<StudentDto>> getAllStudent(){
          List<StudentDto> studentDto = studentService.getAllStudent();
           return ResponseEntity.ok(studentDto);
       }

       @PutMapping("/incrementBalance/{Id}")
    public ResponseEntity<PocketMoney> incrementBalance(@PathVariable Long Id){
          PocketMoney pocketMoney = pocketMoneyService.incrementBalance(Id);
           return ResponseEntity.ok(pocketMoney);
       }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

}
