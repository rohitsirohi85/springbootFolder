package com.Homework_Week3.HomeworkSpringDataJPA.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Homework_Week3.HomeworkSpringDataJPA.entities.AdmissionRecordEntity;

import com.Homework_Week3.HomeworkSpringDataJPA.services.AdmissionServices;

@RestController
@RequestMapping(path = "/admission_record")
public class AdmissionController {
          private AdmissionServices admissionServices;

        public AdmissionController(AdmissionServices admissionServices) {
            this.admissionServices = admissionServices;
        }

       
             @GetMapping(path = "/{admissionId}")
    public AdmissionRecordEntity getAdmissionRecordById(@PathVariable Long admissionId) {
        return admissionServices.getAdmissionRecordById(admissionId);
    }

    @PostMapping
    public AdmissionRecordEntity createNewAdmission(@RequestBody AdmissionRecordEntity admissionRecordEntity ){
        return admissionServices.createNewAdmission(admissionRecordEntity);
    }

}
