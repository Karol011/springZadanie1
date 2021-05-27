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
    @Cascade(org.hibernate.annotations.CascadeType.DETACH)
    List<User> users;
    @Column(length=50, nullable=false, unique=false)
    private String street;
    @Column(length=50, nullable=false, unique=false)
    private String zipCode;
    @Column(length=50, nullable=false, unique=false)
    private String city;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) &&
                Objects.equals(users, address.users) &&
                Objects.equals(street, address.street) &&
                Objects.equals(zipCode, address.zipCode) &&
                Objects.equals(city, address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, users, street, zipCode, city);
    }
}
