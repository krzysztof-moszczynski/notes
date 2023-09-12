package com.todo.notes.service;

import java.util.List;
import java.util.HashMap;
import java.util.Set;

import com.todo.notes.entity.Note;
import com.todo.notes.entity.Task;

public interface NoteService {
    Note getNote(Long id);   
    Note saveNote(Note note);
    Task addTaskToNote(Long taskId, Long noteId);//throws Exception;
    void deleteNote(Long id);
    List<Note> getNotes();
    Set<Task> getTasksFromNote(Long id);
    HashMap<Note, Set<Task>> getNotesTasks();
}
