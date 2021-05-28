package pl.sda.zdjava46.zadanie1.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.sda.zdjava46.zadanie1.entity.User;
import pl.sda.zdjava46.zadanie1.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping()
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping( "/{id}")
    public Optional<User> findUserById(@PathVariable Long id) {
        return userService.getUserRepository().findById(id);
    }

    @PostMapping()
    public User newUser(@RequestBody User newUser) {
        return userService.getUserRepository().save(newUser);
    }


    @DeleteMapping(value = "/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.getUserRepository().deleteById(id);
    }
}
