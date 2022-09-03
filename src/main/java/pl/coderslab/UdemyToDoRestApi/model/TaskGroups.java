package pl.coderslab.UdemyToDoRestApi.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "task_groups")
public class TaskGroups extends TaskAuditable{
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    private Set<Task> tasks;

    @Embedded
    private Audit audit = new Audit();
    public TaskGroups() {
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }
}
