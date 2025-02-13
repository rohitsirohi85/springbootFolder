package com.codingshuttle.cachingApp.repositories;

import com.codingshuttle.cachingApp.entities.SalaryAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryAccountRepo extends JpaRepository<SalaryAccount,Long> {
}
