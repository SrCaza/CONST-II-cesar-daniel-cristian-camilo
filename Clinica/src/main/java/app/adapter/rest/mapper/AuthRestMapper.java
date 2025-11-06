package app.adapter.rest.mapper;

import org.springframework.stereotype.Component;

import app.adapter.rest.request.AuthRequest;
import app.adapter.rest.response.TokenResponseDto;
import app.domain.model.auth.AuthCredentials;

@Component
public class AuthRestMapper {
    public AuthCredentials toDomain(AuthRequest req) {
        AuthCredentials c = new AuthCredentials();
        c.setUsername(req.getUsername());
        c.setPassword(req.getPassword());
        return c;
    }

    public TokenResponseDto toResponse(TokenResponseDto token) {
        return new TokenResponseDto(token.getToken());
    }
}
