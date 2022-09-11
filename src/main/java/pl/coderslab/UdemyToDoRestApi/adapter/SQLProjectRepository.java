package pl.coderslab.UdemyToDoRestApi.adapter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.UdemyToDoRestApi.model.Project;
import pl.coderslab.UdemyToDoRestApi.model.ProjectRepository;

import java.util.List;

@Repository
public interface SQLProjectRepository extends ProjectRepository, JpaRepository<Project, Integer> {

    @Override
    @Query("select distinct p from Project p join fetch p.steps")
    List<Project> findAll();

}
