package com.bloggy.blogapp.service;

import com.bloggy.blogapp.controller.dto.PostCreateDTO;
import com.bloggy.blogapp.controller.dto.PostDTO;
import com.bloggy.blogapp.controller.dto.PostUpdateDTO;
import com.bloggy.blogapp.controller.dto.UpdateTagRequest;
import com.bloggy.blogapp.mapper.PostMapper;
import com.bloggy.blogapp.repository.PostRepository;
import com.bloggy.blogapp.repository.TagRepository;
import com.bloggy.blogapp.repository.entity.Post;
import com.bloggy.blogapp.repository.entity.Tag;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static com.bloggy.blogapp.controller.dto.UpdateTagRequest.*;

@Service
@Transactional
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final TagRepository tagRepository;
    private final PostMapper postMapper;

    @Override
    public void createPost(PostCreateDTO postCreateDTO) {
        Post post = postMapper.toPostEntity(postCreateDTO);
        Set<Tag> tagSet = new HashSet<>();
        postCreateDTO.getTags().forEach(tagName -> {
            tagRepository.findByTagName(tagName).ifPresentOrElse(tagSet::add, () -> {
                Tag tag = Tag.builder().tagName(tagName).build();
                tagSet.add(tag);
            });

        });
        post.setTags(tagSet);
        postRepository.save(post);
    }

    @Override
    public PostDTO updatePost(int id, PostUpdateDTO postUpdateDTO) {
        Post post = getPostById(id);

        if (!Objects.isNull(postUpdateDTO.getPostText())) post.setPostText(postUpdateDTO.getPostText());
        if (!Objects.isNull(postUpdateDTO.getSummary())) post.setSummary(postUpdateDTO.getSummary());
        if (!Objects.isNull(postUpdateDTO.getTitle())) post.setTitle(postUpdateDTO.getTitle());

        Post updated = postRepository.save(post);
        return postMapper.toPostDTO(updated);
    }

    private Post getPostById(int id) {
        return postRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Blog post is not found with given id : %d", id)));
    }

    @Override
    public PostDTO updatePostTag(int id, UpdateTagRequest updateRequest) {
        Post postById = getPostById(id);
        if (updateRequest.getOperation().equals(Operation.ADD)) {

            tagRepository.findByTagName(updateRequest.getTagName()).ifPresentOrElse(postById::addTag,
                    () -> postById.addTag(Tag.builder().tagName(updateRequest.getTagName()).build()));

        } else if (updateRequest.getOperation().equals(Operation.REMOVE)) {
            postById.getTags()
                    .stream()
                    .filter(tag -> tag.getTagName().equals(updateRequest.getTagName()))
                    .findFirst()
                    .ifPresent(postById::removeTag);
        }

        Post updated = postRepository.save(postById);
        return postMapper.toPostDTO(updated);
    }

    @Override
    public List<PostDTO> getAllBlogPost() {
        List<Post> postList = postRepository.findAll();
        return postMapper.toPostDTOList(postList);
    }

    @Override
    public List<PostDTO> getAllBlogPostByTag(String tag) {
        List<Post> allByTag = postRepository.findAllByTags_TagName(tag);
        return postMapper.toPostDTOList(allByTag);
    }
}
