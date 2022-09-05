package pl.coderslab.UdemyToDoRestApi.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    private String description;

    @OneToMany(mappedBy = "projects")
    private Set<TaskGroups> groups;
    public String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    public Set<TaskGroups> getGroups() {
        return groups;
    }

    void setGroups(Set<TaskGroups> groups) {
        this.groups = groups;
    }
}
