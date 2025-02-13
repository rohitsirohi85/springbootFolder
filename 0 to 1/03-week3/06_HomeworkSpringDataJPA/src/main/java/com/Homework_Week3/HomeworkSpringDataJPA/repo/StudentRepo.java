package com.Homework_Week3.HomeworkSpringDataJPA.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Homework_Week3.HomeworkSpringDataJPA.entities.StudentEntity;

@Repository
public interface StudentRepo extends JpaRepository<StudentEntity ,Long> {
    
}
