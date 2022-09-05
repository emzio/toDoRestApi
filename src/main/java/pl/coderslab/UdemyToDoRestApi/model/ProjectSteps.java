package pl.coderslab.UdemyToDoRestApi.model;


import javax.persistence.*;

@Entity
public class ProjectSteps {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    private String description;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Projects projects;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    public Projects getProjects() {
        return projects;
    }

    void setProjects(Projects projects) {
        this.projects = projects;
    }


}
