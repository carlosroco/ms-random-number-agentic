package com.example.msrandomnumber.controller;

import com.example.msrandomnumber.service.RandomNumberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Controlador REST para el microservicio de número aleatorio.
 * Expone el endpoint GET /api/random que retorna un número random del 1 al 9.
 */
@RestController
@RequestMapping("/api")
public class RandomNumberController {

    private final RandomNumberService randomNumberService;

    /**
     * Constructor con inyección de dependencia del servicio.
     *
     * @param randomNumberService servicio que genera el número aleatorio
     */
    public RandomNumberController(RandomNumberService randomNumberService) {
        this.randomNumberService = randomNumberService;
    }

    /**
     * Endpoint GET que retorna un número aleatorio entre 1 y 9.
     *
     * @return ResponseEntity con JSON {"number": <valor>} y estado HTTP 200
     */
    @GetMapping("/random")
    public ResponseEntity<Map<String, Integer>> getRandom() {
        int number = randomNumberService.getRandomNumber();
        return ResponseEntity.ok(Map.of("number", number));
    }
}
