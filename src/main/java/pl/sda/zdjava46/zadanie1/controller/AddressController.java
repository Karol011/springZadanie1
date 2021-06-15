package pl.sda.zdjava46.zadanie1.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import pl.sda.zdjava46.zadanie1.entity.Address;
import pl.sda.zdjava46.zadanie1.service.AddressService;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/addresses")
public class AddressController {

    private final AddressService addressService;



    @GetMapping
    public List<Address> findAll() {
        return addressService.findAll();
    }

    //{id}/address a nie samo {id}, bo to podobno dobra praktyka
    @GetMapping("/{id}/address")
    public Address findAddressById(@PathVariable Long id) {
        return addressService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Address> newAddress(@RequestBody Address newAddress) {
        return addressService.save(newAddress);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/{id}/address")
    public void deleteAddressById(@PathVariable Long id) {
        addressService.deleteById(id);
    }


}
