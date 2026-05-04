package com.example.msrandomnumber.service.impl;

import com.example.msrandomnumber.service.RandomNumberService;
import org.springframework.stereotype.Service;
import java.util.random.RandomGenerator;

@Service
public class RandomNumberServiceImpl implements RandomNumberService {

    private final RandomGenerator randomGenerator;

    public RandomNumberServiceImpl(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    @Override
    public int getRandomNumber() {
        // nextInt(9) genera [0, 9), sumando 1 obtenemos [1, 9]
        return randomGenerator.nextInt(9) + 1;
    }
}
