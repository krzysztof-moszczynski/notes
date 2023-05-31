/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author krzysztof
 */

class notesContainer {
    private String name;
    private ArrayList<note> Notes;
    
    public notesContainer(String name) {
        this.name = name;
        this.Notes = new ArrayList<>();
    }
    
    public void addNote(note Note) {
        this.Notes.add(Note);
    }
    
    public void rmNote(note Note) {
        this.Notes.remove(Note);
    }
    
    public String getNotes() {
        String result = "";
        for(note Note: Notes) {
            result = result + Note;
        }
        
        return result;
    }
    
    public int numberNotes() {
        return Notes.size();
    }
}

