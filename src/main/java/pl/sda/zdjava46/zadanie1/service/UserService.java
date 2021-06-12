package pl.sda.zdjava46.zadanie1.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
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

    public void save(User newUser) {
        getUserRepository().save(newUser);
    }

    public void deleteById(Long id) {
        getUserRepository().deleteById(id);
    }


}
