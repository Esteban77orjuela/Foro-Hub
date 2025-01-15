package com.foro_hub.Api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// Anotación para generar métodos getters y setters, equals, hash, y toString
@Data
// Anotación para generar un constructor sin argumentos
@NoArgsConstructor
// Anotación para generar un constructor con todos los argumentos
@AllArgsConstructor
public class TopicDTO {

    private Long id; // Identificador único del tópico
    private String title; // Título del tópico
    private String message; // Mensaje del tópico
    private LocalDateTime creationDate; // Fecha de creación del tópico
    private String status; // Estado del tópico (abierto, cerrado, etc.)
    private String author; // Autor del tópico
    private String course; // Curso relacionado con el tópico
}
