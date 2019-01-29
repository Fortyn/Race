package db.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "chat")
public class Chat {
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "chat")
    private Set<Message> message = new HashSet<>();

    @OneToMany(mappedBy = "chat")
    private Set<Right> rights = new HashSet<>();

    public Set<Message> getMessage() {
        return message;
    }

    public void setMessage(Set<Message> message) {
        this.message = message;
    }

    public Set<Right> getRights() {
        return rights;
    }

    public void setRights(Set<Right> rights) {
        this.rights = rights;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
