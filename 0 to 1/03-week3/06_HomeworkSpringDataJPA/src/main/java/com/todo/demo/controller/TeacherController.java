package com.todo.demo.controller;

import com.todo.demo.entity.Student;
import com.todo.demo.entity.Teacher;
import com.todo.demo.repo.TeacherRepo;
import com.todo.demo.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;


    @PostMapping
    public Teacher createNewTeacher(@RequestBody Teacher teacher){
        return teacherService.createNewTeacher(teacher);
    }

    @GetMapping("/{teacherId}")
    public Teacher getTeacherById(@PathVariable Long teacherId){
        return teacherService.getTeacherById(teacherId);
    }

    @DeleteMapping("/{teacherId}")
    public void deleteTeacherById(@PathVariable Long teacherId ){
        teacherService.deleteTeacherById(teacherId);
    }

    @PatchMapping("/{teacherId}")
    public Teacher updateInTeacher(@PathVariable Long teacherId , @RequestBody Map<String,Object> updates){
        return teacherService.updateInTeacher(teacherId,updates);
    }


    @PostMapping("/{teacherId}/subject/{subjectId}")
    public Teacher assignSubjectToTeacher(@PathVariable Long teacherId,@PathVariable Long subjectId){
        return teacherService.assignSubjectToTeacher(teacherId,subjectId);
    }

}
