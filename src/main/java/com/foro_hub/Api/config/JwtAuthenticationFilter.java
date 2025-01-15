package com.foro_hub.Api.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

// Filtro de autenticación JWT
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    // Constructor que recibe servicios de JWT y detalles del usuario
    public JwtAuthenticationFilter(JwtService jwtService, UserDetailsService userDetailsService) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    // Método principal del filtro de autenticación
    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {
        try {
            final String authHeader = request.getHeader("Authorization");
            System.out.println("Auth Header: " + authHeader);

            // Verifica si el encabezado de autorización es válido
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                System.out.println("No token found or invalid format");
                filterChain.doFilter(request, response);
                return;
            }

            final String jwt = authHeader.substring(7);
            final String username = jwtService.extractUsername(jwt);
            System.out.println("Extracted username: " + username);

            // Verifica si el usuario no está autenticado en el contexto de seguridad
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
                System.out.println("User details loaded: " + userDetails.getUsername());

                // Verifica si el token es válido
                if (jwtService.isTokenValid(jwt, userDetails)) {
                    System.out.println("Token is valid");
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities()
                    );
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                } else {
                    System.out.println("Token validation failed");
                }
            }
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            System.out.println("Error in filter: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
}
