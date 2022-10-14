package pl.coderslab.UdemyToDoRestApi.logic;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import pl.coderslab.UdemyToDoRestApi.TaskConfigurationProperties;
import pl.coderslab.UdemyToDoRestApi.model.*;
import pl.coderslab.UdemyToDoRestApi.model.projection.GroupReadModel;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequestScope
public class ProjectService {
    private final ProjectRepository repository;
    private final TaskGroupsRepository taskGroupsRepository;
    private final TaskConfigurationProperties configuration;

    public ProjectService(ProjectRepository repository, TaskGroupsRepository taskGroupsRepository, TaskConfigurationProperties configuration) {
        this.repository = repository;
        this.taskGroupsRepository = taskGroupsRepository;
        this.configuration = configuration;
    }

    public List<Project> readAll(){
        return repository.findAll();
    }

    public Project save(Project source){
        return repository.save(source);
    }

    public GroupReadModel createGroup(int projectId, LocalDateTime deadline){
        if (!configuration.getTemplate().isAllowMultipleTasks()&&taskGroupsRepository.existsByDoneIsFalseAndProjectId(projectId)) {
            throw new IllegalStateException("Only one undone group from project is allowed");
        }
        TaskGroups result = repository.findById(projectId).map(project -> {
            TaskGroups taskGroup = new TaskGroups();
            taskGroup.setDescription(project.getDescription());
            taskGroup.setTasks(project.getSteps().stream()
                    .map(projectStep ->
                            new Task(projectStep.getDescription(), deadline.plusDays(projectStep.getDaysToDeadline()))
                    ).collect(Collectors.toSet()));
            return taskGroup;
        }).orElseThrow(() -> new IllegalArgumentException("Project with given id not found"));
        return new GroupReadModel(result);
    }

}
