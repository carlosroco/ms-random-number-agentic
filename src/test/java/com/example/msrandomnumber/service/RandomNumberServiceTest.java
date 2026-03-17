package com.example.msrandomnumber.service;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberServiceTest {

    private final RandomNumberService randomNumberService = new RandomNumberService();

    @Test
    void getRandomNumber_shouldReturnNumberInRange1To9Inclusive() {
        for (int i = 0; i < 100; i++) {
            int result = randomNumberService.getRandomNumber();
            // Validates that the number is in the closed range [1, 9]
            assertThat(result).isBetween(1, 9);
        }
    }
}
