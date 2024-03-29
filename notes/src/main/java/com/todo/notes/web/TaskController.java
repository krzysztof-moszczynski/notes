package com.todo.notes.web;

import java.util.List;

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

import com.todo.notes.entity.Task;
import com.todo.notes.exception.ErrorResponse;
import com.todo.notes.service.TaskService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
//Rest controller for tasks
@RestController
//Path for API tasks
@RequestMapping("/api/task")
//Swagger tag for tasks
@Tag(name = "Task Controller", description = "Create and retirve tasks")
public class TaskController {

    TaskService taskService;

    //Get all tasks
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    //Swagger documentation
    @Operation(summary = "Retrives tasks", description = "Provides a list of tasks")
    //Swagger response
    @ApiResponse(responseCode = "200", description = "Successful retrieval of notes", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Task.class))))
    //Get all tasks
    public ResponseEntity<List<Task>> getTasks() {
        return new ResponseEntity<>(taskService.getTasks(), HttpStatus.OK);
    }

    //Get task by id
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    //Swagger documentation
    @ApiResponses(value = {
    //Swagger response
    @ApiResponse(responseCode = "404", description = "Task doesn't exist", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
    @ApiResponse(responseCode = "200", description = "Successful retrieval of note", content = @Content(schema = @Schema(implementation = Task.class))),
    })
    @Operation(summary = "Retrives task by id", description = "Returns a task based on an ID")
    //Get task by id
    public ResponseEntity<Task> getTask(@PathVariable Long id) {
        return new ResponseEntity<>(taskService.getTask(id), HttpStatus.OK);
    }
    
    //Save task
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    //Swagger documentation
    @ApiResponses(value = {
    @ApiResponse(responseCode = "201", description = "Successful creation of task"),
    @ApiResponse(responseCode = "400", description = "Bad request: unsuccessful submission", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @Operation(summary = "Save task", description = "Save a task into the repository")
    //Save task
    public ResponseEntity<Task> saveTask(@Valid @RequestBody Task task) {
        return new ResponseEntity<>(taskService.saveTask(task), HttpStatus.CREATED);
    }

    //Delete task by id
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    //Swagger documentation
    @ApiResponses(value = {
    @ApiResponse(responseCode = "204", description = "Successful deletion of task"),
    @ApiResponse(responseCode = "400", description = "Bad request: unsuccessful submission", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @Operation(summary = "Delete task by id", description = "Delete a task based on an ID")
    //Delete task by id
    public ResponseEntity<HttpStatus> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    
}
