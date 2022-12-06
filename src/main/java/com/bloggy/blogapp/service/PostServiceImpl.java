package com.bloggy.blogapp.service;

import com.bloggy.blogapp.controller.dto.PostCreateUpdateDTO;
import com.bloggy.blogapp.controller.dto.PostDTO;
import com.bloggy.blogapp.mapper.PostMapper;
import com.bloggy.blogapp.repository.PostRepository;
import com.bloggy.blogapp.repository.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
`
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    @Override
    public void createPost(PostCreateUpdateDTO postCreateUpdateDTO) {
        Post post = postMapper.toPostEntity(postCreateUpdateDTO);
        postRepository.save(post);
    }

    @Override
    public List<PostDTO> getAllBlogPost() {
        List<Post> postList = postRepository.findAll();
        return postMapper.toPostDTOList(postList);
    }
}
