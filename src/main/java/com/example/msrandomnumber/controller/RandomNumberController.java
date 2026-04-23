package com.example.msrandomnumber.controller;

import com.example.msrandomnumber.service.RandomNumberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Controlador REST que expone el endpoint para obtener un número aleatorio.
 * Delega la lógica de generación al servicio RandomNumberService,
 * siguiendo el principio de separación de responsabilidades.
 */
@RestController
@RequestMapping("/random")
public class RandomNumberController {

    private final RandomNumberService randomNumberService;

    /**
     * Inyección de dependencias por constructor (práctica recomendada en Spring).
     *
     * @param randomNumberService servicio que provee el número aleatorio
     */
    public RandomNumberController(RandomNumberService randomNumberService) {
        this.randomNumberService = randomNumberService;
    }

    /**
     * Endpoint GET /random.
     * Retorna un JSON con la clave "number" y un valor entre 1 y 9 (inclusive).
     * Ejemplo de respuesta: {"number": 5}
     *
     * @return ResponseEntity con status 200 OK y cuerpo JSON {"number": N}
     */
    @GetMapping
    public ResponseEntity<Map<String, Integer>> getRandomNumber() {
        int numero = randomNumberService.getRandomNumber();
        return ResponseEntity.ok(Map.of("number", numero));
    }
}
