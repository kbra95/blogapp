package com.bloggy.blogapp.service;

import com.bloggy.blogapp.controller.dto.PostCreateDTO;
import com.bloggy.blogapp.controller.dto.PostDTO;
import com.bloggy.blogapp.controller.dto.PostUpdateDTO;

import java.util.List;

public interface PostService {

    void createPost(PostCreateDTO postCreateDTO);

    PostDTO updatePost(int id, PostUpdateDTO postUpdateDTO);

    List<PostDTO> getAllBlogPost();

    List<PostDTO> getAllBlogPostByTag(String tag);

}
