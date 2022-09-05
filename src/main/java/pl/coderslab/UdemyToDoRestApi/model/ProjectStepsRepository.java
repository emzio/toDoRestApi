package pl.coderslab.UdemyToDoRestApi.model;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectStepsRepository {

    List<ProjectSteps> findAll();
}
