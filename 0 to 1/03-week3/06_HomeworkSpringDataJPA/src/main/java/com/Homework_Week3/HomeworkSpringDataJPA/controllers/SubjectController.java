package com.Homework_Week3.HomeworkSpringDataJPA.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Homework_Week3.HomeworkSpringDataJPA.entities.SubjectEntity;
import com.Homework_Week3.HomeworkSpringDataJPA.services.SubjectServices;

@RestController
@RequestMapping(path = "/subject")
public class SubjectController {
    private SubjectServices subjectServices;

    public SubjectController(SubjectServices subjectServices) {
        this.subjectServices = subjectServices;
    }

        @GetMapping(path = "/{subjectId}")
    public SubjectEntity getSubjectById(@PathVariable Long subjectId) {
        return subjectServices.getSubjectById(subjectId);
    }

    @PostMapping
    public SubjectEntity createNewSubject(@RequestBody SubjectEntity subjectEntity){
        return subjectServices.createNewSubject(subjectEntity);
    }

     @PutMapping(path = "/{subjectId}/student/{studentId}")
    public SubjectEntity assignStudentToSubject(@PathVariable Long subjectId, @PathVariable Long studentId) {
        return subjectServices.assignStudentToSubject(subjectId , studentId);
    }
}
