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

import com.neotasker.utils.Constants;

/**
 * The task class is responsible for holding the data regarding tasks.
 */
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    /**
     * Instantiate an empty task.
     */
    public Task() {
        super();
    }

    /**
     * Instantiate a task and fill it with a title.
     *
     * @param title the title for the task.
     */
    public Task(String title) {
        super();
        this.title = title;
        this.description = null;
        this.dateCreation = LocalDateTime.now();
        this.dateCompletion = null;
        this.dateDue = null;
        this.status = TaskState.UNFINISHED;
    }

    /**
     * Instantiate a task with a title and a due date.
     *
     * @param title the title for the task.
     * @param dateDue the due date for the task.
     */
    public Task(String title, LocalDateTime dateDue) {
        super();
        this.title = title;
        this.description = null;
        this.dateCreation = LocalDateTime.now();
        this.dateCompletion = null;
        this.dateDue = dateDue;
        this.status = TaskState.UNFINISHED;
    }
    
    /**
     * Instantiate a task with a title and a description
     *
     * @param title the title for the task.
     * @param description the description for the task.
     */
    public Task(String title, String description) {
        super();
        this.title = title;
        this.description = description;
        this.dateCreation = LocalDateTime.now();
        this.dateCompletion = null;
        this.dateDue = null;
        this.status = TaskState.UNFINISHED;
    }

    /**
     * Instantiate a task with a title, description and a due date.
     *
     * @param title the title for the task.
     * @param description the description for the task.
     * @param dateDue the due date for the task.
     */
    public Task(String title, String description, LocalDateTime dateDue) {
        super();
        this.title = title;
        this.description = description;
        this.dateCreation = LocalDateTime.now();
        this.dateCompletion = null;
        this.dateDue = dateDue;
        this.status = TaskState.UNFINISHED;
    }

    /**
     * Task id setter.
     *
     * @param id the identifier for the task.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Task id getter.
     *
     * @return the identifier for the task.
     */
    public long getId() {
        return id;
    }

    /**
     * Task title setter.
     *
     * @param title the title for the task.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Task title getter.
     *
     * @return the title for the task.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Task description setter.
     *
     * @param description the description for the task.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Task description getter.
     *
     * @return the description for the task.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Task creation date setter.
     *
     * @param dateCreation the date in localtime for the task.
     */
    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    /**
     * Task creation date getter.
     *
     * @return the date in localtime for the task.
     */
    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    /**
     * Task completion date setter.
     *
     * @param dateCompletion the completion date for the task.
     */
    public void setDateCompletion(LocalDateTime dateCompletion) {
        this.dateCompletion = dateCompletion;
    }

    /**
     * Task completion date getter.
     *
     * @return the completion date for the task.
     */
    public LocalDateTime getDateCompletion() {
        return dateCompletion;
    }

    /**
     * Task due date setter.
     *
     * @param dateDue the due date for the task.
     */
    public void setDateDue(LocalDateTime dateDue) {
        this.dateDue = dateDue;
    }

    /**
     * Task due date getter.
     *
     * @return the due date for the task.
     */
    public LocalDateTime getDateDue() {
        return dateDue;
    }

    /**
     * Task completion status setter.
     *
     * @param status the completion status for the task.
     */
    public void setStatus(TaskState status) {
        this.status = status;
    }

    /**
     * Task completion status getter.
     *
     * @return the completion status for the task.
     */
    public TaskState getStatus() {
        return status;
    }

    /**
     * Task tag setter.
     *
     * @param tags the tags to be set for the task.
     */
    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    /**
     * Task tag getter.
     *
     * @return the tags set for the task.
     */
    public Set<Tag> getTags() {
        return tags;
    }
}

enum TaskState {
    UNFINISHED,
    FINISHED,
    LATE,
}

