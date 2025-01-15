package com.foro_hub.Api.repository;

import com.foro_hub.Api.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Anotación para marcar esta interfaz como un repositorio de Spring
@Repository
// Interfaz que extiende JpaRepository para proporcionar operaciones CRUD sobre la entidad Topic
public interface TopicRepository extends JpaRepository<Topic, Long> {
}
