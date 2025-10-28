package app.domain.repositories;

import app.domain.model.auth.AuthCredentials;
import app.domain.model.auth.TokenResponse;

public interface TokenRepository {
	TokenResponse authenticate(AuthCredentials credentials, String role);
	boolean validateToken(String token);
	String extractUsername(String token);
	String extractRole(String token);

}
