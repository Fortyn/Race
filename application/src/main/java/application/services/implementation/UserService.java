package application.services.implementation;

import application.repositories.UserRepository;
import application.services.IUserService;
import db.models.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(); //NoSuchElementException
    }

    @Override
    public User addUser(User user) {
        if(user.getId() != null) throw new IllegalArgumentException("New entity can not have id");
        user.setSalt("salt");
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        if(!userRepository.existsById(user.getId())) throw new NoSuchElementException("No value present");
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);  //EmptyResultDataAccessException
    }
}
