package pl.coderslab.UdemyToDoRestApi.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
public class Task extends TaskAuditable{
//    @Id
//    @GeneratedValue(strategy =GenerationType.IDENTITY)
//    private int id;
//    @NotBlank(message = "Task description must not be empty")
//    private String description;
//    private Boolean done;
    private LocalDateTime deadline;
    @Embedded
    private Audit audit = new Audit();
    @ManyToOne()
    @JoinColumn(name = "TASK_GROUPS_ID")
    private TaskGroups group;

    public Task() {
    }
//    public int getId() {
//        return id;
//    }
//
//    void setId(int id) {
//        this.id = id;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    void setDescription(String description) {
//        this.description = description;
//    }
//
//    public Boolean getDone() {
//        return done;
//    }
//
//    public void setDone(Boolean done) {
//        this.done = done;
//    }

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
