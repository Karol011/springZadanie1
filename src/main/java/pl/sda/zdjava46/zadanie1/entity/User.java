package pl.sda.zdjava46.zadanie1.entity;


import lombok.Data;
import pl.sda.zdjava46.zadanie1.repository.UserRepository;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class User {

    @Id
    private Long id;
    private String name;
    private String surname;
    @ManyToOne
    private Adress adress;
}
