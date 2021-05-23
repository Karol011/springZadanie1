package pl.sda.zdjava46.zadanie1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.zdjava46.zadanie1.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
