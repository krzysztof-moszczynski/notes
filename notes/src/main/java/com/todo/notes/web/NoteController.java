package com.todo.notes.web;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.notes.entity.Note;
import com.todo.notes.entity.Task;
import com.todo.notes.service.NoteService;
import com.todo.notes.exception.ErrorResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;


@AllArgsConstructor
//Rest controller for notes
@RestController
//Path for API notes
@RequestMapping("/api/note")
//Swagger tag for notes
@Tag(name = "Note Controller", description = "Create and retirve notes")
public class NoteController {
    
    NoteService noteService;

    //Get all notes
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    //Swagger documentation
    @Operation(summary = "Retrives notes", description = "Provides a list of notes")
    //Swagger response
    @ApiResponse(responseCode = "200", description = "Successful retrieval of notes", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Note.class))))
    //Get all notes
    public ResponseEntity<List<Note>> getNotes() {
        return new ResponseEntity<>(noteService.getNotes(), HttpStatus.OK);
    }

    //Get note by id
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    //Swagger documentation
    @Operation(summary = "Retrives note by id", description = "Returns a note based on an ID")
    //Swagger response
    @ApiResponses(value = {
    @ApiResponse(responseCode = "404", description = "Note doesn't exist", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
    @ApiResponse(responseCode = "200", description = "Successful retrieval of note", content = @Content(schema = @Schema(implementation = Note.class))),
    })
    //Get note by id
    public ResponseEntity<Note> getNote(@PathVariable Long id) {
        return new ResponseEntity<>(noteService.getNote(id), HttpStatus.OK);
    }

    //Save note
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    //Swagger documentation
    @Operation(summary = "Save note", description = "Save a note into the repository")
    //Swagger response
    @ApiResponses(value = {
    @ApiResponse(responseCode = "201", description = "Successful creation of note"),
    @ApiResponse(responseCode = "400", description = "Bad request: unsuccessful submission", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    //Save note
    public ResponseEntity<Note> saveNote(@RequestBody Note note) {
        return new ResponseEntity<>(noteService.saveNote(note), HttpStatus.CREATED); 
    }
    
    //Delete note by id
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    //Swagger documentation
    @ApiResponses(value = {
    //Swagger response
    @ApiResponse(responseCode = "204", description = "Successful deletion of task"),
    @ApiResponse(responseCode = "400", description = "Bad request: unsuccessful submission", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    //Swagger description
    @Operation(summary = "Delete note by id", description = "Delete a note based on an ID")

    //Delete note by id
    public ResponseEntity<HttpStatus> deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //Get tasks from note
    @GetMapping(value = "/{id}/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
    //Swagger documentation
    @ApiResponse(responseCode = "200", description = "Successful retrieval of note's tasks", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Note.class))))
    @Operation(summary = "Retrives tasks of note", description = "Provides a list of tasks of a note's ID")
    //Get tasks from note
    public ResponseEntity<Set<Task>> getTasksFromNote(@PathVariable Long id) {
        return new ResponseEntity<>(noteService.getTasksFromNote(id), HttpStatus.OK);
    }
    
    //Add task to note
    @PostMapping(value = "/{noteId}/task/{taskId}", produces = MediaType.APPLICATION_JSON_VALUE)
    //Swagger documentation
    @ApiResponses(value = {
    @ApiResponse(responseCode = "201", description = "Successful addition of task to the note"),
    @ApiResponse(responseCode = "400", description = "Bad request: unsuccessful submission", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @Operation(summary = "Add task to note", description = "Add task to note of a given ID")
    //Add task to note
    public ResponseEntity<Task> addTaskToNote(@PathVariable Long noteId, @PathVariable Long taskId) throws Exception {
        noteService.addTaskToNote(taskId, noteId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //Get notes and their tasks
    @GetMapping(value ="/getNotesTasks", produces = MediaType.APPLICATION_JSON_VALUE)
    //Swagger documentation
    @ApiResponse(responseCode = "200", description = "Successful retrieval of notes", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Note.class))))
    @Operation(summary = "Retrives notes and their tasks", description = "Provides a list of notes including tasks")
    //Get notes and their tasks
    public ResponseEntity<HashMap<Note, Set<Task>>> getNotesTasks() {
        return new ResponseEntity<HashMap<Note, Set<Task>>>(noteService.getNotesTasks(), HttpStatus.OK);
    }
    
}
