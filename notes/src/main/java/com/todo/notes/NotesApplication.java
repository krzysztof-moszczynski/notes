package com.todo.notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.todo.notes.repository.NoteRepository;
import com.todo.notes.repository.TaskRepository;

@SpringBootApplication
public class NotesApplication {

	@Autowired
	TaskRepository taskRepository;

	@Autowired
	NoteRepository noteRepository;

	public static void main(String[] args) {
		SpringApplication.run(NotesApplication.class, args);
	
	}

}
