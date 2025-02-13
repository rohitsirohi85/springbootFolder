package com.Homework_Week3.HomeworkSpringDataJPA.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Homework_Week3.HomeworkSpringDataJPA.entities.AdmissionRecordEntity;
import com.Homework_Week3.HomeworkSpringDataJPA.entities.ProfessorEntity;
import com.Homework_Week3.HomeworkSpringDataJPA.entities.StudentEntity;
import com.Homework_Week3.HomeworkSpringDataJPA.repo.AdmissionRepo;
import com.Homework_Week3.HomeworkSpringDataJPA.repo.ProfessorRepo;
import com.Homework_Week3.HomeworkSpringDataJPA.repo.StudentRepo;

@Service
public class StudentServices {

    private final StudentRepo studentRepo;
    private final ProfessorRepo professorRepo;
    private AdmissionRepo admissionRepo;

    

    

    public StudentServices(StudentRepo studentRepo, ProfessorRepo professorRepo, AdmissionRepo admissionRepo) {
        this.studentRepo = studentRepo;
        this.professorRepo = professorRepo;
        this.admissionRepo = admissionRepo;
    }

    public StudentEntity getStudentById(Long id) {
        return studentRepo.findById(id).orElse(null);
    }

    public StudentEntity createNewStudent(StudentEntity studentEntity) {
      return studentRepo.save(studentEntity);
    }

    public StudentEntity assignProfessorToStudent(Long professorId, Long studentId) {
        Optional<StudentEntity> studentEntity = studentRepo.findById(studentId);
        Optional<ProfessorEntity> professorEntity = professorRepo.findById(professorId);

       return studentEntity.flatMap(student->professorEntity.map(professor->{
                professor.getStudents().add(student);
                professorRepo.save(professor);
                  student.getProfessors().add(professor);
                return studentRepo.save(student);
       })).orElse(null);
    }

    public StudentEntity assignAdmissionRecordToStudent(Long studentId, Long admissionId) {
        Optional<StudentEntity> studentEntity = studentRepo.findById(studentId);
       Optional<AdmissionRecordEntity> admissionRecordEntity=admissionRepo.findById(admissionId);

       return studentEntity.flatMap(student -> admissionRecordEntity.map(admission -> {
        // Assign the student to the admission record
        admission.setStudentRecord(student);
        admissionRepo.save(admission);  // Save the updated admission record

        // Set the admission record to the student
        student.setAdmissionRecord(admission);
        return studentRepo.save(student);  // Save and return the updated student
    })).orElse(null);
}

}
