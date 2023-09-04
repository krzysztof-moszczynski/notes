package com.todo.notes.entity;

import java.util.List;
import java.util.ArrayList;

public class Note {
    private String title;
    private List<Task> tasks;

    public Note(String title) {
        this.title = title;
        tasks = new ArrayList<>();
    }

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

    public List<Task> getTasks() {
        return this.tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "{" +
            " title='" + getTitle() + "'" +
            ", tasks='" + getTasks() + "'" +
            "}";
    }

    /*
    @Override
    public String toString() {
        String result = "" ;
        result += title + "\n";;

        for(Task t: tasks) {
            result += t.getTask() + "\n";
        }

        return result;
    }
    */

}
