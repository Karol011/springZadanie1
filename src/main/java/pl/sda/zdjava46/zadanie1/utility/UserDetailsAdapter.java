package pl.sda.zdjava46.zadanie1.utility;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.sda.zdjava46.zadanie1.entity.User;

import java.util.Collection;
import java.util.List;


public class UserDetailsAdapter implements UserDetails {

    private final User user;

    public UserDetailsAdapter(final User user) {
        this.user = user;
    }

    @Override
    //Role jeszcze u mnie nie dzialaja, są bo są
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(user.getRole()));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}