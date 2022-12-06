package com.bloggy.blogapp.service.model;

import com.bloggy.blogapp.enums.Tag;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.OffsetDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostModel {
    private int id;
    private String title;
    private String summary;
    private String postText;
    private OffsetDateTime createdDate;
    private OffsetDateTime updatedDate;

    private Tag tag;
}
