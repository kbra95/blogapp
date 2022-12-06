package com.bloggy.blogapp.service;

import com.bloggy.blogapp.controller.dto.PostCreateUpdateDTO;
import com.bloggy.blogapp.controller.dto.PostDTO;
import com.bloggy.blogapp.service.model.PostModel;
import org.springframework.data.annotation.CreatedDate;

import java.util.List;

public interface PostService {

    void createPost(PostCreateUpdateDTO postCreateUpdateDTO);

    List<PostDTO> getAllBlogPost();

}
