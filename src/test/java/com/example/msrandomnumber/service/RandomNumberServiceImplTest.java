package com.example.msrandomnumber.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomNumberServiceImplTest {

    private RandomNumberServiceImpl service;

    @BeforeEach
    void setUp() {
        service = new RandomNumberServiceImpl();
    }

    @Test
    void getRandomNumber_siempreRetornaValorEnRango() {
        // Verifica 100 veces que el valor siempre está entre 1 y 9 inclusive
        for (int i = 0; i < 100; i++) {
            int result = service.getRandomNumber();
            assertTrue(result >= 1, "El número debe ser mayor o igual a 1, pero fue: " + result);
            assertTrue(result <= 9, "El número debe ser menor o igual a 9, pero fue: " + result);
        }
    }

    @Test
    void getRandomNumber_retornaEnteroPositivo() {
        int result = service.getRandomNumber();
        assertTrue(result > 0, "El número debe ser positivo");
    }
}
