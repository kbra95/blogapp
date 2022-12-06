package com.bloggy.blogapp.repository.entity;

import com.bloggy.blogapp.enums.Tag;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@ToString
@EntityListeners(AuditingEntityListener.class)
public class Post {
    @Id
    private int id;
    private String title;
    private String summary;
    private String postText;
    private Tag tag;
    @CreatedDate
    private Date createdDate;
    @LastModifiedDate
    private Date updatedDate;

}
