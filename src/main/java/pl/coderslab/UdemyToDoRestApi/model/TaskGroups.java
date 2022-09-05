package pl.coderslab.UdemyToDoRestApi.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "task_groups")
public class TaskGroups extends TaskAuditable{
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    private Set<Task> tasks;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Projects projects;

    public Projects getProjects() {
        return projects;
    }

    void setProjects(Projects projects) {
        this.projects = projects;
    }

    public TaskGroups() {
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }
}
