package com.Homework_Week3.HomeworkSpringDataJPA.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Homework_Week3.HomeworkSpringDataJPA.entities.StudentEntity;
import com.Homework_Week3.HomeworkSpringDataJPA.entities.SubjectEntity;
import com.Homework_Week3.HomeworkSpringDataJPA.repo.StudentRepo;
import com.Homework_Week3.HomeworkSpringDataJPA.repo.SubjectRepo;

@Service
public class SubjectServices {

    private final SubjectRepo subjectRepo;
    private final StudentRepo studentRepo;

    

    

    public SubjectServices(SubjectRepo subjectRepo, StudentRepo studentRepo) {
        this.subjectRepo = subjectRepo;
        this.studentRepo = studentRepo;
    }

    public SubjectEntity getSubjectById(Long id) {
        return subjectRepo.findById(id).orElse(null);
    }

    public SubjectEntity createNewSubject(SubjectEntity subjectEntity) {
     return subjectRepo.save(subjectEntity);
    }

    public SubjectEntity assignStudentToSubject(Long subjectId, Long studentId) {
       Optional<SubjectEntity> subjectEntity =subjectRepo.findById(subjectId);
       Optional<StudentEntity> studentEntity=studentRepo.findById(studentId);

       return subjectEntity.flatMap(subject->studentEntity.map(student->{
                student.getSubjects().add(subject);
                studentRepo.save(student);

                subject.getStudents().add(student);
                return subjectRepo.save(subject);
       })).orElse(null);
    }
    
}
