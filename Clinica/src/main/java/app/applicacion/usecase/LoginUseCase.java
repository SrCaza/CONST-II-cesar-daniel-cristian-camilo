package app.applicacion.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import app.adapter.rest.response.TokenResponse;
import app.domain.model.auth.CredentialsAuth;
import app.domain.services.AuthenticationService;


@Component
public class LoginUseCase {
	
    @Autowired
    private AuthenticationService authenticationService;

    public TokenResponse login(CredentialsAuth credentials) throws Exception {
        return authenticationService.authenticate(credentials);
    }
}
