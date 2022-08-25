package pl.coderslab.UdemyToDoRestApi;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("task")
public class TaskConfigurationProperties {

    private boolean allowMultipleTasksFromTemplate;

    public boolean isAllowMultipleTasksFromTemplate() {
        return allowMultipleTasksFromTemplate;
    }

    public void setTaskAllowMultipleTasksFromTemplate(boolean allowMultipleTasksFromTemplate) {
        this.allowMultipleTasksFromTemplate = allowMultipleTasksFromTemplate;
    }
}
