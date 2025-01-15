package com.foro_hub.Api.controller;

import com.foro_hub.Api.config.JwtService;
import com.foro_hub.Api.dto.AuthenticationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;

    // Constructor que inicializa los servicios de autenticación, detalles de usuario y JWT
    public AuthenticationController(
            AuthenticationManager authenticationManager,
            UserDetailsService userDetailsService,
            JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtService = jwtService;
    }

    // Endpoint para el login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationDTO request) {
        // Autenticar al usuario utilizando su nombre de usuario y contraseña
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.username(),
                        request.password()
                )
        );

        // Cargar los detalles del usuario autenticado
        UserDetails user = userDetailsService.loadUserByUsername(request.username());

        // Generar el token JWT para el usuario autenticado
        String token = jwtService.generateToken(user);

        // Devolver la respuesta con el token generado
        return ResponseEntity.ok().body(new TokenResponse(token));
    }

    // Clase interna para encapsular la respuesta del token
    record TokenResponse(String token) {}
}
