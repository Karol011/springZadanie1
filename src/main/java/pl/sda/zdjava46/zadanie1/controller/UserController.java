package pl.sda.zdjava46.zadanie1.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import pl.sda.zdjava46.zadanie1.entity.User;
import pl.sda.zdjava46.zadanie1.exceptions.userNotFoundException;
import pl.sda.zdjava46.zadanie1.service.UserService;

import java.util.List;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    //{id}/user a nie samo {id}, bo to podobno dobra praktyka
    @GetMapping("/{id}/user")
    public User findUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @ExceptionHandler
    public ResponseEntity<String> exceptionHandler(userNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }

    @PostMapping()
    public ResponseEntity<User> newUser(@RequestBody User newUser) {

        if (newUser.equals(null)) {
            throw new RuntimeException("You must define new user");
        } else {
            return userService.save(newUser);
        }
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/{id}/user")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteById(id);
    }
}
