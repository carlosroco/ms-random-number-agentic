package com.example.msrandomnumber.model;

/**
 * DTO de respuesta para el endpoint GET /api/random
 * Ejemplo de respuesta JSON: { "number": 7 }
 */
public record RandomNumberResponse(int number) {}
