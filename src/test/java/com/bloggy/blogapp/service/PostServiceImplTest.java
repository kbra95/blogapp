package com.bloggy.blogapp.service;

import com.bloggy.blogapp.controller.dto.PostCreateDTO;
import com.bloggy.blogapp.controller.dto.PostDTO;
import com.bloggy.blogapp.controller.dto.PostUpdateDTO;
import com.bloggy.blogapp.mapper.PostMapper;
import com.bloggy.blogapp.repository.PostRepository;
import com.bloggy.blogapp.repository.TagRepository;
import com.bloggy.blogapp.repository.entity.Post;
import com.bloggy.blogapp.repository.entity.Tag;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class PostServiceImplTest {

    @Mock
    TagRepository tagRepository;
    @InjectMocks
    private PostServiceImpl postService;
    @Mock
    private PostRepository postRepository;

    @Mock
    private PostMapper postMapper;

    private PostCreateDTO postCreateDTO;
    private PostUpdateDTO postUpdateDTO;
    private Post post;
    private PostDTO postDTO;


    @Captor
    private ArgumentCaptor<Post> postArgumentCaptor;


    @BeforeEach
    void setUp() {
        postCreateDTO = PostCreateDTO.builder()
                .title("test")
                .postText("post test")
                .summary("summary test")
                .tags(Set.of("tag1"))
                .build();

        postUpdateDTO = PostUpdateDTO.builder()
                .title("updated")
                .build();

        post = Post.builder()
                .title(postCreateDTO.getTitle())
                .postText(postCreateDTO.getPostText())
                .summary(postCreateDTO.getSummary())
                .tags(Set.of(Tag.builder().tagName("tag1").build()))
                .build();

        postDTO = PostDTO.builder().title(post.getTitle())
                .postText(post.getPostText())
                .summary(post.getSummary())
                .build();
    }

    @Test
    void createPostTest() {
        when(postMapper.toPostEntity(any())).thenReturn(post);
        postService.createPost(postCreateDTO);

        verify(postRepository).save(postArgumentCaptor.capture());
        Post actualPost = postArgumentCaptor.getValue();
        assertEquals(post.getTitle(), actualPost.getTitle());
        assertEquals(post.getSummary(), actualPost.getSummary());
        assertEquals(post.getPostText(), actualPost.getPostText());
    }

    @Test
    void updatePostTest() {
        postDTO.setTitle(postUpdateDTO.getTitle());
        when(postRepository.findById(any())).thenReturn(Optional.of(post));
        when(postMapper.toPostDTO(any())).thenReturn(postDTO);

        postService.updatePost(1, postUpdateDTO);

        verify(postRepository).save(postArgumentCaptor.capture());
        Post actualPost = postArgumentCaptor.getValue();
        assertEquals(postUpdateDTO.getTitle(), actualPost.getTitle());
        assertEquals(post.getSummary(), actualPost.getSummary());
        assertEquals(post.getPostText(), actualPost.getPostText());
    }

    @Test
    void updatePostTest_WhenPostNotFound() {
        when(postRepository.findById(any())).thenReturn(Optional.empty());

        Throwable throwable = catchThrowable(() -> postService.updatePost(333, postUpdateDTO));

        assertTrue(throwable instanceof EntityNotFoundException);
        EntityNotFoundException exception = (EntityNotFoundException) throwable;
        assertEquals("Blog post is not found with given id : 333", exception.getMessage());
    }

    @Test
    void getAllBlogPostTest(){
        when(postMapper.toPostDTOList(anyList())).thenReturn(List.of(postDTO));

        List<PostDTO> actual = postService.getAllBlogPost();

        assertEquals(1,actual.size());
        assertEquals(postDTO.getTitle(),actual.get(0).getTitle());
    }

}
