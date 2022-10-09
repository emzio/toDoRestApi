package pl.coderslab.UdemyToDoRestApi.logic;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import pl.coderslab.UdemyToDoRestApi.model.Project;
import pl.coderslab.UdemyToDoRestApi.model.ProjectRepository;
import pl.coderslab.UdemyToDoRestApi.model.TaskGroups;
import pl.coderslab.UdemyToDoRestApi.model.TaskGroupsRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequestScope
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final TaskGroupsRepository repository;

    public ProjectService(ProjectRepository projectRepository, TaskGroupsRepository repository) {
        this.projectRepository = projectRepository;
        this.repository = repository;
    }

    public List<Project> findAll(){
        return projectRepository.findAll();
    }

    public Project creatProject(Project source){
        return projectRepository.save(source);
    }

//    public TaskGroups createGroup(int projectId, LocalDateTime deadline){
//        projectRepository.findById(projectId).stream()
//                .map(project -> project.)
//    }
}
