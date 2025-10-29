package app.domain.repositories;

import app.adapter.rest.response.TokenResponse;
import app.domain.model.auth.CredentialsAuth;

public interface TokenRepository {
	TokenResponse authenticate(CredentialsAuth credentials, String role);
	boolean validateToken(String token);
	String extractUsername(String token);
	String extractRole(String token);
	

}
