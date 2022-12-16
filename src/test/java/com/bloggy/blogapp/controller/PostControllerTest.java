package com.bloggy.blogapp.controller;

import com.bloggy.blogapp.controller.dto.PostCreateDTO;
import com.bloggy.blogapp.controller.dto.PostDTO;
import com.bloggy.blogapp.controller.dto.PostUpdateDTO;
import com.bloggy.blogapp.mapper.PostMapper;
import com.bloggy.blogapp.repository.PostRepository;
import com.bloggy.blogapp.repository.TagRepository;
import com.bloggy.blogapp.repository.entity.Post;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@SqlGroup({
        @Sql(value = "classpath:init.sql", executionPhase = BEFORE_TEST_METHOD)
})
public class PostControllerTest {


    @SpyBean
    private PostRepository postRepository;
    @SpyBean
    private TagRepository tagRepository;
    @SpyBean
    private PostMapper postMapper;

    @Autowired
    private MockMvc mvc;
    @Autowired
    private WebApplicationContext context;
    @Autowired
    private ObjectMapper objectMapper;

    private PostCreateDTO postCreateDTO;
    private PostUpdateDTO postUpdateDTO;


    @BeforeEach
    void setUp() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();

        postCreateDTO = PostCreateDTO.builder()
                .title("test")
                .postText("post test")
                .summary("summary test")
                .build();

        postUpdateDTO = PostUpdateDTO.builder()
                .title("updated")
                .build();

    }

    @Test
    @WithMockUser(username="spring")
    void createPost_ShouldCreate_WhenRequestValid() throws Exception {

        mvc.perform(MockMvcRequestBuilders.post("/v1/post")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(postCreateDTO)))
                .andExpect(status().isCreated());
    }

    @Test
    @WithMockUser(username="spring")
    void createPost_ShouldBadRequest_WhenRequestNotValid() throws Exception {

        postCreateDTO = PostCreateDTO.builder()
                .postText("post test")
                .summary("summary test")
                .build();
        mvc.perform(MockMvcRequestBuilders.post("/v1/post")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(postCreateDTO)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Please provide a title"));
    }

    @Test
    @WithMockUser(username="spring")
    void updatePostShouldUpdate() throws Exception {

        Post post = Post.builder()
                .title("Post 1")
                .summary("Post 1 Summary")
                .postText("Lorem ipsum dolor sit amet, " +
                        "consectetur adipiscing elit, sed do" +
                        " eiusmod tempor incididunt ut labore et " +
                        "dolore magna aliqua. Ut enim ad minim veniam. ")
                .build();
        PostDTO expected = postMapper.toPostDTO(post);
        expected.setTitle(postUpdateDTO.getTitle());

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put("/v1/post/{id}", 100)
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(postUpdateDTO))).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        PostDTO actual = objectMapper.readValue(content, PostDTO.class);

        assertEquals(expected.getPostText(), actual.getPostText());
        assertEquals(expected.getTitle(), actual.getTitle());
        assertEquals(expected.getSummary(), actual.getSummary());
    }

    @Test
    @WithMockUser(username="spring")
    void getAllBlogPostTest() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/v1/post")
                .contentType(APPLICATION_JSON)).andReturn();
        List<PostDTO> response = objectMapper.readValue(mvcResult.getResponse().getContentAsByteArray(), new TypeReference<>() {
        });

        assertFalse(response.isEmpty());
        assertEquals(2, response.size());
    }

    @Test
    @WithMockUser(username="spring")
    void getPostsByTagTest() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/v1/post")
                .param("tag", "Test Tag t")
                .contentType(APPLICATION_JSON)).andReturn();
        List<PostDTO> response = objectMapper.readValue(mvcResult.getResponse().getContentAsByteArray(), new TypeReference<>() {
        });

        assertFalse(response.isEmpty());
        assertEquals(2, response.size());
    }

    @AfterEach
    void tearDown() {
        postRepository.deleteAll();
        tagRepository.deleteAll();
    }
}
