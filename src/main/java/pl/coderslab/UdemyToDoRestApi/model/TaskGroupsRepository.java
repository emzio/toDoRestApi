package pl.coderslab.UdemyToDoRestApi.model;

import java.util.List;
import java.util.Optional;

public interface TaskGroupsRepository {

    List<TaskGroups> findAll();

    Optional<TaskGroups> findById(Integer integer);

    List<TaskGroups> findAllByDoneIsFalseAndProjectId(int id);

    TaskGroups save(TaskGroups taskGroups);

    boolean existsByDoneIsFalseAndProjectId(int projectId);
}
