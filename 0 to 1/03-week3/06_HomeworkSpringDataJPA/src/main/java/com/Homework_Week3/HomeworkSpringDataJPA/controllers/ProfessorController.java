package com.Homework_Week3.HomeworkSpringDataJPA.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Homework_Week3.HomeworkSpringDataJPA.entities.ProfessorEntity;
import com.Homework_Week3.HomeworkSpringDataJPA.services.ProfessorServices;

@RestController
@RequestMapping(path = "/professor")
public class ProfessorController {
    private ProfessorServices professorServices;

    public ProfessorController(ProfessorServices professorServices) {
        this.professorServices = professorServices;
    }

        @GetMapping(path = "/{professorId}")
    public ProfessorEntity getProfessorById(@PathVariable Long professorId) {
        return professorServices.getProfessorById(professorId);
    }

    @PostMapping
    public ProfessorEntity createNewProfessor(@RequestBody ProfessorEntity professorEntity){
        return professorServices.createNewProfessor(professorEntity);
    }

    @PutMapping(path="/{professorId}/subject/{subjectId}")
    public ProfessorEntity assignSubjectToProfessor(@PathVariable Long professorId , @PathVariable Long subjectId){
              return professorServices.assignSubjectToProfessor(professorId ,subjectId);            
    } 
}
