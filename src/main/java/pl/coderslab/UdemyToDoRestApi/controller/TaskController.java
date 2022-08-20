package pl.coderslab.UdemyToDoRestApi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.UdemyToDoRestApi.model.Task;
import pl.coderslab.UdemyToDoRestApi.model.TaskRepository;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@RestController

class TaskController {
    private final Logger logger = LoggerFactory.getLogger(TaskController.class);
    private final TaskRepository taskRepository;

    TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @RequestMapping(method = RequestMethod.GET, path = "/tasks", params = {"!size","!page", "!sort"})
    ResponseEntity<?> readAllTasks(){
        logger.warn("Exposing all Tasks!");
        return ResponseEntity.ok(taskRepository.findAll());
    }

    @RequestMapping(method = RequestMethod.GET,path = "/tasks")
    ResponseEntity<List<Task>> readAllTasks(Pageable page){
        logger.warn("Exposing all Tasks!");
        return ResponseEntity.ok(taskRepository.findAll(page).getContent());
    }

    @PutMapping("/tasks/{id}")
    ResponseEntity<?> updateTask(@PathVariable int id, @RequestBody @Valid Task toUpdate){
        if (!taskRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        toUpdate.setId(id);
        taskRepository.save(toUpdate);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("tasks/{id}")
    ResponseEntity<Task> readTask(@PathVariable int id){
        return taskRepository.findById(id)
                .map(task -> ResponseEntity.ok(task))
                .orElse(ResponseEntity.notFound().build());
}

    @PostMapping("tasks")
    ResponseEntity<Task> createTask(@RequestBody @Valid Task task){
        Task resultTask = taskRepository.save(task);
        return ResponseEntity.created(URI.create("/" + resultTask.getId())).body(resultTask);
    }
}
