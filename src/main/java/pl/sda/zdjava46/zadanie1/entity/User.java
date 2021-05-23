package pl.sda.zdjava46.zadanie1.entity;


import lombok.Data;
import pl.sda.zdjava46.zadanie1.repository.UserRepository;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    @ManyToOne
    private Adress adress;
}
