package com.bloggy.blogapp.controller.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

import java.util.Set;

@Getter
public class PostCreateDTO {

    @NotEmpty(message = "Please provide a title")
    private String title;
    @NotEmpty(message = "Please provide a text")
    private String postText;
    @NotEmpty(message = "Please provide a summary")
    private String summary;

    private Set<String> tags;
}
