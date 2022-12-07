package com.bloggy.blogapp.controller.dto;

import com.bloggy.blogapp.enums.Tag;
import lombok.Getter;

import java.util.List;

@Getter
public class PostUpdateDTO {
    private String title;
    private String postText;
    private String summary;

    private List<String> tag;
}
