// 1. Primero, usa el PasswordGenerator para crear una contraseña encriptada:
package com.foro_hub.Api.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        // Supongamos que quieres usar "admin123" como contraseña
        String rawPassword = "admin123";
        // Codifica (encripta) la contraseña usando BCryptPasswordEncoder
        String encodedPassword = encoder.encode(rawPassword);
        // Imprime la contraseña encriptada para almacenarla en la base de datos
        System.out.println("Password to store in database: " + encodedPassword);
        // Imprime la contraseña encriptada para usarla en el siguiente paso
    }
}
