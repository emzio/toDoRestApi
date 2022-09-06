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

    @OneToMany(mappedBy = "project")
    private Set<TaskGroups> groups;
    @OneToMany(mappedBy = "project")
    private Set<ProjectSteps> steps;
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

    public Set<ProjectSteps> getSteps() {
        return steps;
    }

    void setSteps(Set<ProjectSteps> steps) {
        this.steps = steps;
    }
}
