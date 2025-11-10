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
		String token = this.extractToken(request);
		System.out.println("=== JWT FILTER DEBUG ===");
		System.out.println("Request URI: " + request.getRequestURI());
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
			System.out.println("Role extracted: '" + role + "'");
			if (role == null || role.trim().isEmpty()) {
				System.out.println("ERROR: Role is null or empty!");
				return;
			}
			String normalized = role.trim();
			if (!normalized.toUpperCase().startsWith("ROLE_")) {
				normalized = "ROLE_" + normalized.toUpperCase();
			} else {
				normalized = normalized.toUpperCase();
			}
			System.out.println("Normalized role: " + normalized);
			ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(normalized));
			System.out.println("Authorities: " + authorities);
			UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(username, null,
					authorities);
			SecurityContextHolder.getContext().setAuthentication(auth);
			System.out.println("Authentication set successfully!");
		}
		System.out.println("======================");
	}
}
