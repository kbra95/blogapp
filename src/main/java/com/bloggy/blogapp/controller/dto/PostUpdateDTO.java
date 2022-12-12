package com.bloggy.blogapp.controller.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostUpdateDTO {
    private String title;
    private String postText;
    private String summary;

}
