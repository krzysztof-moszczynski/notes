package com.todo.notes.exception;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(Long id) {
        super("The task of id " + id + " doesn't exist!");
    }
    
}
