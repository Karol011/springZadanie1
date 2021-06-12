package pl.sda.zdjava46.zadanie1.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.sda.zdjava46.zadanie1.exceptions.userNotFoundException;
import pl.sda.zdjava46.zadanie1.repository.UserRepository;
import pl.sda.zdjava46.zadanie1.utility.UserDetailsAdapter;

@Service
@AllArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return userRepository.findByName(userName)
                .map(UserDetailsAdapter::new)
                .orElseThrow(() -> new userNotFoundException(userName + " not found"));
    }
}
