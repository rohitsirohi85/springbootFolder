package com.todo.demo.service;

import com.todo.demo.entity.AdmissionRecord;
import com.todo.demo.entity.Student;
import com.todo.demo.repo.AdmissionRepo;
import com.todo.demo.repo.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AdmissionService {

    private final AdmissionRepo admissionRepo;
    private final StudentRepo studentRepo;

    public AdmissionRecord createNewAdmission(AdmissionRecord admissionRecord) {

        return admissionRepo.save(admissionRecord);

    }

    public AdmissionRecord getAdmissionRecordByStudentId(Long studentId) {

        Student student = studentRepo.findById(studentId).orElseThrow(()-> new RuntimeException("not found"));
       return student.getAdmissionRecord();

    }

    public void deleteByAdmissionId(Long admissionId) {

        admissionRepo.deleteById(admissionId);

    }

    public AdmissionRecord updateInAdmissionRecord(Long admissionId, Map<String, Object> updates) {

        AdmissionRecord admissionRecord = admissionRepo.findById(admissionId).orElseThrow(()-> new RuntimeException("not found"));
        updates.forEach((key,value)->{
            Field field = ReflectionUtils.findField(AdmissionRecord.class,key);
            assert field != null;
            field.setAccessible(true);
            ReflectionUtils.setField(field,admissionRecord,value);
        });

        return admissionRepo.save(admissionRecord);



    }

    public AdmissionRecord assingStudentToAdmissionRecord(Long admissionId, Long studentId) {
        AdmissionRecord admissionRecord = admissionRepo.findById(admissionId).orElseThrow(()-> new RuntimeException("not found"));
        Student student = studentRepo.findById(studentId).orElseThrow(()-> new RuntimeException("not found"));
        admissionRecord.setStudent(student);
        admissionRepo.save(admissionRecord);
        return admissionRecord;
    }
}
