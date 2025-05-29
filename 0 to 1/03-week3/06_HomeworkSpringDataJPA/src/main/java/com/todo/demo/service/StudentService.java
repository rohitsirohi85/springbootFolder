package com.todo.demo.service;

import com.todo.demo.entity.Student;
import com.todo.demo.entity.Subject;
import com.todo.demo.entity.Teacher;
import com.todo.demo.repo.StudentRepo;
import com.todo.demo.repo.SubjectRepo;
import com.todo.demo.repo.TeacherRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepo studentRepo;
    private final SubjectRepo subjectRepo;
    private final TeacherRepo teacherRepo;

    public Student createNewStudent(Student student) {
        studentRepo.save(student);
        return student;
    }

    public Student getStudentById(Long studentId) {
        return studentRepo.findById(studentId).orElseThrow(()-> new RuntimeException("not find any student"));
    }

    public void deleteStudentById(Long studentId) {
      Student student = studentRepo.findById(studentId).orElseThrow(()-> new RuntimeException("not find any student"));
      studentRepo.delete(student);
    }

    public Student updateInStudent(Long studentId, Map<String, Object> updates) {
        Student student = studentRepo.findById(studentId).orElseThrow(()-> new RuntimeException("not find any student"));
        updates.forEach((field,value)->{
            Field fieldToBeUpdated = ReflectionUtils.findField(Student.class,field);
            assert fieldToBeUpdated != null;
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated,student,value);
        });
        return studentRepo.save(student);
    }

    public Student assignSubjectsToStudent(Long studentId, Long subjectId) {

        Student student = studentRepo.findById(studentId).orElseThrow(()-> new RuntimeException("not find any student"));
        Subject subject =  subjectRepo.findById(subjectId).orElseThrow(()-> new RuntimeException("not find any subject"));
        student.getSubjects().add(subject);
        subject.getStudents().add(student);
       return studentRepo.save(student);


    }

    public Student assignStudentToTeacher(Long studentId, Long teacherId) {

        Student student = studentRepo.findById(studentId).orElseThrow(()-> new RuntimeException("not find any student"));
        Teacher teacher = teacherRepo.findById(teacherId).orElseThrow(()-> new RuntimeException("not find any teacher"));

        student.getTeachers().add(teacher);
        teacher.getStudents().add(student);
        return studentRepo.save(student);

    }
}
