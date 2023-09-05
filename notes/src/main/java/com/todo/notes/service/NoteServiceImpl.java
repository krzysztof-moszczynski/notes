package com.todo.notes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.todo.notes.entity.Note;
import com.todo.notes.repository.NoteRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NoteServiceImpl implements NoteService {

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

}
