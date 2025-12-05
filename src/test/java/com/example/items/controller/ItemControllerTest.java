package com.example.items.controller;

import com.example.items.ItemsApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = ItemsApplication.class)
@AutoConfigureMockMvc
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createItem_returns201AndBody() throws Exception {
        String json = """
            {
              "name": "Test Item",
              "description": "A test description"
            }
            """;

        mockMvc.perform(post("/api/items")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", not(isEmptyString())))
                .andExpect(jsonPath("$.name", is("Test Item")))
                .andExpect(jsonPath("$.description", is("A test description")))
                .andExpect(jsonPath("$.createdAt", not(isEmptyString())));
    }
}