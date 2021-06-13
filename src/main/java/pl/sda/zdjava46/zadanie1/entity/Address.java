package pl.sda.zdjava46.zadanie1.entity;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;

    @OneToMany(mappedBy = "address")
    //DETACH jak usune adres a jakis user go ma to go po prostu odlacz a nie skasuj (usera) calkowicie
    @Cascade(org.hibernate.annotations.CascadeType.DETACH)
    List<User> users;
    @Column(length=50, nullable=false, unique=false)
    private String street;

    @Column(length=50, nullable=false, unique=false)
    private String zipCode;

    @Column(length=50, nullable=false, unique=false)
    private String city;


}
