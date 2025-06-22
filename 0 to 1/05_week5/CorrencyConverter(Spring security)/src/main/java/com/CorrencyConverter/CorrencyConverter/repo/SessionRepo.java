package com.CorrencyConverter.CorrencyConverter.repo;

import com.CorrencyConverter.CorrencyConverter.entity.SessionEntity;
import com.CorrencyConverter.CorrencyConverter.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionRepo extends JpaRepository<SessionEntity,Long> {
    // Finds all sessions for a user sorted by creation time (oldest first)
    List<SessionEntity> findAllByUserOrderByCreatedAtAsc(UserEntity user);
}
