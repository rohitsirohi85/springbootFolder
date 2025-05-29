package com.todo.demo.repo;

import com.todo.demo.entity.AdmissionRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmissionRepo extends JpaRepository<AdmissionRecord,Long > {
}
