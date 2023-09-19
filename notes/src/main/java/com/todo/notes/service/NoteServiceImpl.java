package com.todo.notes.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

//Service implementation
public class NoteServiceImpl implements NoteService {

     @Autowired
     TaskRepository taskRepository;

     @Autowired
     NoteRepository noteRepository;

     @Autowired
     TaskServiceImpl taskServiceImpl;

     @Override
     public Note getNote(Long Id) {
          Optional<Note> note = noteRepository.findById(Id);
          return unwrapNote(note, Id);
     }

     @Override
     public Note saveNote(Note note) {
          return noteRepository.save(note);
     }

     @Override
     public Task addTaskToNote(Long taskId, Long noteId) {// throws Exception {
          Task task = taskServiceImpl.getTask(taskId);
          Optional<Note> note = noteRepository.findById(noteId);
          Note unwrappedNote = unwrapNote(note, noteId);
          task.getNotes().add(unwrappedNote);
          return taskRepository.save(task);
     }

     @Override
     public void deleteNote(Long id) {
          Note unwrappedNote = getNote(id);
          noteRepository.deleteById(unwrappedNote.getId());
     }

     public List<Note> getNotes() {
          return (List<Note>) noteRepository.findAll();
     }

     @Override
     public Set<Task> getTasksFromNote(Long id) {
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

     @Override
     public HashMap<Note, Set<Task>> getNotesTasks() {
          HashMap<Note, Set<Task>> notesTasks = new HashMap<>();
          List<Note> notes = getNotes();
          
          for(Note note : notes) {
               //Set<Task> tasks = getTasksFromNote(note.getId());
              notesTasks.putIfAbsent(note, getTasksFromNote(note.getId()));
          }

          return notesTasks;
     }

     static Note unwrapNote(Optional<Note> entity, Long id){
          if (entity.isPresent())
               return entity.get();
          else
               throw new NoteNotFoundException(id);
     }

}
