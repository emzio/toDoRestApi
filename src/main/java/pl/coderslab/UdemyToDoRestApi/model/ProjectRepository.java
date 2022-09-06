package pl.coderslab.UdemyToDoRestApi.model;

import java.util.List;

public interface ProjectRepository {

    List<Project> findAll();
}
