package com.todo.notes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.notes.entity.Note;
import com.todo.notes.repository.NoteRepository;
import com.todo.notes.repository.TaskRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NoteServiceImpl implements NoteService {

     @Autowired
     TaskRepository taskRepository;

     @Autowired
     NoteRepository noteRepository;

     public Note getNote(Long Id) {
          Optional<Note> note = noteRepository.findById(Id);
          return note.get();
     }

     public Note saveNote(Note note) {
          return noteRepository.save(note);
     }

     public void deleteNote(Long id) {
          noteRepository.deleteById(id);
     }

     public List<Note> getNotes() {
          return (List<Note>) noteRepository.findAll();
     }

     //Optional object management
     /* 
     static Task unwrapTask(Optional<Task> entity, Long id) throws Exception {
          if(entity.isPresent()) return entity.get();
          else throw new Exception();
     }
     */

    static Note unwrapNote(Optional<Note> entity, Long Id) throws Exception {
        if (entity.isPresent())
            return entity.get();
        else
            throw new Exception();
    }
}
