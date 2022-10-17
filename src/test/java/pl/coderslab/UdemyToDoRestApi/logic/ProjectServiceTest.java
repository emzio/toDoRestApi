package pl.coderslab.UdemyToDoRestApi.logic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.coderslab.UdemyToDoRestApi.TaskConfigurationProperties;
import pl.coderslab.UdemyToDoRestApi.model.ProjectRepository;
import pl.coderslab.UdemyToDoRestApi.model.TaskGroups;
import pl.coderslab.UdemyToDoRestApi.model.TaskGroupsRepository;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProjectServiceTest {
//        when + then
//        assertThatThrownBy(() -> toTest.createGroup(0, LocalDateTime.now()))
//                .isInstanceOf(IllegalStateException.class);
//        assertThatExceptionOfType(IllegalStateException.class)
//                .isThrownBy(() -> toTest.createGroup(0, LocalDateTime.now()));

    @Test
    @DisplayName("should throw IllegalStateException when configured to allow just 1 group and the other undone group exists")
    void createGroup_noMultipleGroupsConfig_And_undoneGroupExists_throwsIllegalStateException() {
//        given
        var mockGroupRepository = groupRepositoryReturning(true);
//         and
        TaskConfigurationProperties mockConfig = configurationReturning(false);
//        system under test
        var toTest = new ProjectService(null, mockGroupRepository, mockConfig);
//        when
        var exception = catchThrowable(() -> toTest.createGroup(0, LocalDateTime.now()));
//        then
        assertThat(exception)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("one undone");
    }

    @Test
    @DisplayName("should throw IllegalArgumentException when configuration ok and no projects for a given id")
    void createGroup_configurationOk_And_noProjects_throwsIllegalArgumentException() {
//        given
        var mockRepository = mock(ProjectRepository.class);
        when(mockRepository.findById(anyInt())).thenReturn(Optional.empty());
//        and
        TaskConfigurationProperties mockConfig = configurationReturning(true);
//        system under test
        var toTest = new ProjectService(mockRepository, null, mockConfig);
//        when
        var exception = catchThrowable(() -> toTest.createGroup(0, LocalDateTime.now()));
//        then
        assertThat(exception)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("id not found");
    }

    @Test
    @DisplayName("should throw IllegalArgumentException when configured to allow just 1 group and no groups and projects for a given id")
    void createGroup_noMultipleGroupsConfig_And_undoneGroupExists_And_noProjects_throwsIllegalArgumentException() {
//        given
        var mockRepository = mock(ProjectRepository.class);
        when(mockRepository.findById(anyInt())).thenReturn(Optional.empty());
//         and
        TaskConfigurationProperties mockConfig = configurationReturning(false);
//        and
        var mockGroupsRepository = groupRepositoryReturning(false);
//        system under test
        var toTest = new ProjectService(mockRepository, mockGroupsRepository, mockConfig);
//        when
        var exception = catchThrowable(() -> toTest.createGroup(0, LocalDateTime.now()));
//        then
        assertThat(exception)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("id not found");
    }

    @Test
    @DisplayName("should create new group from project")
    void createGroup_configurationOk_existingProject_createsAndSavesGroup(){
        // given
        var mockRepository = mock(ProjectRepository.class);
        when(mockRepository.findById(anyInt())).thenReturn(Optional.empty());
//         and
        TaskConfigurationProperties mockConfig = configurationReturning(true);
    }

    private static TaskGroupsRepository groupRepositoryReturning(boolean result) {
        var mockGroupRepository = mock(TaskGroupsRepository.class);
        when(mockGroupRepository.existsByDoneIsFalseAndProjectId(anyInt())).thenReturn(result);
        return mockGroupRepository;
    }

    private static TaskConfigurationProperties configurationReturning(boolean value) {
        var mockTemplate = mock(TaskConfigurationProperties.Template.class);
        when(mockTemplate.isAllowMultipleTasks()).thenReturn(value);
//        and
        var mockConfig = mock(TaskConfigurationProperties.class);
        when(mockConfig.getTemplate()).thenReturn(mockTemplate);
        return mockConfig;
    }

    private TaskGroupsRepository inMemoryGroupRepository(){
        return new TaskGroupsRepository() {
            Map<Integer, TaskGroups> groupsMap = new HashMap<>();
            Integer index = 0;

            @Override
            public List<TaskGroups> findAll() {
                return new ArrayList<>(groupsMap.values());
            }

            @Override
            public Optional<TaskGroups> findById(Integer integer) {
                return Optional.ofNullable(groupsMap.get(integer));
            }

            @Override
            public TaskGroups save(TaskGroups entity) {
                if (entity.getId() == 0){
                    TaskGroups.class.getDeclaredField("id").set(index++);
                } else {
                    groupsMap.put(index, entity);
                }
                return entity;
            }

            @Override
            public boolean existsByDoneIsFalseAndProjectId(int projectId) {
                return false;
            }
        }
    }
}