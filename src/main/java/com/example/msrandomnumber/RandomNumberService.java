package com.example.msrandomnumber;

import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Servicio que genera números aleatorios en el rango del 1 al 9.
 */
@Service
public class RandomNumberService {

    /**
     * Retorna un número entero aleatorio entre 1 y 9 (ambos inclusive).
     *
     * @return número aleatorio del 1 al 9
     */
    public int getRandomNumber() {
        return ThreadLocalRandom.current().nextInt(1, 10);
    }
}
