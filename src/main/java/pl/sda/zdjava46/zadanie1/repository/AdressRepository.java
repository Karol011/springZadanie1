package pl.sda.zdjava46.zadanie1.repository;

import org.springframework.data.repository.CrudRepository;
import pl.sda.zdjava46.zadanie1.entity.Adress;

public interface AdressRepository extends CrudRepository<Adress, Long> {
}
