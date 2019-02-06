package application.services.implementation;

import application.repositories.UserRepository;
import application.security.Authenticator;
import application.security.JWTProvider;
import application.services.ISecurityService;
import db.models.User;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecurityService implements ISecurityService {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    private JWTProvider jwtTokenProvider;

    public SecurityService(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           JWTProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public String signin(Authenticator authenticator) {
        try {//i don t know how to avoid using String in 'matches'
            String password = String.valueOf(userRepository.findByLogin(authenticator.getLogin()).getPassword());
            CharSequence authPass = java.nio.CharBuffer.wrap(authenticator.getPassword());
            if(!passwordEncoder.matches(authPass,password)) throw new RuntimeException("Incorrect password");
            return jwtTokenProvider.createToken(authenticator.getLogin());
        } catch (AuthenticationException e) {
            throw new RuntimeException("Invalid username or password");
        }
    }
    @Override
    public String signup(User user) {
            CharSequence password = java.nio.CharBuffer.wrap(user.getPassword());
            user.setPassword(passwordEncoder.encode(password).toCharArray());
            userRepository.save(user);
            return jwtTokenProvider.createToken(user.getLogin());
    }
}
