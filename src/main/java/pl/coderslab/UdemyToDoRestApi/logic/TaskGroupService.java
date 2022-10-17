package pl.coderslab.UdemyToDoRestApi.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import pl.coderslab.UdemyToDoRestApi.model.TaskGroups;
import pl.coderslab.UdemyToDoRestApi.model.TaskGroupsRepository;
import pl.coderslab.UdemyToDoRestApi.model.TaskRepository;
import pl.coderslab.UdemyToDoRestApi.model.projection.GroupReadModel;
import pl.coderslab.UdemyToDoRestApi.model.projection.GroupWriteModel;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequestScope
public class TaskGroupService {
    private final Logger logger = LoggerFactory.getLogger(TaskGroupService.class);
    private final TaskGroupsRepository repository;
    private final TaskRepository taskRepository;

    public TaskGroupService(TaskGroupsRepository repository, TaskRepository taskRepository) {
        this.repository = repository;
        this.taskRepository = taskRepository;
    }


    public GroupReadModel create(GroupWriteModel source){
        TaskGroups result = repository.save(source.toGroup());
        return new GroupReadModel(result);
    }

    public List<GroupReadModel> readAll(){
        return repository.findAll().stream()
                .map(GroupReadModel::new)
                .collect(Collectors.toList());
    }

    public void toggleGroup(Integer groupId){
        if (taskRepository.existsByDoneIsFalseAndGroup_Id(groupId)) {
            throw new IllegalStateException("Group has undone tasks. Done all the tasks first.");
        }
        TaskGroups result = repository.findById(groupId)
                .orElseThrow(() -> new IllegalArgumentException("TaskGroup with given id not found."));
        result.setDone(!result.isDone());
        repository.save(result);
    }


//    @Autowired
//    //FIXME N+1
//    public List<String> temp(TaskGroupsRepository taskGroupsRepository){
//         return taskGroupsRepository.findAll().stream()
//                .flatMap(taskGroups -> taskGroups.getTasks().stream())
//                .map(task -> task.getDescription())
//                 .peek(s -> logger.warn("description: " + s))
//                .collect(Collectors.toList());
//    }
//
//    @Autowired
//    public List<String> tempProjects(ProjectRepository projectRepository){
//        return projectRepository.findAll().stream()
//                .map(project -> project.getDescription())
//                .collect(Collectors.toList());
//    }

//    @Autowired
//    public List<String> temp2(TaskGroupsRepository taskGroupsRepository){
//        return taskGroupsRepository.findAllByDoneIsFalseAndProjectsId(1).stream()
//                .map(taskGroups -> taskGroups.getDescription())
//                .peek(s -> logger.warn("description: " + s))
//                .collect(Collectors.toList());
//    }
}
