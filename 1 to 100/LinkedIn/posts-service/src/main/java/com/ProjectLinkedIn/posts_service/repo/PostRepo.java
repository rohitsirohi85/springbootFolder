package com.ProjectLinkedIn.posts_service.repo;

import com.ProjectLinkedIn.posts_service.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post,Long> {
    List<Post> findByUserId(Long userId);
}
