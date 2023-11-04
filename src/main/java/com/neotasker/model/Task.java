package com.neotasker.model;

import java.util.Set;
import java.util.TreeSet;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

import com.neotasker.util.Constants;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "task_id")
    private long id;

    @Column(name = "title", nullable = false, length = Constants.TITLE_SIZE)
    private String title;

    @Column(name = "description", nullable = true, length = Constants.DESCRIPTION_SIZE)
    private String description;

    @Column(name = "dt_creation", nullable = false, length = Constants.TIMESTAMP_SIZE)
    private LocalDateTime dateCreation;

    @Column(name = "dt_completion", nullable = true, length = Constants.TIMESTAMP_SIZE)
    private LocalDateTime dateCompletion;

    @Column(name = "dt_due", nullable = true, length = Constants.TIMESTAMP_SIZE)
    private LocalDateTime dateDue;

    @Column(name = "status", nullable = false)
    private TaskState status;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "tasks_tags",
        joinColumns = {@JoinColumn(name = "task_id")},
        inverseJoinColumns = {@JoinColumn(name = "tag_id")}
    )
    private Set<Tag> tags = new TreeSet<>();

    public Task() {
        super();
    }

    public Task(String title) {
        super();
        this.title = title;
        this.description = null;
        this.dateCreation = LocalDateTime.now();
        this.dateCompletion = null;
        this.dateDue = null;
        this.status = TaskState.UNFINISHED;
    }

    public Task(String title, LocalDateTime dateDue) {
        super();
        this.title = title;
        this.description = null;
        this.dateCreation = LocalDateTime.now();
        this.dateCompletion = null;
        this.dateDue = dateDue;
        this.status = TaskState.UNFINISHED;
    }
    
    public Task(String title, String description) {
        super();
        this.title = title;
        this.description = description;
        this.dateCreation = LocalDateTime.now();
        this.dateCompletion = null;
        this.dateDue = null;
        this.status = TaskState.UNFINISHED;
    }

    public Task(String title, String description, LocalDateTime dateDue) {
        super();
        this.title = title;
        this.description = description;
        this.dateCreation = LocalDateTime.now();
        this.dateCompletion = null;
        this.dateDue = dateDue;
        this.status = TaskState.UNFINISHED;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCompletion(LocalDateTime dateCompletion) {
        this.dateCompletion = dateCompletion;
    }

    public LocalDateTime getDateCompletion() {
        return dateCompletion;
    }

    public void setDateDue(LocalDateTime dateDue) {
        this.dateDue = dateDue;
    }

    public LocalDateTime getDateDue() {
        return dateDue;
    }

    public void setStatus(TaskState status) {
        this.status = status;
    }

    public TaskState getStatus() {
        return status;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Set<Tag> getTags() {
        return tags;
    }
}

enum TaskState {
    UNFINISHED,
    FINISHED,
    LATE,
}
