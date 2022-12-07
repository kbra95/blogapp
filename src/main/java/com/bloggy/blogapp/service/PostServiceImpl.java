package com.bloggy.blogapp.service;

import com.bloggy.blogapp.controller.dto.PostCreateDTO;
import com.bloggy.blogapp.controller.dto.PostDTO;
import com.bloggy.blogapp.controller.dto.PostUpdateDTO;
import com.bloggy.blogapp.enums.Tag;
import com.bloggy.blogapp.mapper.PostMapper;
import com.bloggy.blogapp.repository.PostRepository;
import com.bloggy.blogapp.repository.entity.Post;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    @Override
    public void createPost(PostCreateDTO postCreateDTO) {
        Post post = postMapper.toPostEntity(postCreateDTO);
        postRepository.save(post);
    }

    @Override
    public PostDTO updatePost(int id, PostUpdateDTO postUpdateDTO) {
        Post post = postRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Blog post is not found with given id : %x", id)));

        if (!Objects.isNull(postUpdateDTO.getPostText())) post.setPostText(postUpdateDTO.getPostText());
        if (!Objects.isNull(postUpdateDTO.getSummary())) post.setSummary(postUpdateDTO.getSummary());
        if (!Objects.isNull(postUpdateDTO.getTitle())) post.setTitle(postUpdateDTO.getTitle());
        if (!Objects.isNull(postUpdateDTO.getTag())) post.setTag(postUpdateDTO.getTag());

        Post updated = postRepository.save(post);
        return postMapper.toPostDTO(updated);
    }

    @Override
    public List<PostDTO> getAllBlogPost() {
        List<Post> postList = postRepository.findAll();
        return postMapper.toPostDTOList(postList);
    }

    @Override
    public List<PostDTO> getAllBlogPostByTag(String tag) {
        List<Post> allByTag = postRepository.findAllByTag(Tag.getByCode(tag));
        return postMapper.toPostDTOList(allByTag);
    }
}
