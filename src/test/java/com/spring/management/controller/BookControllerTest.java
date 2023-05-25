package com.spring.management.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.management.model.Books;
import com.spring.management.repository.BookRepo;
import com.spring.management.service.BookServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookControllerTest {

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;

    @Autowired
    private BookController bookController;

    @Mock
    private BookRepo bookRepo;

    @Mock
    private BookServiceImpl bookService;

    ObjectMapper om=new ObjectMapper();

    @BeforeEach
    void setUp() {
        this.bookController=new BookController(this.bookService);
        mockMvc= MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    void addTest() throws Exception {
        Books b=new Books("John","rings");
        String jsonRequest=om.writeValueAsString(b);

        MvcResult result=mockMvc.perform(post("/user/add").content(jsonRequest).content(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
    }

    @Test
    void get() {
    }

    @Test
    void updateData() {
    }

    @Test
    void deleteData() {
    }
}