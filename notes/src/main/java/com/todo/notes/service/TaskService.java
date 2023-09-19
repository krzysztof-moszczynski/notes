package com.todo.notes.service;

import java.util.List;

import com.todo.notes.entity.Task;

//Basic logic for the Task CRUD operations
public interface TaskService {
   Task getTask(Long id); 
   Task saveTask(Task task);
   void deleteTask(Long id);
   List<Task> getTasks();
}
