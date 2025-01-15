package com.foro_hub.Api.controller;

import com.foro_hub.Api.model.Topic;
import com.foro_hub.Api.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/topics")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    // Método para crear un nuevo tópico
    @PostMapping
    public ResponseEntity<Topic> createTopic(@RequestBody Topic topic) {
        Topic savedTopic = topicRepository.save(topic);
        return new ResponseEntity<>(savedTopic, HttpStatus.CREATED); // Devuelve el tópico creado con el estado HTTP 201 (CREATED)
    }

    // Método para obtener todos los tópicos
    @GetMapping
    public ResponseEntity<List<Topic>> getAllTopics() {
        List<Topic> topics = topicRepository.findAll();
        return new ResponseEntity<>(topics, HttpStatus.OK); // Devuelve la lista de tópicos con el estado HTTP 200 (OK)
    }

    // Método para obtener un tópico específico por ID
    @GetMapping("/{id}")
    public ResponseEntity<Topic> getTopicById(@PathVariable Long id) {
        Optional<Topic> topic = topicRepository.findById(id);
        if (topic.isPresent()) {
            return new ResponseEntity<>(topic.get(), HttpStatus.OK); // Devuelve el tópico encontrado con el estado HTTP 200 (OK)
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Devuelve el estado HTTP 404 (NOT FOUND) si no se encuentra el tópico
    }

    // Método para actualizar un tópico existente por ID
    @PutMapping("/{id}")
    public ResponseEntity<Topic> updateTopic(@PathVariable Long id, @RequestBody Topic topicDetails) {
        Optional<Topic> existingTopic = topicRepository.findById(id);
        if (existingTopic.isPresent()) {
            Topic topic = existingTopic.get();
            topic.setTitle(topicDetails.getTitle());
            topic.setMessage(topicDetails.getMessage());
            topic.setStatus(topicDetails.getStatus());
            topic.setAuthor(topicDetails.getAuthor());
            topic.setCourse(topicDetails.getCourse());
            topicRepository.save(topic); // Guarda el tópico actualizado en el repositorio
            return new ResponseEntity<>(topic, HttpStatus.OK); // Devuelve el tópico actualizado con el estado HTTP 200 (OK)
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Devuelve el estado HTTP 404 (NOT FOUND) si no se encuentra el tópico
    }

    // Método para eliminar un tópico por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopic(@PathVariable Long id) {
        Optional<Topic> existingTopic = topicRepository.findById(id);
        if (existingTopic.isPresent()) {
            topicRepository.deleteById(id); // Elimina el tópico del repositorio
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Devuelve el estado HTTP 204 (NO CONTENT) si la eliminación es exitosa
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Devuelve el estado HTTP 404 (NOT FOUND) si no se encuentra el tópico
    }
}
