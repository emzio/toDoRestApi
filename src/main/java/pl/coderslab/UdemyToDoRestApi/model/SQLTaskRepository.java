package pl.coderslab.UdemyToDoRestApi.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@RepositoryRestResource
////@RepositoryRestResource(path = "testpath", collectionResourceRel = "testItems")
//
//public interface TaskRepository extends JpaRepository<Task, Long> {
//
//    @Override
//    @RestResource(exported = false)
//    void deleteById(Long aLong);
//
//    @Override
//    @RestResource(exported = false)
//    void delete(Task entity);
//
//    @RestResource(path = "done", rel = "DDDDOOOONNNNNEEEE")
//    List<Task> findByDoneIs(@Param("state") Boolean done);
//

@Repository
interface SQLTaskRepository extends TaskRepository, JpaRepository<Task, Integer> {


}
