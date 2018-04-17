package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "role")
public class Role extends Model {

    private static final long serialVersionUID = 3913596127777173999L;

    @Column(name = "title")
    private String title;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<User>();

    public Role(){
        super();
    }
    public Role(Long id){
        super(id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
