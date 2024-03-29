package com.todo.notes;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.todo.notes.entity.Task;
import com.todo.notes.repository.TaskRepository;
import com.todo.notes.service.TaskServiceImpl;

//MockitoJUnitRunner.class - initializes mocks annotated with Mockito annotations and
// enables the usage of Mockito annotations to be used in the test code.
@RunWith(MockitoJUnitRunner.class)
public class TaskServiceImplTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskServiceImpl taskServiceImpl;

    //TODO - refactor to avoid repeting of declaration List<Task> tasks, @BeforeEach? 

    @Test
    //Simple unit test to check if the method returns the expected task
    public void getTaskFromRepo() {
        List<Task> tasks = Arrays.asList(
            new Task("go to gym"),
            new Task("go to uni"),
            new Task("go to hell")
        );
    
        Optional<Task> expectedTask = Optional.of(tasks.get(0));
        when(taskRepository.findById(Long.valueOf(1))).thenReturn(expectedTask);
        Optional<Task> actualTask = Optional.of(taskServiceImpl.getTask(Long.valueOf(1)));
        assertEquals(expectedTask, actualTask);
    }

    @Test
    //Simple unit test to check if the method saves the task to the repo
    public void saveTaskToRepo() {
        Task taskToSave = new Task("go to hell");
        taskServiceImpl.saveTask(taskToSave);
        verify(taskRepository, times(1)).save(taskToSave);
    }

    @Test
    //Simple unit test to check if the method deletes the task from the repo
    public void deleteTaskFromRepo() {
        List<Task> tasks = Arrays.asList(
            new Task("go to gym"),
            new Task("go to uni"),
            new Task("go to hell")
        );

        Task taskToDelete = tasks.get(0);
        taskServiceImpl.deleteTask(taskToDelete.getId());
        verify(taskRepository, times(1)).deleteById(taskToDelete.getId());

    }

    @Test
    //Simple unit test to check if the method returns the expected tasks
    public void getTasksFromRepo() {
        List<Task> expectedTasks = Arrays.asList(
            new Task("go to gym"),
            new Task("go to uni"),
            new Task("go to hell")
        );

        when(taskRepository.findAll()).thenReturn(expectedTasks);
        List<Task> actual_tasks = taskServiceImpl.getTasks(); 
        assertEquals(expectedTasks, actual_tasks);
    }
}
