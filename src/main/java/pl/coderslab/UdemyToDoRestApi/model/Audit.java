package pl.coderslab.UdemyToDoRestApi.model;

import javax.persistence.Embeddable;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@Embeddable
public abstract class Audit {
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    @PrePersist
    void prePersist(){
        createdOn=LocalDateTime.now();
    }

    @PreUpdate
    void preUpdate(){
        updatedOn=LocalDateTime.now();
    }


}
