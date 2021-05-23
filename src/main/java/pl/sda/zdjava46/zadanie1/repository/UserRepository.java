package pl.sda.zdjava46.zadanie1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import pl.sda.zdjava46.zadanie1.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
