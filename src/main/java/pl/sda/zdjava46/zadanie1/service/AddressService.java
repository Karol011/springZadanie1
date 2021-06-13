package pl.sda.zdjava46.zadanie1.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;
import pl.sda.zdjava46.zadanie1.entity.Address;
import pl.sda.zdjava46.zadanie1.entity.User;
import pl.sda.zdjava46.zadanie1.exceptions.addressNotFoundException;
import pl.sda.zdjava46.zadanie1.exceptions.userNotFoundException;
import pl.sda.zdjava46.zadanie1.repository.AddressRepository;

import java.util.List;
import java.util.Optional;

@Service
@Getter
@AllArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    public Address findById(Long id) {
        return getAddressRepository()
                .findById(id)
                .orElseThrow(() -> new addressNotFoundException("address with id " + id + " not found"));
    }

    public Address save(Address newAddress) {
        return addressRepository.save(newAddress);
    }

    public void deleteById(Long id) {
        addressRepository.deleteById(id);
    }
}
