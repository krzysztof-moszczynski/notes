package com.todo.notes.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.todo.notes.service.NoteService;
import com.todo.notes.service.TaskService;

import lombok.AllArgsConstructor;

@AllArgsConstructor

//Controller for GUI
@Controller
//Mapping for GUI
@RequestMapping("/")
public class GUIController {

    //Autowired for TaskService and NoteService
    @Autowired
    TaskService taskService;
    @Autowired
    NoteService noteService;

    //Mapp for main page 
    @GetMapping("")
    public String getNotesList(Model notesTasks) {
        //Add attribute notesTasks to model
        notesTasks.addAttribute("notesTasks", noteService.getNotesTasks());
        //Return notes.html template
        return "notes";
    }
}
