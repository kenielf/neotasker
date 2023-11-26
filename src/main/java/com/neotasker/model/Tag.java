package com.neotasker.model;

import java.util.Set;
import java.util.TreeSet;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import com.neotasker.utils.Constants;

/**
 * The tag class is responsible for holding the data regarding task tags.
 */
@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private long id;

    @Column(name = "label", nullable = false, length = Constants.LABEL_SIZE)
    private String label;

    @ManyToMany(mappedBy = "tags", cascade = CascadeType.ALL)
    private Set<Task> tasks = new TreeSet<>();

    /** Instantiate an empty tag */
    Tag() {
        super();
    }

    /** 
     * Instantiate a tag with a label 
     *
     * @param label the label for the tag.
     */
    Tag(String label) {
        super();
        this.label = label;
    }

    /**
     * Tag id setter.
     *
     * @param id the identifier for the tag.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Tag id getter.
     *
     * @return the identifier for the tag.
     */
    public long getId() {
        return id;
    }

    /**
     * Tag label setter.
     *
     * @param label the label for the tag.
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Tag label getter.
     *
     * @return the label for the tag.
     */
    public String getLabel() {
        return label;
    }


    /**
     * Set a list of tasks to be linked with the tag with the foreign key 
     * context.
     *
     * @param tasks a set of tasks for which the tag is set.
     */
    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Get all tasks linked to the tag with the foreign key context.
     *
     * @return a set of tasks for which the tag is set.
     */
    public Set<Task> getTasks() {
        return tasks;
    }
}

