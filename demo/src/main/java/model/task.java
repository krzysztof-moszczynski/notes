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
public class task {
    private String name;
    private String desc;

    public task(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDesc() {
        return this.desc;
    }
    
    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    public void reName(String newName) {
        this.name = newName;
    }
    
    // mark taks as done 
    public boolean isDone(boolean done) {
        boolean state = done;
        return state;
    }
}
