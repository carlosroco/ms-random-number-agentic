package com.carlosroco.msrandomnumber.service;

/**
 * Interfaz del servicio para la generación de números aleatorios.
 * Define el contrato que debe cumplir cualquier implementación.
 */
public interface RandomNumberService {

    /**
     * Retorna un número aleatorio entre 1 y 9 inclusive.
     *
     * @return número entero aleatorio en el rango [1, 9]
     */
    int getRandomNumber();
}
