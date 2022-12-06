package com.bloggy.blogapp.repository.entity;

import com.bloggy.blogapp.enums.Tag;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class Post {
    @Id
    private int id;
    private String title;
    private String summary;
    private String postText;
    private Tag tag;
    @CreatedDate
    private OffsetDateTime createdDate;
    @LastModifiedDate
    private OffsetDateTime updatedDate;

}
