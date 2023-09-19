package com.todo.notes.repository;

import org.springframework.data.repository.CrudRepository;

import com.todo.notes.entity.Task;

//This will be IMPLEMENTED by TaskService into a Bean 
public interface TaskRepository extends CrudRepository<Task, Long>{
    
}
