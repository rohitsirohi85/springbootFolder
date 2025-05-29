package com.todo.demo.service;

import com.todo.demo.entity.Subject;
import com.todo.demo.repo.StudentRepo;
import com.todo.demo.repo.SubjectRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepo subjectRepo;

    public Subject createNewsubject(Subject subject) {
        return subjectRepo.save(subject);
    }

    public Subject getSubjectById(Long subjectId) {
        return subjectRepo.findById(subjectId).orElseThrow(()-> new RuntimeException("not found"));
    }

    public void deleteSubjectById(Long subjectId) {
        subjectRepo.deleteById(subjectId);
    }


    public Subject updateInSubject(Long subjectId, Map<String, Object> updates) {

        Subject subject = subjectRepo.findById(subjectId).orElseThrow(()-> new RuntimeException("not found"));
        updates.forEach((key,value)->{
            Field field = ReflectionUtils.findField(Subject.class,key);
            assert field != null;
            field.setAccessible(true);
            ReflectionUtils.setField(field,subject,value);
        });
      return subjectRepo.save(subject);
    }
}
