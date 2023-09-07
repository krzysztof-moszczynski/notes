package com.todo.notes.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.notes.entity.Task;
import com.todo.notes.service.TaskService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/task")
public class TaskController {

    TaskService taskService;

    @GetMapping("/all")
    public ResponseEntity<List<Task>> getTasks() {
        return new ResponseEntity<>(taskService.getTasks(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id) {
        return new ResponseEntity<>(taskService.getTask(id), HttpStatus.OK);
    }

    
}
