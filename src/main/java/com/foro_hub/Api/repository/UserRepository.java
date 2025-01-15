package com.foro_hub.Api.repository;

import com.foro_hub.Api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Interfaz que extiende JpaRepository para proporcionar operaciones CRUD sobre la entidad User
public interface UserRepository extends JpaRepository<User, Long> {
    // Método personalizado para encontrar un usuario por su nombre de usuario
    Optional<User> findByUsername(String username);
}
