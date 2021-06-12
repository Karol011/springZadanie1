package pl.sda.zdjava46.zadanie1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.zdjava46.zadanie1.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
