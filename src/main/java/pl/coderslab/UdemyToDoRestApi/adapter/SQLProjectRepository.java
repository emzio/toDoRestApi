package pl.coderslab.UdemyToDoRestApi.adapter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.UdemyToDoRestApi.model.ProjectRepository;
import pl.coderslab.UdemyToDoRestApi.model.Project;

@Repository
public interface SQLProjectRepository extends ProjectRepository, JpaRepository<Project, Integer> {

}
