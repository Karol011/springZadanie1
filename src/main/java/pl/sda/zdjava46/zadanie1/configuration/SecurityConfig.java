package pl.sda.zdjava46.zadanie1.configuration;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.sda.zdjava46.zadanie1.service.MyUserDetailsService;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private MyUserDetailsService myUserDetailsService;

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //dla wszystkiego po addresses/ wymagaj zalogowanego uzytkownika
                .antMatchers("/addresses/**").authenticated()
                //dla wszystkiego po users/ pozwol KAZDEMU na jakiekolwiek zmiany
                .antMatchers("/users/**").permitAll()
                //nadpisuje wczesniejsze pozwolenie i wymaga zalogowania przy metodzie DELETE
                .antMatchers(HttpMethod.DELETE, "/users/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .and()
                .httpBasic()
                .and()
                .logout()
                .and()
                /*
                Spring Security oferuje możliwość bronienia się przed atakami CSFR.
                 Atak ten jest próbą wrobienia użytkownika we wpisanie jego nazwy użytkownika i hasła na stronie,
                  która np. przypomina stronę docelową.

                  Włączony CSRF uniemożliwia wysłania żądania z niektórymi metodami
                   (np. POST) za pomocą REST API.
                 */
                .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService).passwordEncoder(encoder());
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}