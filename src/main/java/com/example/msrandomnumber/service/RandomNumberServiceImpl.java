package com.example.msrandomnumber.service;

import org.springframework.stereotype.Service;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class RandomNumberServiceImpl implements RandomNumberService {

    @Override
    public int getRandomNumber() {
        return ThreadLocalRandom.current().nextInt(1, 10);
    }
}
