package pl.sda.zdjava46.zadanie1.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.sda.zdjava46.zadanie1.entity.Address;
import pl.sda.zdjava46.zadanie1.entity.User;
import pl.sda.zdjava46.zadanie1.exceptions.addressNotFoundException;
import pl.sda.zdjava46.zadanie1.exceptions.userNotFoundException;
import pl.sda.zdjava46.zadanie1.repository.AddressRepository;

import java.util.List;

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

    public ResponseEntity<Address> save(Address newAddress) {
        Address address = new Address();
        address.setStreet(newAddress.getStreet());
        address.setCity(newAddress.getCity());
        address.setZipCode(newAddress.getZipCode());
        address.setUsers(newAddress.getUsers());

        addressRepository.save(newAddress);
        return new ResponseEntity<Address>(address,
                HttpStatus.CREATED);
    }

    public void deleteById(Long id) {
        addressRepository.deleteById(id);
    }
}
