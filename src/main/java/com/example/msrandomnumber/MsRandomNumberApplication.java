package com.example.msrandomnumber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Punto de entrada principal del microservicio ms-random-number.
 * La anotación @SpringBootApplication habilita auto-configuración,
 * escaneo de componentes y configuración de la aplicación.
 */
@SpringBootApplication
public class MsRandomNumberApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsRandomNumberApplication.class, args);
    }
}
