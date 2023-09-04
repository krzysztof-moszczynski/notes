package com.todo.notes.repository;

import org.springframework.data.repository.CrudRepository;

import com.todo.notes.entity.Task;

public interface TaskRepository extends CrudRepository<Task, Long>{
    
}
