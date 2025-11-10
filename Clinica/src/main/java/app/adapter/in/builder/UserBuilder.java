package app.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.validators.UserValidator;
import app.domain.model.User;

@Component
public class UserBuilder {
    @Autowired
    private UserValidator userValidator;
    
    public User build(String name, String document, String age, String userName, String password) throws Exception {
        User user = new User();
        
        // Validar y asignar nombre
        user.setName(userValidator.nameValidator(name));
        
        // Validar y asignar documento (convertir String a long)
        user.setDocument(userValidator.documentValidator(document));
        
        // Validar y asignar edad (convertir String a int)
        String ageInt = userValidator.ageValidator(age);
        user.setAge(ageInt);
        
        // Validar y asignar username
        user.setUsername(userValidator.userNameValidator(userName));
        
        // Validar y asignar password
        user.setPassword(userValidator.passwordValidator(password));
        
        return user;
    }
}
