package pl.sda.zdjava46.zadanie1.controller;

import lombok.AllArgsConstructor;
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

    @GetMapping("/{id}/address")
    public Address findAddressById(@PathVariable Long id) {
        return addressService.findById(id);
    }

    @PostMapping
    public Address newAddress(@RequestBody Address newAddress) {
        return addressService.save(newAddress);
    }

    @DeleteMapping("/{id}")
    public void deleteAddressById(@PathVariable Long id) {
        addressService.deleteById(id);
    }


}
