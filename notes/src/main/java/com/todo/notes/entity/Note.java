package com.todo.notes.entity;

import java.util.Set;

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
@Table(name = "note")
//Note - entity class, represents a note in the database
//Note has a many to many relationship with Task
//Note is a POJO with getters and setters
public class Note {

    //JPA annotations for id, column, and generation strategy
    @Id
    //column annotation for JPA
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    //not null and not blank annotations for validation
    @NotBlank
    @NonNull
    //column annotation for JPA
    @Column(name = "title")
    private String title;

    //json ignore annotation to prevent infinite recursion
    @JsonIgnore
    //many to many annotation for JPA
    @ManyToMany
    //join table annotation for new table containing foreign keys 
    @JoinTable(
        name = "note_task",
        joinColumns = @JoinColumn(name = "note_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "task_id", referencedColumnName = "id")
    )
    private Set<Task> tasks;
}
