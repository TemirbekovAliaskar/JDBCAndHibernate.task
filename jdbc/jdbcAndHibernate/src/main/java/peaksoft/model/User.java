package peaksoft.model;


import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;




@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_generator")
    @SequenceGenerator(name = "user_generator",sequenceName = "users_sequence",allocationSize = 1)
    private Long id;

    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    private Byte age;

    public User() {
    }

    public User(String name, String lastName, Byte age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }
}