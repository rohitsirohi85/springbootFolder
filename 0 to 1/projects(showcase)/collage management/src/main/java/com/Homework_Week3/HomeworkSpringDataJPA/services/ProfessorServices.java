package com.Homework_Week3.HomeworkSpringDataJPA.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Homework_Week3.HomeworkSpringDataJPA.entities.ProfessorEntity;
import com.Homework_Week3.HomeworkSpringDataJPA.entities.SubjectEntity;
import com.Homework_Week3.HomeworkSpringDataJPA.repo.ProfessorRepo;
import com.Homework_Week3.HomeworkSpringDataJPA.repo.SubjectRepo;

@Service
public class ProfessorServices {

    private final ProfessorRepo professorRepo;
    private final SubjectRepo subjectRepo;

    

    public ProfessorServices(ProfessorRepo professorRepo, SubjectRepo subjectRepo) {
        this.professorRepo = professorRepo;
        this.subjectRepo = subjectRepo;
    }

    public ProfessorEntity getProfessorById(Long id) {
        return professorRepo.findById(id).orElse(null);
    }

    public ProfessorEntity createNewProfessor(ProfessorEntity professorEntity) {
        return professorRepo.save(professorEntity);
    }

    public ProfessorEntity assignSubjectToProfessor(Long professorId, Long subjectId) {
        Optional<ProfessorEntity> professorEntity = professorRepo.findById(professorId);
        Optional<SubjectEntity> subjectEntity = subjectRepo.findById(subjectId);

        return professorEntity.flatMap(professor ->
        subjectEntity.map(subject->{
            subject.setProfessor(professor);
            subjectRepo.save(subject);
            professor.getSubjects().add(subject);
            return professorRepo.save(professor);
        })
).orElse(null);
}

}
