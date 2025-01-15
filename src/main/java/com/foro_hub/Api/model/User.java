package com.foro_hub.Api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Anotación para generar métodos getters
@Getter
// Anotación para generar métodos setters
@Setter
// Anotación para generar un constructor sin argumentos
@NoArgsConstructor
// Anotación para generar un constructor con todos los argumentos
@AllArgsConstructor
// Anotación para marcar esta clase como una entidad JPA
@Entity
// Anotación para especificar la tabla asociada con la entidad
@Table(name = "users")
public class User {

    // Anotación para marcar el campo como clave primaria
    @Id
    // Anotación para especificar la estrategia de generación del valor del campo
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Anotación para especificar que la columna no puede ser nula y debe ser única
    @Column(nullable = false, unique = true)
    private String username;

    // Anotación para especificar que la columna no puede ser nula
    @Column(nullable = false)
    private String password;
}
