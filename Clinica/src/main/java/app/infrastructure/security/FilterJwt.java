package app.infrastructure.security;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import app.domain.repositories.TokenRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FilterJwt extends OncePerRequestFilter {

    @Autowired
    private TokenRepository tokenRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // 🔹 1️⃣ Ignorar rutas de autenticación (no requieren token)
        String path = request.getRequestURI();
        if (path.startsWith("/api/auth")) {
            filterChain.doFilter(request, response);
            return;
        }

        // 🔹 2️⃣ Extraer token del encabezado Authorization
        String token = extractToken(request);

        // 🔹 3️⃣ Si hay token, procesarlo
        if (token != null) {
            try {
                processToken(token);
            } catch (Exception e) {
                // Si hay error en validación, se deja sin autenticación pero no se bloquea
                System.out.println("Error al procesar token: " + e.getMessage());
            }
        }

        // 🔹 4️⃣ Continuar con el resto del filtro
        filterChain.doFilter(request, response);
    }

    // Extrae el token del header "Authorization"
    private String extractToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            return header.substring(7);
        }
        return null;
    }

    // Procesa el token: lo valida y asigna la autenticación al contexto
    private void processToken(String token) {
        if (tokenRepository.validateToken(token)) {
            String username = tokenRepository.extractUsername(token);
            String role = tokenRepository.extractRole(token);

            if (role == null || role.trim().isEmpty()) {
                return; // sin rol => sin autenticación
            }

            // Normaliza el rol (asegura formato ROLE_X)
            String normalized = role.trim().toUpperCase();
            if (!normalized.startsWith("ROLE_")) {
                normalized = "ROLE_" + normalized;
            }

            ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(normalized));

            UsernamePasswordAuthenticationToken auth =
                    new UsernamePasswordAuthenticationToken(username, null, authorities);

            SecurityContextHolder.getContext().setAuthentication(auth);
        }
    }
}
