package pl.sda.zdjava46.zadanie1.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "adress")
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "adress")
    Set<User> users;
    private String street;
    private String zipCode;
    private String city;

}
