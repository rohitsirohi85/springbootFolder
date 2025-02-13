package com.ProjectLinkedIn.posts_service.service;

import com.ProjectLinkedIn.posts_service.auth.UserContextHolder;
import com.ProjectLinkedIn.posts_service.clients.ConnectionsClient;
import com.ProjectLinkedIn.posts_service.dto.PersonDto;
import com.ProjectLinkedIn.posts_service.dto.PostCreateRequestDto;
import com.ProjectLinkedIn.posts_service.dto.PostDto;
import com.ProjectLinkedIn.posts_service.entity.Post;
import com.ProjectLinkedIn.posts_service.exception.ResourceNotFoundException;
import com.ProjectLinkedIn.posts_service.repo.PostRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostService {

    private final PostRepo postRepo;
    private final ModelMapper modelMapper;
    private final ConnectionsClient connectionsClient;

    public PostDto createPost(PostCreateRequestDto postCreateRequestDto , Long userId) {
        Post post = modelMapper.map(postCreateRequestDto,Post.class);
        post.setUserId(userId);

        Post savedPost = postRepo.save(post);
        return modelMapper.map(savedPost,PostDto.class);
    }

    public PostDto getPostById(Long postId) {
        log.debug("Retrieving post with id : {}",postId);

        Long userId= UserContextHolder.getCurrentUserId();

        List<PersonDto> firstDegreeConnections=connectionsClient.getFirstConnections();

        // TODO:send notifications to all connections
        Post post =  postRepo.findById(postId)
                .orElseThrow(()-> new ResourceNotFoundException("post not found with id : "+postId));
        return modelMapper.map(post, PostDto.class);
    }

    public List<PostDto> getAllPosts(Long userId) {
             List<Post> posts = postRepo.findByUserId(userId);

       return posts
                .stream().map((element) -> modelMapper.map(element, PostDto.class))
                .collect(Collectors.toList());
    }
}
