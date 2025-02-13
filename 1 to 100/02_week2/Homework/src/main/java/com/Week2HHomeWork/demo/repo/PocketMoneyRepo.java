package com.Week2HHomeWork.demo.repo;

import com.Week2HHomeWork.demo.entity.PocketMoney;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PocketMoneyRepo extends JpaRepository<PocketMoney,Long> {
    @Override
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<PocketMoney> findById(Long id);
}
