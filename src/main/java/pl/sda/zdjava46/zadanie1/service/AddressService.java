package pl.sda.zdjava46.zadanie1.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;
import pl.sda.zdjava46.zadanie1.repository.AddressRepository;

@Service
@Getter
@AllArgsConstructor
public class AddressService {

    private AddressRepository addressRepository;
}
