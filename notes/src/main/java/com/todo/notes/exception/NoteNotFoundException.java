package com.todo.notes.exception;

public class NoteNotFoundException extends RuntimeException {
    public NoteNotFoundException(Long id) {
        super("The note of id " + id + " doesn't exist!");
    }    

}
