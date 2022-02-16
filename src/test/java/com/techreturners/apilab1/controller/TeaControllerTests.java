package com.techreturners.apilab1.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@SpringBootTest
public class TeaControllerTests {

    @Autowired
    private MockMvc mockMvcController;

    @Test
    public void testGetTeaLover() throws Exception {
        String expectedContent = "I love Tea..!!";

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/tealover"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }


    @Test
    public void testTeaWithoutRequestParams() throws Exception {
        String expectedTeaType = "Oolang";

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/tea"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(expectedTeaType));
    }

    @Test
    public void testTeaWithRequestParams() throws Exception {
        String expectedTeaType = "PeachIce";

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/tea").param("name", "PeachIce"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(expectedTeaType));
    }

}


