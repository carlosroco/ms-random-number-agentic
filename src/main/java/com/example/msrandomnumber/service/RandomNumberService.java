package com.example.msrandomnumber.service;

/**
 * Interfaz del servicio de número aleatorio.
 * Define el contrato para obtener un número random entre 1 y 9.
 */
public interface RandomNumberService {

    /**
     * Retorna un número aleatorio entre 1 y 9 (inclusive).
     *
     * @return número entero aleatorio en el rango [1, 9]
     */
    int getRandomNumber();
}
