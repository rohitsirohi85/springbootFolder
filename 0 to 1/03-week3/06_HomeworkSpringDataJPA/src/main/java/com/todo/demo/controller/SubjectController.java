package com.todo.demo.controller;

import com.todo.demo.entity.Student;
import com.todo.demo.entity.Subject;
import com.todo.demo.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/subject")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;


    @PostMapping
    public Subject createNewSubject(@RequestBody Subject subject){
        return subjectService.createNewsubject(subject);
    }

    @GetMapping("/{subjectId}")
    public Subject getSubjectById(@PathVariable Long subjectId){
        return subjectService.getSubjectById(subjectId);
    }

    @DeleteMapping("/{subjectId}")
    public void deleteSubjectById(@PathVariable Long subjectId ){
        subjectService.deleteSubjectById(subjectId);
    }

    @PatchMapping("/{subjectId}")
    public Subject updateInSubject(@PathVariable Long subjectId , @RequestBody Map<String,Object> updates){
        return subjectService.updateInSubject(subjectId,updates);
    }


}
