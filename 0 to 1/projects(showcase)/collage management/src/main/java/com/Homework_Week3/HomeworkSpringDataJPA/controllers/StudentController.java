package com.Homework_Week3.HomeworkSpringDataJPA.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Homework_Week3.HomeworkSpringDataJPA.entities.StudentEntity;
import com.Homework_Week3.HomeworkSpringDataJPA.services.StudentServices;

@RestController
@RequestMapping(path = "/student")
public class StudentController {
    private StudentServices studentServices;

    public StudentController(StudentServices studentServices) {
        this.studentServices = studentServices;
    }

    @GetMapping(path = "/{studentId}")
    public StudentEntity getStudentById(@PathVariable Long studentId) {
        return studentServices.getStudentById(studentId);
    }

    @PostMapping
    public StudentEntity createNewStudent(@RequestBody StudentEntity studentEntity) {
        return studentServices.createNewStudent(studentEntity);
    }

    @PutMapping(path = "/{studentId}/professor/{professorId}")
    public StudentEntity assignProfessorToStudent(@PathVariable Long studentId, @PathVariable Long professorId) {
        return studentServices.assignProfessorToStudent(studentId, professorId);
    }

    @PutMapping(path = "/{studentId}/admission/{admissionId}")
    public StudentEntity assignAdmissionRecordToStudent(@PathVariable Long studentId, @PathVariable Long admissionId) {
        return studentServices.assignAdmissionRecordToStudent(studentId, admissionId);
    }
}
