package com.example.msrandomnumber.service;

import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class RandomNumberService {

    private final Random random = new Random();

    public int getRandomNumber() {
        return random.nextInt(9) + 1;
    }
}
