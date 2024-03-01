package kz.aitu.onlineshop.models;
import jakarta.persistence.*;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "users")
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private boolean status;
    private double bank;
    private String email;
    private String password;
}
