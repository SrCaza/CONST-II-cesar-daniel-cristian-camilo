package app.domain.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.adapter.rest.response.TokenResponseDto;
import app.application.exceptions.BusunessException;
import app.domain.model.User;
import app.domain.model.auth.AuthCredentials;
import app.domain.repositories.TokenRepository;
import app.domain.repositories.UserRepository;

@Service
public class AuthenticationService {
	
    @Autowired
    private TokenRepository tokenRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    public TokenResponseDto authenticate(AuthCredentials credentials) throws Exception {
        // Buscar usuario por username
        User user = this.getUserByUsername(credentials.getUsername());
        
        // Validar contraseña
        this.validatePassword(credentials.getPassword(), user.getPassword());
        
        // Generar token con el rol del usuario
        return tokenRepository.authenticate(credentials, String.valueOf(user.getRole()));
    }

    private User getUserByUsername(String username) throws Exception {
        Optional<User> userOpt = userRepository.findByUsername(username);
        
        if (userOpt.isEmpty()) {
            throw new BusunessException("Usuario no encontrado");
        }
        
        return userOpt.get();
    }

    private void validatePassword(String inputPassword, String storedPassword) throws Exception {
        if (!inputPassword.equals(storedPassword)) {
            throw new BusunessException("Contraseña incorrecta");
        }
    }
}
