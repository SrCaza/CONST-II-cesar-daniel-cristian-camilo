package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.adapter.rest.response.TokenResponse;
import app.application.exceptions.BusunessException;
import app.domain.model.User;
import app.domain.model.auth.CredentialsAuth;
import app.domain.repositories.TokenRepository;
import app.domain.repositories.UserRepository;



@Service
public class AuthenticationService {
	
    @Autowired
    private TokenRepository tokenRepository;
    
    @Autowired
    private UserRepository userRepository;
    

    public TokenResponse authenticate(CredentialsAuth credentials) throws Exception{
        User user = this.getUserByUsername(credentials.getUsername());
        this.validatePassword(credentials.getPassword(), user.getPassword());
        return tokenRepository.authenticate(credentials, String.valueOf(user.getRole()));
    }

    private User getUserByUsername(String username)  throws Exception{
    	User user = new User();
    	user.setUsername(username);
        user = userRepository.findByUsername(user);
        if (user == null) {
            throw new BusunessException("Usuario no encontrado");
        }
        return user;
    }

    private void validatePassword(String inputPassword, String storedPassword) throws Exception {
        if (!inputPassword.equals(storedPassword)) {
            throw new BusunessException("Contraseña incorrecta");
        }
    }

}
