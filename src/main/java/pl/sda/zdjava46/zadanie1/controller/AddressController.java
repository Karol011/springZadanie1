package pl.sda.zdjava46.zadanie1.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.sda.zdjava46.zadanie1.entity.Address;
import pl.sda.zdjava46.zadanie1.service.AddressService;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/address")
@AllArgsConstructor
public class AddressController {

    private final AddressService addressService;



    @GetMapping("/all")
    public List<Address> findAll() {
        return addressService.getAddressRepository().findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Address> findAddressById(@PathVariable Long id) {
        return addressService.getAddressRepository().findById(id);
    }

    @PostMapping("/add")
    public Address newAddress(@RequestBody Address newAddress) {
        return addressService.getAddressRepository().save(newAddress);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteAddressById(@PathVariable Long id) {
        addressService.getAddressRepository().deleteById(id);
    }


}
