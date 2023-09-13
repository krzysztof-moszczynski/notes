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
@Controller
@RequestMapping("/")
public class GUIController {
    @Autowired
    TaskService taskService;
    @Autowired
    NoteService noteService;

    @GetMapping("")
    public String getNotesList(Model notesTasks) {
        notesTasks.addAttribute("notesTasks", noteService.getNotesTasks());
        return "notes";
    }
}
