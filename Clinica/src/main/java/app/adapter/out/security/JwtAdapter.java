package app.adapter.out.security;

import app.domain.model.auth.AuthCredentials;
import app.adapter.rest.response.TokenResponseDto;
import app.domain.repositories.TokenRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;
import java.util.UUID;

@Component
public class JwtAdapter implements TokenRepository{
    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final long EXPIRATION_TIME = 3 * 60 * 60 * 1000; // 3 horas en vez de 3 minutos

    @Override
    public TokenResponseDto authenticate(AuthCredentials credentials, String role) {
        String token = this.generateToken(credentials.getUsername(), role);
        TokenResponseDto response = new TokenResponseDto();
        response.setToken(token);
        response.setRole(role); // IMPORTANTE: Setear el rol en la respuesta
        System.out.println("Token generated with role: " + role);
        return response;
    }

    @Override
    public boolean validateToken(String token) {
        try {
            this.getClaims(token);
            return true;
        } catch (Exception e) {
            System.out.println("Token validation failed: " + e.getMessage());
            return false;
        }
    }

    @Override
    public String extractUsername(String token) {
        Claims claims = this.getClaims(token);
        return claims.getSubject();
    }

    @Override
    public String extractRole(String token) {
        Claims claims = this.getClaims(token);
        String role = claims.get("role", String.class);
        System.out.println("Extracted role from token: " + role);
        return role;
    }

    private String generateToken(String username, String role) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + EXPIRATION_TIME);

        // Guardar el rol sin el prefijo ROLE_ (se agregará en el filtro)
        String token = Jwts.builder()
            .setSubject(username)
            .claim("role", role) // Guardar el rol tal como viene (ej: "DOCTOR")
            .setId(UUID.randomUUID().toString())
            .setIssuedAt(now)
            .setExpiration(expiration)
            .signWith(SECRET_KEY)
            .compact();

        System.out.println("Token created for user: " + username + " with role: " + role);
        return token;
    }

    private Claims getClaims(String token) {
        Claims claims = Jwts.parserBuilder()
            .setSigningKey(SECRET_KEY)
            .build()
            .parseClaimsJws(token)
            .getBody();
            
        return claims;
    }
}
