package pl.sda.zdjava46.zadanie1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.sda.zdjava46.zadanie1.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
