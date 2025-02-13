package com.Homework_Week3.HomeworkSpringDataJPA.services;

import org.springframework.stereotype.Service;

import com.Homework_Week3.HomeworkSpringDataJPA.entities.AdmissionRecordEntity;
import com.Homework_Week3.HomeworkSpringDataJPA.repo.AdmissionRepo;

@Service
public class AdmissionServices {

    private final AdmissionRepo admissionRepo;

    

    public AdmissionServices(AdmissionRepo admissionRepo) {
        this.admissionRepo = admissionRepo;
    }

    public AdmissionRecordEntity getAdmissionRecordById(Long id) {
   return admissionRepo.findById(id).orElse(null);
    }

    public AdmissionRecordEntity createNewAdmission(AdmissionRecordEntity admissionRecordEntity) {
        return admissionRepo.save(admissionRecordEntity);
    }
    
}
