package com.bloggy.blogapp.controller.dto;

import com.bloggy.blogapp.enums.Tag;
import lombok.Getter;

@Getter
public class PostCreateUpdateDTO {

    private String title;
    private String text;
    private String summary;

    private Tag tag;
}
