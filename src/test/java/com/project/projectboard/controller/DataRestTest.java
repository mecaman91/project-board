package com.project.projectboard.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

@Disabled("Spring Data REST 통합테스트는 불필요하므로 제외시킴")
@DisplayName("Data REST - API 테스트")
@Transactional
@AutoConfigureMockMvc
@SpringBootTest
public class DataRestTest {

    private final MockMvc mvc;

    public DataRestTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[api] 게시글 리스트 조회")
    @Test
    void givenNothing_whenRequsetingArticles_thenReturnsArticlesJsonResponse() throws Exception {

        //Given

        //When & Then
        mvc.perform(MockMvcRequestBuilders.get("/api/articles"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.valueOf("application/hal+json")));
    }

    @DisplayName("[api] 게시글 단건 조회")
    @Test
    void givenNothing_whenRequsetingArticles_thenReturnsArticleJsonResponse() throws Exception {

        //Given

        //When & Then
        mvc.perform(MockMvcRequestBuilders.get("/api/article/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.valueOf("application/hal+json")));
    }

    @DisplayName("[api] 게시글-> 댓글 리스트 조회")
    @Test
    void givenNothing_whenRequsetingArticleCommentsFromArticle_thenReturnsArticleCommentsJsonResponse() throws Exception {

        //Given

        //When & Then
        mvc.perform(MockMvcRequestBuilders.get("/api/article/1/articleComments"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.valueOf("application/hal+json")));
    }

    @DisplayName("[api] 댓글 리스트 조회")
    @Test
    void givenNothing_whenRequsetingArticleComments_thenReturnsArticleCommentsJsonResponse() throws Exception {

        //Given

        //When & Then
        mvc.perform(MockMvcRequestBuilders.get("/api/articleComments"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.valueOf("application/hal+json")));
    }

    @DisplayName("[api] 댓글 단건 조회")
    @Test
    void givenNothing_whenRequsetingArticleComment_thenReturnsArticleCommentJsonResponse() throws Exception {

        //Given

        //When & Then
        mvc.perform(MockMvcRequestBuilders.get("/api/articleComments/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.valueOf("application/hal+json")));
    }
}
