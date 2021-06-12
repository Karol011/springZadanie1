package pl.sda.zdjava46.zadanie1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.zdjava46.zadanie1.entity.User;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

     Optional<User> findByName(String name);
}
