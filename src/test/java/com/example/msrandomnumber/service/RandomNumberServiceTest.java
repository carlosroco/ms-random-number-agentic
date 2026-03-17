package com.example.msrandomnumber.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class RandomNumberServiceTest {

    private final RandomNumberService service = new RandomNumberServiceImpl();

    @Test
    void getRandomNumber_shouldReturnValueBetween1And9() {
        for (int i = 0; i < 100; i++) {
            int result = service.getRandomNumber();
            assertTrue(result >= 1 && result <= 9,
                "El número debe estar entre 1 y 9 (inclusive), pero fue: " + result);
        }
    }
}
