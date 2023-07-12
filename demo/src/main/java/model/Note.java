/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author krzysztof
 */

import java.util.ArrayList;

public class note {
    private String name;
    private ArrayList<task> tasks;
    
    public note(String name) {
        this.name = name;
        this.tasks = new ArrayList<task>();
        //note newNote = new note(name, tasks);
    }
    
    public String getName() {
        return this.name;
    }
    
    //compare to reName below - both seem to do the same job
    public void setName(String name) {
        this.name = name;
    }
    
    public void reName(String newName) {
        this.name = newName;
    }
    
    public void addTask(task taskName){
        tasks.add(taskName);
    }
    
    public void rmTask(task taskName) {
        tasks.remove(taskName);
    }
    
    public String getTasks() {
        String result = "";
        for(task everyTask: tasks) {
            //result = result + everyTask.getName() + ": " + everyTask.getDesc() + "\n";
            result = result + everyTask.getDesc() + "\n";
        }
        return result;
    }
    
} 
