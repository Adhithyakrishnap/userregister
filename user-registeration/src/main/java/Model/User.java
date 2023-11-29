package Model;


import Enums.Usertype;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class User
{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Usertype usertype;

    private String password;
}
