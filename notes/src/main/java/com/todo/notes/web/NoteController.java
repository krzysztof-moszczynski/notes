package com.todo.notes.web;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.notes.entity.Note;
import com.todo.notes.entity.Task;
import com.todo.notes.service.NoteService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@AllArgsConstructor
@RestController
@RequestMapping("/note")
public class NoteController {
    
    NoteService noteService;

    @GetMapping("/all")
    public ResponseEntity<List<Note>> getNotes() {
        return new ResponseEntity<>(noteService.getNotes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNote(@PathVariable Long id) {
        return new ResponseEntity<>(noteService.getNote(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Note> saveNote(@RequestBody Note note) {
        return new ResponseEntity<>(noteService.saveNote(note), HttpStatus.CREATED); 
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}/tasks")
    public ResponseEntity<Set<Task>> getTasksFromNote(@PathVariable Long id) {
        return new ResponseEntity<>(noteService.getTasksFromNote(id), HttpStatus.OK);
    }
    
    @PostMapping("/{noteId}/task/{taskId}")
    public ResponseEntity<Task> addTaskToNote(@PathVariable Long noteId, @PathVariable Long taskId) throws Exception {
        noteService.addTaskToNote(taskId, noteId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
