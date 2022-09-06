package pl.coderslab.UdemyToDoRestApi.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.UdemyToDoRestApi.model.ProjectRepository;
import pl.coderslab.UdemyToDoRestApi.model.TaskGroupsRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TempService {
    private final Logger logger = LoggerFactory.getLogger(TempService.class);

    @Autowired
    //FIXME N+1
    public List<String> temp(TaskGroupsRepository taskGroupsRepository){
         return taskGroupsRepository.findAll().stream()
                .flatMap(taskGroups -> taskGroups.getTasks().stream())
                .map(task -> task.getDescription())
                 .peek(s -> logger.warn("description: " + s))
                .collect(Collectors.toList());
    }

    @Autowired
    public List<String> tempProjects(ProjectRepository projectRepository){
        return projectRepository.findAll().stream()
                .map(project -> project.getDescription())
                .collect(Collectors.toList());
    }

//    @Autowired
//    public List<String> temp2(TaskGroupsRepository taskGroupsRepository){
//        return taskGroupsRepository.findAllByDoneIsFalseAndProjectsId(1).stream()
//                .map(taskGroups -> taskGroups.getDescription())
//                .peek(s -> logger.warn("description: " + s))
//                .collect(Collectors.toList());
//    }
}
