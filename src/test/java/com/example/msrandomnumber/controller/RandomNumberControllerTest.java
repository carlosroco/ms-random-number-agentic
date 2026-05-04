package com.example.msrandomnumber.controller;

import com.example.msrandomnumber.service.RandomNumberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RandomNumberController.class)
class RandomNumberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // Mock del servicio para aislar la capa de controlador en los tests
    @MockBean
    private RandomNumberService randomNumberService;

    @Test
    void getRandomNumber_retornaHttp200() throws Exception {
        when(randomNumberService.getRandomNumber()).thenReturn(5);

        mockMvc.perform(get("/random"))
                .andExpect(status().isOk());
    }

    @Test
    void getRandomNumber_retornaValorCorrecto() throws Exception {
        when(randomNumberService.getRandomNumber()).thenReturn(7);

        mockMvc.perform(get("/random"))
                .andExpect(status().isOk())
                .andExpect(content().string("7"));
    }

    @Test
    void getRandomNumber_retornaContentTypeJson() throws Exception {
        when(randomNumberService.getRandomNumber()).thenReturn(3);

        mockMvc.perform(get("/random"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}
