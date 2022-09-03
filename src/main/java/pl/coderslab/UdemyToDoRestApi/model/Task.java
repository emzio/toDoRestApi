package pl.coderslab.UdemyToDoRestApi.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
public class Task extends TaskAuditable{
    private LocalDateTime deadline;
    @Embedded
    private Audit audit = new Audit();
    @ManyToOne()
    @JoinColumn(name = "TASK_GROUPS_ID")
    private TaskGroups group;

    public Task() {
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public TaskGroups getGroup() {
        return group;
    }

    public void setGroup(TaskGroups group) {
        this.group = group;
    }

    public void updateFrom(final Task source){
        description = source.description;
        done = source.done;
        deadline = source.deadline;
//        group = source.group;
    }

}
