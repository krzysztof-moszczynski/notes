package com.todo.notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.todo.notes.entity.Note;
import com.todo.notes.entity.Task;
import com.todo.notes.repository.NoteRepository;
import com.todo.notes.repository.TaskRepository;

//Main class of the application
@SpringBootApplication
//CommandLineRunner interface implementation used to populate
//exemplary data 
public class NotesApplication implements CommandLineRunner{

	@Autowired
	TaskRepository taskRepository;

	@Autowired
	NoteRepository noteRepository;

	public static void main(String[] args) {
		SpringApplication.run(NotesApplication.class, args);
	}

	@Override
    //Data population
	public void run(String ...args) throws Exception{
        //list of notes
		Note[] notes = new Note[] {
        new Note ("at uni"),
        new Note ("at home")
		};

        //saving notes to the repository 
		for (Note note: notes) {
			noteRepository.save(note);
		}

        //list of tasks
		Task[] tasks = new Task[] {
            new Task("go to library"),
            new Task("workout"),
            new Task("CS50 certificate")
		};

        //saving tasks to the repository
		for(Task task : tasks) {
			taskRepository.save(task);
		}
	}

}
