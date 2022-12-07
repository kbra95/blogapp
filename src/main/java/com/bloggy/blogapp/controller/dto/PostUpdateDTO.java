package com.bloggy.blogapp.controller.dto;

import com.bloggy.blogapp.enums.Tag;
import lombok.Getter;

@Getter
public class PostUpdateDTO {
    private String title;
    private String postText;
    private String summary;

    private Tag tag;
}
