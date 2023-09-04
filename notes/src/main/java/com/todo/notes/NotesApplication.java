package com.todo.notes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.todo.notes.entity.Note;
import com.todo.notes.entity.Task;

@SpringBootApplication
public class NotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotesApplication.class, args);

	    Note note1 = new Note("My first note");

	    Task task1 = new Task("Go to gym");
	    Task task2 = new Task("Go to dentist");
	    Task task3 = new Task("Go to hell");

		note1.addTask(task1);
		note1.addTask(task2);
		note1.addTask(task3);
	
		System.out.println(note1);
	}

}
