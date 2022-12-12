package com.bloggy.blogapp.controller.dto;

import lombok.*;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    private int id;
    private String title;
    private String summary;
    private String postText;
    private Date createdDate;
    private Date updatedDate;
    private Set<String> tags;
}
