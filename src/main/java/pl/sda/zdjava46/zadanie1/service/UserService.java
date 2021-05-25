package pl.sda.zdjava46.zadanie1.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;
import pl.sda.zdjava46.zadanie1.entity.User;
import pl.sda.zdjava46.zadanie1.repository.UserRepository;

import java.util.List;

@Service
@Getter
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }
}
