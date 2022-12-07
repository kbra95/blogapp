package com.bloggy.blogapp.controller.dto;

import com.bloggy.blogapp.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<Void> createPost(@Valid @RequestBody PostCreateDTO postCreateDTO) {
        postService.createPost(postCreateDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostDTO> updatePost(@PathVariable int id, @RequestBody PostUpdateDTO postUpdateDTO) {
        PostDTO updatedPost = postService.updatePost(id, postUpdateDTO);
        return new ResponseEntity<>(updatedPost, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PostDTO>> getAllBlogPost() {
        return new ResponseEntity<>(postService.getAllBlogPost(), HttpStatus.OK);
    }

    @GetMapping("/byTag")
    public ResponseEntity<List<PostDTO>> getPostsByTag(@RequestParam String tag) {
        return new ResponseEntity<>(postService.getAllBlogPostByTag(tag), HttpStatus.OK);
    }
}
