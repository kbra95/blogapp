package com.bloggy.blogapp.controller.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Builder
public class PostCreateDTO {

    @NotEmpty(message = "Please provide a title")
    private String title;
    @NotEmpty(message = "Please provide a text")
    private String postText;
    @NotEmpty(message = "Please provide a summary")
    private String summary;

    @Builder.Default
    private Set<String> tags = new HashSet<>();
}
