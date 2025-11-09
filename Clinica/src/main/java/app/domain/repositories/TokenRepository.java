package app.domain.repositories;

import app.adapter.rest.response.TokenResponseDto;
import app.domain.model.auth.AuthCredentials;

public interface TokenRepository {
	TokenResponseDto authenticate(AuthCredentials credentials, String role);

	boolean validateToken(String token);

	String extractUsername(String token);

	String extractRole(String token);

}
