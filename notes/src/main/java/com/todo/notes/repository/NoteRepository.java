package com.todo.notes.repository;

import org.springframework.data.repository.CrudRepository;

import com.todo.notes.entity.Note;

public interface NoteRepository extends CrudRepository<Note, Long>{
    
}
