package com.ProjectLinkedIn.posts_service.service;

import com.ProjectLinkedIn.posts_service.entity.PostLike;
import com.ProjectLinkedIn.posts_service.exception.BadRequestException;
import com.ProjectLinkedIn.posts_service.repo.PostLikeRepo;
import com.ProjectLinkedIn.posts_service.repo.PostRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostLikeService {

    private final PostLikeRepo postLikeRepo;
    private final PostRepo postRepo;

    public void likePost(Long postId , Long userId){

        log.info("Attempting to like a post with id : {}",postId);

        boolean exist = postRepo.existsById(postId);
        if (!exist){
            throw new ResolutionException("post not found with id : "+postId);
        }

        boolean alreadyLiked = postLikeRepo.existsByUserIdAndPostId(userId,postId);
        if (alreadyLiked)throw new BadRequestException("cannot like a post again");


        PostLike postLike = new PostLike();
        postLike.setPostId(postId);
        postLike.setUserId(userId);
        postLikeRepo.save(postLike);
        log.info("post liked successfully with id : {}",postId);
    }

    public void unlikePost(Long postId, long userId) {
        log.info("Attempting to unlike a post with id : {}",postId);

        boolean exist = postRepo.existsById(postId);
        if (!exist){
            throw new ResolutionException("post not found with id : "+postId);
        }

        boolean alreadyLiked = postLikeRepo.existsByUserIdAndPostId(userId,postId);
        if (!alreadyLiked)throw new BadRequestException("cannot unlike a post , bcz it is not liked");


        postLikeRepo.deleteByUserIdAndPostId(userId,postId);
        log.info("post unliked successfully with id : {}",postId);
    }
}
