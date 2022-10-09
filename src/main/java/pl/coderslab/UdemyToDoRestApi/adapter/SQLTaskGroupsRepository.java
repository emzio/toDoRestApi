package pl.coderslab.UdemyToDoRestApi.adapter;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.UdemyToDoRestApi.model.TaskGroups;
import pl.coderslab.UdemyToDoRestApi.model.TaskGroupsRepository;

import java.util.List;

@Repository
public interface SQLTaskGroupsRepository extends JpaRepository<TaskGroups, Integer>, TaskGroupsRepository {

    @Override
    @Query("SELECT distinct g from TaskGroups g join fetch g.tasks")
    List<TaskGroups>  findAll();

    @Override
    boolean existsByDoneIsFalseAndProjectId(int id);
}
