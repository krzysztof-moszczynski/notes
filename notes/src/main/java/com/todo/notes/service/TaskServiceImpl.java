package com.todo.notes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.notes.entity.Task;
import com.todo.notes.repository.TaskRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    TaskRepository taskRepository;

    @Override
    public Task getTask(Long id) {
        //Optional use to manage case when id can or can't be found in repo 
        Optional<Task> task = taskRepository.findById(id);
        return task.get();
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    } 
    
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
    
    public List<Task> getTasks(){
        return (List<Task>) taskRepository.findAll();
    }

    static Task unwrapTask(Optional<Task> entity, Long Id) throws Exception {
        if(entity.isPresent()) return entity.get();
        else throw new Exception();
    }
}
