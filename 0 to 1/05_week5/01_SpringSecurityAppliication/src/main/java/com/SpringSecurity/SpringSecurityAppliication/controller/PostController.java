package com.SpringSecurity.SpringSecurityAppliication.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringSecurity.SpringSecurityAppliication.dto.PostDto;
import com.SpringSecurity.SpringSecurityAppliication.services.PostService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;


       // now if you go to the api link it will ask for login first
       // http://localhost:8080/posts
       // name and password can define in application.properties


    @GetMapping
    public List<PostDto> getAllPosts() {
        return postService.getAllPosts();
    }

    @PostMapping
    public PostDto createNewPost(@RequestBody PostDto inputPost) {
        return postService.createNewPost(inputPost);
    }

    @GetMapping(path = "/{postId}")
    public PostDto getPostById(@PathVariable Long postId) {
        return postService.getPostById(postId);
    }

    @PutMapping(path = "/{postId}")
    public PostDto updatePost(@RequestBody PostDto inputPost, @PathVariable Long postId) {
        return postService.updatePost(inputPost, postId);
    }
}
