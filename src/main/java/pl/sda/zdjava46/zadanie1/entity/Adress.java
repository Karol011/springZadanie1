package pl.sda.zdjava46.zadanie1.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
public class Adress {

    @Id
    private Long id;
    @OneToMany
    Set<User> users;
    private String street;
    private String zipCode;
    private String city;

}
