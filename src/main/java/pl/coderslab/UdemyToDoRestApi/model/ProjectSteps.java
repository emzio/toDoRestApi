package pl.coderslab.UdemyToDoRestApi.model;


import javax.persistence.*;

@Entity
public class ProjectSteps {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    private String description;
    @Column(name = "days_to_deadline")
    private Long daysToDeadline;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project projects;

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

    public Long getDaysToDeadline() {
        return daysToDeadline;
    }

    public void setDaysToDeadline(Long daysToDeadline) {
        this.daysToDeadline = daysToDeadline;
    }

    public Project getProjects() {
        return projects;
    }

    void setProjects(Project projects) {
        this.projects = projects;
    }


}
