package com.ProjectLinkedIn.posts_service.repo;

import com.ProjectLinkedIn.posts_service.entity.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PostLikeRepo extends JpaRepository<PostLike,Long> {
          boolean existsByUserIdAndPostId(Long userId , Long postId);

          @Transactional
    void deleteByUserIdAndPostId(long userId, Long postId);
}
