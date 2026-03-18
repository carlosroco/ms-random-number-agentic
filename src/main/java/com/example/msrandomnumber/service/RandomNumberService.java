package com.example.msrandomnumber.service;

/**
 * Interfaz del servicio para generación de números aleatorios.
 */
public interface RandomNumberService {

    /**
     * Retorna un número aleatorio entre 1 y 9 (inclusive).
     *
     * @return número aleatorio entero
     */
    int getRandomNumber();
}
