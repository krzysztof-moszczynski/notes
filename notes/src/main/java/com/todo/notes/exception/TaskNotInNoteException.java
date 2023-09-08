package com.todo.notes.exception;

public class TaskNotInNoteException extends RuntimeException {
    public TaskNotInNoteException(Long noteId, Long taskId) {
        super("Task of id " + taskId + " doesn't exsist in note of id " + noteId + " !");
    }
}
