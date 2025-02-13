package com.Week2HHomeWork.demo.repo;

import com.Week2HHomeWork.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {
    List<Student> findByEmail(String email);
}
