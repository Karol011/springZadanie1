package pl.sda.zdjava46.zadanie1.controller;

import org.springframework.web.bind.annotation.*;
import pl.sda.zdjava46.zadanie1.entity.User;
import pl.sda.zdjava46.zadanie1.repository.UserRepository;
import pl.sda.zdjava46.zadanie1.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<User> findUserById(@PathVariable Long id) {
        return userService.getUserRepository().findById(id);
    }

    @PostMapping("/add")
    public User newUser(@RequestBody User newUser) {
        return userService.getUserRepository().save(newUser);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.getUserRepository().deleteById(id);
    }
}
