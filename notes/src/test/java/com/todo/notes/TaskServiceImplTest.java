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

import com.todo.notes.entity.Note;
import com.todo.notes.entity.Task;
import com.todo.notes.repository.TaskRepository;
import com.todo.notes.service.TaskServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class TaskServiceImplTest {


    @Mock
    private TaskRepository taskRepository;
    private Note note1;

    @InjectMocks
    private TaskServiceImpl taskServiceImpl;

    //TODO - refactor to avoid repeting of declaration List<Task> tasks, @BeforeEach? 

    @Test
    public void getTaskFromRepo() {
        List<Task> tasks = Arrays.asList(
            new Task(Long.valueOf(1), "go to the gym", note1),
            new Task(Long.valueOf(2), "go to uni", note1) 
        );
    
        Optional<Task> expectedTask = Optional.of(tasks.get(0));
        when(taskRepository.findById(Long.valueOf(1))).thenReturn(expectedTask);
        Optional<Task> actualTask = Optional.of(taskServiceImpl.getTask(Long.valueOf(1)));
        assertEquals(expectedTask, actualTask);
    }

    @Test
    public void saveTaskToRepo() {

        Task taskToSave = new Task(Long.valueOf(3), "go to hell", note1);
        taskServiceImpl.saveTask(taskToSave);
        verify(taskRepository, times(1)).save(taskToSave);
    }

    @Test
    public void deleteTaskFromRepo() {
        List<Task> tasks = Arrays.asList(
            new Task(Long.valueOf(1), "go to the gym", note1),
            new Task(Long.valueOf(2), "go to uni", note1) 
        );

        Task taskToDelete = tasks.get(0);
        taskServiceImpl.deleteTask(taskToDelete.getId());
        verify(taskRepository, times(1)).deleteById(taskToDelete.getId());

    }

    @Test
    public void getTasksFromRepo() {
        List<Task> expectedTasks = Arrays.asList(
            new Task(Long.valueOf(1), "go to the gym", note1),
            new Task(Long.valueOf(2), "go to uni", note1) 
        );

        when(taskRepository.findAll()).thenReturn(expectedTasks);
        List<Task> actual_tasks = taskServiceImpl.getTasks(); 
        assertEquals(expectedTasks, actual_tasks);
    }

}
