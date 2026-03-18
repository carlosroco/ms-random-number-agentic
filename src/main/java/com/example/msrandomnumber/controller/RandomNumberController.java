package com.example.msrandomnumber.controller;

import com.example.msrandomnumber.service.RandomNumberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Controlador REST para exponer el endpoint de generación de números aleatorios.
 * Base URL: /api
 */
@RestController
@RequestMapping("/api")
public class RandomNumberController {

    private final RandomNumberService randomNumberService;

    /**
     * Constructor con inyección de dependencia del servicio de números aleatorios.
     *
     * @param randomNumberService servicio que proporciona la lógica de generación del número
     */
    public RandomNumberController(RandomNumberService randomNumberService) {
        this.randomNumberService = randomNumberService;
    }

    /**
     * Endpoint GET /api/random-number
     * Retorna un JSON con un número aleatorio entre 1 y 9.
     *
     * @return ResponseEntity con mapa { "number": <valor> }
     */
    @GetMapping("/random-number")
    public ResponseEntity<Map<String, Integer>> getRandomNumber() {
        int number = randomNumberService.getRandomNumber();
        return ResponseEntity.ok(Map.of("number", number));
    }
}
