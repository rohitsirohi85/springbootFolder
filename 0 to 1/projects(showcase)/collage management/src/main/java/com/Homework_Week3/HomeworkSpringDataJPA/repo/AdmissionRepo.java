package com.Homework_Week3.HomeworkSpringDataJPA.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Homework_Week3.HomeworkSpringDataJPA.entities.AdmissionRecordEntity;

@Repository
public interface AdmissionRepo extends JpaRepository<AdmissionRecordEntity ,Long>{

    
}