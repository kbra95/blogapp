package com.bloggy.blogapp.repository;

import com.bloggy.blogapp.repository.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag,Integer> {

    Optional<Tag> findByTagName(String tagName);
}
