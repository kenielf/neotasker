package com.neotasker.controllers;

/**
 * Environment based configuration.
 */
public class StatisticsController {
    
    private int tasksCreated;
    private int tasksAccomplished;
    private int tasksScheduled;
    private int tasksDelayed;

    /**
     * Instantiates the configuration for the entire application.
     */

    public StatisticsController() {
        this.tasksCreated = 0;
        this.tasksAccomplished = 0;
        this.tasksScheduled = 0;
        this.tasksDelayed = 0;
    }

    public int incrementTasksCreated() {
        this.tasksCreated++;
        return this.tasksCreated;
    }

    public int incrementTasksAccomplished() {
        this.tasksAccomplished++;
        return this.tasksAccomplished;
    }

    public int incrementTasksScheduled() {
        this.tasksScheduled++;
        return this.tasksScheduled;
    }

    public int incrementTasksDelayed() {
        this.tasksDelayed++;
        return this.tasksDelayed;
    }

    public int getTasksCreated() {
        return this.tasksCreated;
    }

    public int getTasksAccomplished() {
        return this.tasksAccomplished;
    }

    public int getTasksScheduled() {
        return this.tasksScheduled;
    }

    public int getTasksDelayed() {
        return this.tasksDelayed;
    }

    public int setTasksCreated(int tasksCreated) {
        this.tasksCreated = tasksCreated;
        return this.tasksCreated; 
    }

    public int setTasksAccomplished(int tasksAccomplished) {
        this.tasksAccomplished = tasksAccomplished;
        return this.tasksAccomplished;
    }

    public int setTasksScheduled(int tasksScheduled) {
        this.tasksScheduled = tasksScheduled;
        return this.tasksScheduled;
    }

    public int setTasksDelayed(int tasksDelayed) {
        this.tasksDelayed = tasksDelayed;
        return this.tasksDelayed;
    }
}

