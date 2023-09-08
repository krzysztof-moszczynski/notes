package com.todo.notes.service;

import java.util.List;

import com.todo.notes.entity.Note;
import com.todo.notes.entity.Task;

public interface NoteService {
    Note getNote(Long id);   
    Note saveNote(Note note);
    Task addTaskToNote(Long taskId, Long noteId)throws Exception;
    void deleteNote(Long id);
    List<Note> getNotes();
    List<Task> getTasksFromNote(Long id);
}
