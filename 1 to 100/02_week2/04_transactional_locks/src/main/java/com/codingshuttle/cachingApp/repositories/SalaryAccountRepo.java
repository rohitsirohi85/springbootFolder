package com.codingshuttle.cachingApp.repositories;

import com.codingshuttle.cachingApp.entities.SalaryAccount;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SalaryAccountRepo extends JpaRepository<SalaryAccount,Long> {

    @Override
    @Lock(LockModeType.PESSIMISTIC_WRITE)    // override findById to achieve a lock state so that we can handle the concurrency state
    Optional<SalaryAccount>findById(Long id);

}
