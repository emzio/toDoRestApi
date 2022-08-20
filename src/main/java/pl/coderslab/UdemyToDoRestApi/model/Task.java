package pl.coderslab.UdemyToDoRestApi.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Task description must not be empty")
    private String description;
    private Boolean done;

    public Task() {
    }
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

    public Boolean getDone() {
        return done;
    }

    void setDone(Boolean done) {
        this.done = done;
    }


}
