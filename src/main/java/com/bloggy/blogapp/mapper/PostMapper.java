package com.bloggy.blogapp.mapper;

import com.bloggy.blogapp.controller.dto.PostCreateUpdateDTO;
import com.bloggy.blogapp.controller.dto.PostDTO;
import com.bloggy.blogapp.repository.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "updatedDate", ignore = true)
    Post toPostEntity(PostCreateUpdateDTO postCreateUpdateDTO);

    List<PostDTO> toPostDTOList(List<Post> posts);
}
