package com.example.msrandomnumber.service;

import org.springframework.stereotype.Service;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class RandomNumberService {

    /**
     * Retorna un número aleatorio entre 1 y 9 (inclusive).
     * Usa ThreadLocalRandom para mayor rendimiento y seguridad en entornos concurrentes.
     */
    public int getRandomNumber() {
        return ThreadLocalRandom.current().nextInt(1, 10);
    }
}
