/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.task;
import view.taskView;

/**
 *
 * @author krzysztof
 */
class taskController {
    private task model;
    private taskView view;
    
    public taskController(task model, taskView view) {
        this.model = model;
        this.view = view;
    }
    
    public void setName(String name) {
        model.setName(name);
    }
    
    public void setDesc(String desc) {
        model.setDesc(desc);
    }
    
    public String getName() {
        return model.getName();
    }
    
    public String getDesc() {
        return model.getDesc();
    }
    
    public void updateView() {
        view.printTask(model.getName(), model.getDesc());
    }
    
}
