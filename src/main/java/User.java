import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
@Entity
@Table(name = "user")
public class User implements Serializable {
    private static final long serialVersionUID = -5660821718138969527L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;
    @Column(name = "name", length = 11)
    private int age;

    @Column(name="first_name", length = 25)
    private String firstname;
    @Column(name = "last_name", length = 25)
    private String lastname;
    @OneToOne
    @PrimaryKeyJoinColumn
    private Role role;

    public User() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
