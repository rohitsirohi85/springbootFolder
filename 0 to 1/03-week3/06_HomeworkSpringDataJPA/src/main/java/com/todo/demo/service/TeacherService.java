package com.todo.demo.service;

import com.todo.demo.entity.Student;
import com.todo.demo.entity.Subject;
import com.todo.demo.entity.Teacher;
import com.todo.demo.repo.SubjectRepo;
import com.todo.demo.repo.TeacherRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepo teacherRepo;
    private final SubjectRepo subjectRepo;


    public Teacher createNewTeacher(Teacher teacher) {
        return teacherRepo.save(teacher);
    }

    public Teacher getTeacherById(Long teacherId) {
        return teacherRepo.findById(teacherId).orElseThrow(()-> new RuntimeException("not found teacher"));
    }

    public void deleteTeacherById(Long teacherId) {
        teacherRepo.deleteById(teacherId);
    }

    public Teacher updateInTeacher(Long teacherId, Map<String, Object> updates) {
        Teacher teacher = teacherRepo.findById(teacherId).orElseThrow(()-> new RuntimeException("not found teacher"));
        updates.forEach((key,value)->{
            Field field = ReflectionUtils.findField(Teacher.class,key);
            assert field != null;
            field.setAccessible(true);
            ReflectionUtils.setField(field,teacher,value);
        });
        return teacherRepo.save(teacher);
    }

    public Teacher assignSubjectToTeacher(Long teacherId, Long subjectId) {

        Teacher teacher = teacherRepo.findById(teacherId).orElseThrow(()-> new RuntimeException("not found teacher"));
        Subject subject = subjectRepo.findById(subjectId).orElseThrow(()-> new RuntimeException("not found subject"));

        teacher.getSubjects().add(subject);
        subject.setTeacher(teacher);
        subjectRepo.save(subject);
        return teacherRepo.save(teacher);

    }
}
