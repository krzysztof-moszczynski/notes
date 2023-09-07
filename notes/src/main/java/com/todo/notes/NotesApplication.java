package com.todo.notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.todo.notes.entity.Note;
import com.todo.notes.entity.Task;
import com.todo.notes.repository.NoteRepository;
import com.todo.notes.repository.TaskRepository;

@SpringBootApplication
public class NotesApplication implements CommandLineRunner{

	@Autowired
	TaskRepository taskRepository;

	@Autowired
	NoteRepository noteRepository;

	public static void main(String[] args) {
		//SpringApplication.run(NotesApplication.class, args);
		SpringApplication.run(NotesApplication.class, args);
	}

	@Override
	public void run(String ...args) throws Exception{
        Note note = new Note("note1");
		noteRepository.save(note);

		Task[] tasks = new Task[] {
            new Task("go to gym"),
            new Task("go to uni"),
            new Task("go to hell")
		};

		for(Task task : tasks) {
			taskRepository.save(task);
		}
	}

}
