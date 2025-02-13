package com.ProjectLinkedIn.posts_service.controller;

import com.ProjectLinkedIn.posts_service.auth.UserContextHolder;
import com.ProjectLinkedIn.posts_service.dto.PostCreateRequestDto;
import com.ProjectLinkedIn.posts_service.dto.PostDto;
import com.ProjectLinkedIn.posts_service.entity.Post;
import com.ProjectLinkedIn.posts_service.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/core")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostCreateRequestDto postCreateRequestDto , HttpServletRequest httpServletRequest){
        PostDto createdPost = postService.createPost(postCreateRequestDto,1L);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDto> getPost(@PathVariable Long postId){

        PostDto postDto = postService.getPostById(postId);
        return ResponseEntity.ok(postDto);
    }

    @GetMapping("/users/{userId}/allPosts")
    public ResponseEntity<List<PostDto>> getAllPosts(@PathVariable Long userId){
        List<PostDto> postDto = postService.getAllPosts(userId);
        return ResponseEntity.ok(postDto);
    }

}
