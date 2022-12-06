package com.bloggy.blogapp.controller.dto;

import com.bloggy.blogapp.enums.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    private int id;
    private String title;
    private String summary;
    private String postText;
    private OffsetDateTime createdDate;
    private OffsetDateTime updatedDate;
    private Tag tag;
}
