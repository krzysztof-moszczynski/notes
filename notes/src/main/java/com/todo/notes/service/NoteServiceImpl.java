package com.todo.notes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.notes.entity.Note;
import com.todo.notes.entity.Task;
import com.todo.notes.exception.NoteNotFoundException;
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

     @Autowired
     TaskServiceImpl taskServiceImpl;

     public Note getNote(Long Id) {
          Optional<Note> note = noteRepository.findById(Id);
          return unwrapNote(note, Id);
     }

     public Note saveNote(Note note) {
          return noteRepository.save(note);
     }

     public Task addTaskToNote(Long taskId, Long noteId) {// throws Exception {
          Task task = taskServiceImpl.getTask(taskId);
          Optional<Note> note = noteRepository.findById(noteId);
          Note unwrappedNote = unwrapNote(note, noteId);
          task.getNotes().add(unwrappedNote);
          return taskRepository.save(task);
     }

     public void deleteNote(Long id) {
          noteRepository.deleteById(id);
     }

     public List<Note> getNotes() {
          return (List<Note>) noteRepository.findAll();
     }

     public List<Task> getTasksFromNote(Long id) {
          Note note = getNote(id);
          return note.getTasks();
     }

     // Optional object management
     /*
      * static Task unwrapTask(Optional<Task> entity, Long id) throws Exception {
      * if(entity.isPresent()) return entity.get();
      * else throw new Exception();
      * }
      */

     static Note unwrapNote(Optional<Note> entity, Long id){
          if (entity.isPresent())
               return entity.get();
          else
               throw new NoteNotFoundException(id);
     }
}
