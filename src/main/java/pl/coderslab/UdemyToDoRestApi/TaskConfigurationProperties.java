package pl.coderslab.UdemyToDoRestApi;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("task")
public class TaskConfigurationProperties {

    private boolean taskAllowMultipleTasksFromTemplate;

    public boolean isTaskAllowMultipleTasksFromTemplate() {
        return taskAllowMultipleTasksFromTemplate;
    }

    public void setTaskAllowMultipleTasksFromTemplate(boolean taskAllowMultipleTasksFromTemplate) {
        this.taskAllowMultipleTasksFromTemplate = taskAllowMultipleTasksFromTemplate;
    }
}
