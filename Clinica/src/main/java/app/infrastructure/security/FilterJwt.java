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
		
		String requestURI = request.getRequestURI();
		
		// Permitir acceso sin autenticación a endpoints públicos
		if (requestURI.startsWith("/api/auth/")) {
			filterChain.doFilter(request, response);
			return;
		}
		
		String token = this.extractToken(request);
		System.out.println("=== JWT FILTER DEBUG ===");
		System.out.println("Request URI: " + requestURI);
		System.out.println("Token present: " + (token != null));
		
		if (token != null) {
			this.processToken(token);
		}
		
		filterChain.doFilter(request, response);
	}

	private String extractToken(HttpServletRequest request) {
		String header = request.getHeader("Authorization");
		if (header != null && header.startsWith("Bearer ")) {
			return header.substring(7);
		}
		return null;
	}

	private void processToken(String token) {
		System.out.println("Validating token...");
		boolean isValid = tokenRepository.validateToken(token);
		System.out.println("Token valid: " + isValid);
		
		if (isValid) {
			String username = tokenRepository.extractUsername(token);
			String role = tokenRepository.extractRole(token);
			
			System.out.println("Username: " + username);
			System.out.println("Role extracted from token: '" + role + "'");
			
			if (role == null || role.trim().isEmpty()) {
				System.out.println("ERROR: Role is null or empty!");
				return;
			}
			
			// Normalizar el rol: agregar ROLE_ si no lo tiene
			String normalizedRole = role.trim().toUpperCase();
			if (!normalizedRole.startsWith("ROLE_")) {
				normalizedRole = "ROLE_" + normalizedRole;
			}
			
			System.out.println("Normalized role: " + normalizedRole);
			
			// Crear la autoridad con el rol normalizado
			ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(normalizedRole));
			
			System.out.println("Authorities: " + authorities);
			
			// Crear la autenticación
			UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
				username, 
				null,
				authorities
			);
			
			// Establecer la autenticación en el contexto de seguridad
			SecurityContextHolder.getContext().setAuthentication(auth);
			System.out.println("Authentication set successfully!");
			System.out.println("SecurityContext authorities: " + SecurityContextHolder.getContext().getAuthentication().getAuthorities());
		}
		System.out.println("======================");
	}
}
