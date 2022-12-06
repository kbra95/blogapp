package com.bloggy.blogapp.controller.dto;

import com.bloggy.blogapp.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<Void> createPost(@RequestBody PostCreateUpdateDTO postCreateUpdateDTO) {
        postService.createPost(postCreateUpdateDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public  ResponseEntity<List<PostDTO>> getAllBlogPost(){
        return new ResponseEntity<>(postService.getAllBlogPost(),HttpStatus.OK);
    }
}
