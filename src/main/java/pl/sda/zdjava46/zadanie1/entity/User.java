package pl.sda.zdjava46.zadanie1.entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import javax.persistence.*;


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

    @Column(length=200, nullable=false, unique=false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    private Address address;

    @Column(length=50, nullable=false, unique=false)
    private String role;


}
