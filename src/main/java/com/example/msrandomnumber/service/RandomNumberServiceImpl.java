package com.example.msrandomnumber.service;

import org.springframework.stereotype.Service;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class RandomNumberServiceImpl implements RandomNumberService {

    @Override
    public int getRandomNumber() {
        // Genera un número aleatorio entre 1 y 9 (ambos inclusive)
        return ThreadLocalRandom.current().nextInt(1, 10);
    }
}
