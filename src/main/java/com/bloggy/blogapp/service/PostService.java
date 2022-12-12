package com.bloggy.blogapp.service;

import com.bloggy.blogapp.controller.dto.PostCreateDTO;
import com.bloggy.blogapp.controller.dto.PostDTO;
import com.bloggy.blogapp.controller.dto.PostUpdateDTO;
import com.bloggy.blogapp.controller.dto.UpdateTagRequest;

import java.util.List;

public interface PostService {

    void createPost(PostCreateDTO postCreateDTO);

    PostDTO updatePost(int id, PostUpdateDTO postUpdateDTO);

    PostDTO updatePostTag(int id, UpdateTagRequest tagRequest);

    List<PostDTO> getAllBlogPost();

    List<PostDTO> getAllBlogPostByTag(String tag);

}
