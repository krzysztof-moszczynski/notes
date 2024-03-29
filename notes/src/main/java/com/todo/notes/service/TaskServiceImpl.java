package com.todo.notes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.notes.entity.Task;
import com.todo.notes.exception.TaskNotFoundException;
import com.todo.notes.repository.NoteRepository;
import com.todo.notes.repository.TaskRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service

//Service implementation
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    NoteRepository noteRepository;

    @Override
    public Task getTask(Long id) {
        // Optional use to manage case when id can or can't be found in repo
        Optional<Task> task = taskRepository.findById(id);
        return unwrapTask(task, id);
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        Task uwrappedTask = getTask(id);
        taskRepository.deleteById(uwrappedTask.getId());
    }

    public List<Task> getTasks() {
        return (List<Task>) taskRepository.findAll();
    }

    static Task unwrapTask(Optional<Task> entity, Long id) {// throws Exception {
        if (entity.isPresent())
            return entity.get();
        else
            throw new TaskNotFoundException(id);
    }

}
