package pl.coderslab.UdemyToDoRestApi.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "task_groups")
public class TaskGroup {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private int id;
    @NotBlank(message = "Task group's  description must not be empty")
    private String description;
    private Boolean done;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    private Set<Task> tasks;

    public TaskGroup() {
    }

    public int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }
}
