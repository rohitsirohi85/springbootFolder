package com.todo.demo.controller;

import com.todo.demo.entity.Student;
import com.todo.demo.repo.StudentRepo;
import com.todo.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public Student createNewStudent(@RequestBody Student student){
        return studentService.createNewStudent(student);
    }

    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable Long studentId){
        return studentService.getStudentById(studentId);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudentById(@PathVariable Long studentId ){
        studentService.deleteStudentById(studentId);
    }

    @PatchMapping("/{studentId}")
    public Student updateInStudent(@PathVariable Long studentId , @RequestBody Map<String,Object> updates){
        return studentService.updateInStudent(studentId,updates);
    }

    @PostMapping("/{studentId}/subject/{subjectId}")
    public Student assignSubjectsToStudent(@PathVariable Long studentId,@PathVariable Long subjectId){
        return studentService.assignSubjectsToStudent(studentId,subjectId);
    }

    @PostMapping("/{studentId}/teacher/{teacherId}")
    public Student assignStudentToTeacher(@PathVariable Long studentId,@PathVariable Long teacherId){

          return studentService.assignStudentToTeacher(studentId,teacherId);

    }

}
