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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "task")

public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NonNull
    @Column(name = "activity", nullable = false)
    private String activity;
    
    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "note_task",
        joinColumns = @JoinColumn(name = "task_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "note_id", referencedColumnName = "id")
    )
    private List<Note> notes;

}
