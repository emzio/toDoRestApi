package pl.coderslab.UdemyToDoRestApi.model;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository {

    List<Project> findAll();

    Optional<Project> findById(Integer integer);

    TaskGroups save(TaskGroups taskGroups);

}
