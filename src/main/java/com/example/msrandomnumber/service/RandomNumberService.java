package com.example.msrandomnumber.service;

import org.springframework.stereotype.Service;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class RandomNumberService {

    /**
     * Returns a random number between 1 and 9 (inclusive).
     * Uses ThreadLocalRandom for better performance and safety in concurrent environments.
     */
    public int getRandomNumber() {
        return ThreadLocalRandom.current().nextInt(1, 10);
    }
}
