package com.todo.notes.service;

import java.util.List;

import com.todo.notes.entity.Note;

public interface NoteService {
    Note getNote(Long id);   
    Note saveNote(Note note);
    void deleteNote(Long id);
    //Note addTaskToNote(Long taskId, Long noteId) throws Exception;
    List<Note> getNotes();
}
