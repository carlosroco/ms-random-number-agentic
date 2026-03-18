package com.carlosroco.msrandomnumber.controller;

import com.carlosroco.msrandomnumber.service.RandomNumberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Controlador REST que expone el endpoint de generación de números aleatorios.
 * Gestiona las peticiones HTTP hacia la capa de servicio.
 */
@RestController
@RequestMapping("/api")
public class RandomNumberController {

    /** Servicio inyectado por constructor para obtener el número aleatorio */
    private final RandomNumberService randomNumberService;

    /**
     * Constructor con inyección de dependencia del servicio de números aleatorios.
     *
     * @param randomNumberService servicio que genera el número aleatorio
     */
    public RandomNumberController(RandomNumberService randomNumberService) {
        this.randomNumberService = randomNumberService;
    }

    /**
     * Endpoint GET /api/random — retorna un número aleatorio entre 1 y 9.
     *
     * @return ResponseEntity con JSON { "number": N } y estado HTTP 200
     */
    @GetMapping("/random")
    public ResponseEntity<Map<String, Integer>> getRandom() {
        int number = randomNumberService.getRandomNumber();
        return ResponseEntity.ok(Map.of("number", number));
    }
}
