package pl.sda.zdjava46.zadanie1.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sda.zdjava46.zadanie1.entity.User;
import pl.sda.zdjava46.zadanie1.exceptions.userNotFoundException;
import pl.sda.zdjava46.zadanie1.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@Getter
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public User findById(Long id) {
        return getUserRepository()
                .findById(id)
                .orElseThrow(() -> new userNotFoundException("user with id " + id + " not found"));
    }


    public User findByUserName(String name) {
        return userRepository.findByName(name)
                .orElseThrow(() -> new userNotFoundException(name + " not found"));

    }

    public List<User> findAll() {
        return getUserRepository().findAll();
    }

    public ResponseEntity<User> save(User newUser) {

        User user = new User();
        user.setName(newUser.getName());
        user.setSurname(newUser.getName());
        //hashuje haslo za pomoca Beana w klasie SecurityConfig
        user.setPassword(passwordEncoder.encode(newUser.getPassword()));
        user.setRole(newUser.getRole());
        userRepository.save(user);

        return new ResponseEntity<>(user,
                HttpStatus.CREATED);
    }
    public void deleteById(Long id) {
        getUserRepository().deleteById(id);
    }


}
