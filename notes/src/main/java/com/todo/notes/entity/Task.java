package com.todo.notes.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

//lombok annotations to generate boilerplate code
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter

//entity annotations for JPA
@Entity
//table annotation for JPA
@Table(name = "task")
//Task - entity class, represents a task in the database
//Task has a many to many relationship with Note
//Task is a POJO with getters and setters
public class Task {

    //JPA annotations for id, column, and generation strategy
    @Id
    //column annotation for JPA
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //not null and not blank annotations for validation
    @NotBlank
    @NonNull
    //column annotation for JPA
    @Column(name = "activity", nullable = false)
    private String activity;
    
    //json ignore annotation to prevent infinite recursion
    @JsonIgnore
    //many to many annotation for JPA
    @ManyToMany
    //join table annotation for new table containing foreign keys
    @JoinTable(
        name = "note_task",
        joinColumns = @JoinColumn(name = "task_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "note_id", referencedColumnName = "id")
    )
    private List<Note> notes;

}
