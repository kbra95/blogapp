package com.bloggy.blogapp.controller.dto;

import com.bloggy.blogapp.enums.Tag;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    private int id;
    private String title;
    private String summary;
    private String postText;
    private Date createdDate;
    private Date updatedDate;
    private Tag tag;
}
