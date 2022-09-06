//package pl.coderslab.UdemyToDoRestApi.adapter;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//import pl.coderslab.UdemyToDoRestApi.model.ProjectRepository;
//import pl.coderslab.UdemyToDoRestApi.model.ProjectSteps;
//
//import java.util.List;
//
//@Repository
//public interface SQLProjectStepsRepository extends ProjectRepository, JpaRepository<ProjectSteps, Integer> {
//
//    @Override
//    @Query("select distinct ps from ProjectSteps ps join fetch ps.projects")
//    List<ProjectSteps> findAll();
//}
