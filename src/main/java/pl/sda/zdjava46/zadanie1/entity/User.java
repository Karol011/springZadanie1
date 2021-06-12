package pl.sda.zdjava46.zadanie1.entity;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

@Entity
@Data
@Table(name = "user")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @Column(length=50, nullable=false, unique=false)
    private String name;
    @Column(length=50, nullable=false, unique=false)
    private String surname;
    @Column(length=50, nullable=false, unique=false)
    private String password;
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    private Address address;
    @Column(length=50, nullable=false, unique=false)
    private String role;


}
