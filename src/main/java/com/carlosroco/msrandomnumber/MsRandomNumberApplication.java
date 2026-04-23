package com.carlosroco.msrandomnumber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal del microservicio ms-random-number.
 * Punto de entrada de la aplicación Spring Boot.
 */
@SpringBootApplication
public class MsRandomNumberApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsRandomNumberApplication.class, args);
    }
}
