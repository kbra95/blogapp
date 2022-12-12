package com.bloggy.blogapp.mapper;

import com.bloggy.blogapp.controller.dto.PostCreateDTO;
import com.bloggy.blogapp.controller.dto.PostDTO;
import com.bloggy.blogapp.repository.entity.Post;
import com.bloggy.blogapp.repository.entity.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface PostMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "updatedDate", ignore = true)
    @Mapping(target = "tags", ignore = true)
    Post toPostEntity(PostCreateDTO postCreateDTO);

    List<PostDTO> toPostDTOList(List<Post> posts);

    PostDTO toPostDTO(Post post);

    default Set<String> toStringTags(Set<Tag> tags) {
        return tags.stream().map(Tag::getTagName).collect(Collectors.toSet());
    }
}
