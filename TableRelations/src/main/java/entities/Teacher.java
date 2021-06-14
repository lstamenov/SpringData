package entities;

import javax.persistence.*;

@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    public Teacher(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Teacher() { }
}
