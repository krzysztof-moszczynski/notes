package com.todo.notes.entity;

import java.util.List;

import org.aspectj.lang.annotation.RequiredTypes;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
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
@Table(name = "note")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @NonNull
    @Column(name = "title")
    private String title;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "note_task",
        joinColumns = @JoinColumn(name = "note_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "task_id", referencedColumnName = "id")
    )
    private List<Task> tasks;
}
