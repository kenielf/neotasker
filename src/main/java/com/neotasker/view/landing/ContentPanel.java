package com.neotasker.view.landing;

import java.awt.CardLayout;

import javax.swing.JPanel;

import com.neotasker.view.tasks.TaskCreation;
import com.neotasker.view.tasks.Tasks;
import com.neotasker.view.calendar.Calendar;
import com.neotasker.view.statistics.Statistics;
import com.neotasker.view.configuration.Configuration;

/**
 * This class is responsible for switching the content panels.
 */
public class ContentPanel extends JPanel {
    /** The layout used to manage panels. */
    private CardLayout cardLayout;
    /** The task panel. */
    public Tasks tasksView;
    /** The calendar panel */
    public Calendar calendarView;
    /** The statistics panel */
    public Statistics statisticsView;
    /** The task creation panel. */
    public TaskCreation taskCreationView;
    /** The configuration panel */
    public Configuration configurationView;

    /**
     * Instantiates the content panel
     */
    public ContentPanel() {
        // Instantiate JPanel Properties
        super();

        // Define Properties
        this.cardLayout = new CardLayout();
        setLayout(this.cardLayout);

        // Insert Panels
        this.tasksView = new Tasks();
        this.calendarView = new Calendar();
        this.statisticsView = new Statistics();
        this.taskCreationView = new TaskCreation();
        this.configurationView = new Configuration();

        // Set Default View
        cardLayout.show(this, Tasks.IDENTIFIER);

        // Add content
        add(this.tasksView, Tasks.IDENTIFIER);
        add(this.calendarView, Calendar.IDENTIFIER);
        add(this.statisticsView, Statistics.IDENTIFIER);
        add(this.taskCreationView, TaskCreation.IDENTIFIER);
        add(this.configurationView, Configuration.IDENTIFIER);
    }

    /**
     * Switches the view to the specified panel.
     *
     * @param label the identifier of the panel.
     */
    private void switchView(String label) {
        cardLayout.show(this, label);
    }

    /**
     * Switches the view to the tasks panel.
     */
    public void switchToTasks() {
        switchView(Tasks.IDENTIFIER);
    }

    /**
     * Switches the view to the calendar panel.
     */
    public void switchToCalendar() {
        switchView(Calendar.IDENTIFIER);
    }

    /**
     * Switches the view to the statistics panel.
     */
    public void switchToStatistics() {
        switchView(Statistics.IDENTIFIER);
    }

    /**
     * Switches the view to task creation panel.
     */
    public void switchToTaskCreation() {
        switchView(TaskCreation.IDENTIFIER);
    }

    /**
     * Switches the view to the configuration panel.
     */
    public void switchToConfiguration() {
        switchView(Configuration.IDENTIFIER);
    }
}
