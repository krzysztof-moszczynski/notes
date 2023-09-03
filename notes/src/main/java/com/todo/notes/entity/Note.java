package com.todo.notes.entity;

import java.util.ArrayList;

public class Note {
    private String title;
    private ArrayList<Task> tasks;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public void addTask(Task task) {
        tasks.add(task);
    } 

    public void removeTask(Task task) {
        tasks.remove(task);
    }
}
