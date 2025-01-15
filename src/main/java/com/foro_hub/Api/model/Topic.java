package com.foro_hub.Api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

// Anotación para marcar esta clase como una entidad JPA
@Entity
// Anotación para especificar la tabla asociada con la entidad
@Table(name = "topics")
// Anotación para generar métodos getters y setters, equals, hash, y toString
@Data
// Anotación para generar un constructor sin argumentos
@NoArgsConstructor
// Anotación para generar un constructor con todos los argumentos
@AllArgsConstructor
public class Topic {

    // Anotación para marcar el campo como clave primaria
    @Id
    // Anotación para especificar la estrategia de generación del valor del campo
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Anotación para especificar que la columna no puede ser nula
    @Column(nullable = false)
    private String title;

    // Anotación para especificar que la columna no puede ser nula
    @Column(nullable = false)
    private String message;

    // Campo para almacenar la fecha de creación del tópico, inicializado con la fecha y hora actual
    private LocalDateTime creationDate = LocalDateTime.now();

    // Anotación para especificar que el campo es una enumeración y se almacenará como una cadena en la base de datos
    @Enumerated(EnumType.STRING)
    private TopicStatus status = TopicStatus.NOT_RESPONDED;

    // Anotación para especificar que la columna no puede ser nula
    @Column(nullable = false)
    private String author;

    // Anotación para especificar que la columna no puede ser nula
    @Column(nullable = false)
    private String course;
}
