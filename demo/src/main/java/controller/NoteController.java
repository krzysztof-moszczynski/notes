/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.note;
import model.task;
import view.noteView;

/**
 *
 * @author krzysztof
 */
class noteController {
    private note model;
    private noteView view;
    
    public noteController(note model, noteView view) {
        this.model = model;
        this.view = view;
    }
    
    public String getName() {
        return model.getName();
    }
    
    //compare to reName below - both seem to do the same job
    public void setName(String name) {
        model.setName(name);
    }
    
    public void reName(String name) {
        model.reName(name);
    }
    
    public void addTask(task newTask) {
        model.addTask(newTask);
    }
    
    public void rmTask(task Task) {
        model.rmTask(Task);
    }
    
    public String getTasks() {
        return model.getTasks();
    }
    
    public void updateView() {
        view.printNote(model.getName(), model.getTasks());
    }
}
