package com.sumanth.colorapp.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ColorController.class)
class ColorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetColors() throws Exception {
        mockMvc.perform(get("/api/colors"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").value("red"))
                .andExpect(jsonPath("$[1]").value("green"))
                .andExpect(jsonPath("$[2]").value("blue"))
                .andExpect(jsonPath("$[3]").value("yellow"));
    }

    @Test
    void testHealthCheck() throws Exception {
        mockMvc.perform(get("/api/health-check"))
                .andExpect(status().isOk())
                .andExpect(content().string("Application is running!"));
    }
}