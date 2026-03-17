package com.example.msrandomnumber.controller;

import com.example.msrandomnumber.service.RandomNumberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RandomNumberController.class)
class RandomNumberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RandomNumberService randomNumberService;

    @Test
    void getRandomNumber_shouldReturn200WithNumber() throws Exception {
        when(randomNumberService.getRandomNumber()).thenReturn(5);

        mockMvc.perform(get("/api/random-number"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.number").value(5));
    }
}
