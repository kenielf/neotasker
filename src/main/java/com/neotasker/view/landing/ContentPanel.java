package com.neotasker.view.landing;

import java.awt.CardLayout;

import javax.swing.JPanel;

import com.neotasker.view.tasks.Tasks;
import com.neotasker.view.calendar.Calendar;
import com.neotasker.view.statistics.Statistics;
import com.neotasker.view.configuration.Configuration;

public class ContentPanel extends JPanel {
    private CardLayout cardLayout;
    private Tasks tasksView;
    private Calendar calendarView;
    private Statistics statisticsView;
    private Configuration configurationView;

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
        this.configurationView = new Configuration();

        // Set Default View
        cardLayout.show(this, Tasks.IDENTIFIER);

        // Add content
        add(this.tasksView, Tasks.IDENTIFIER);
        add(this.calendarView, Calendar.IDENTIFIER);
        add(this.statisticsView, Statistics.IDENTIFIER);
        add(this.configurationView, Configuration.IDENTIFIER);
    }

    private void switchView(String label) {
        cardLayout.show(this, label);
    }

    public void switchToTasks() {
        switchView(Tasks.IDENTIFIER);
    }

    public void switchToCalendar() {
        switchView(Calendar.IDENTIFIER);
    }

    public void switchToStatistics() {
        switchView(Statistics.IDENTIFIER);
    }
    public void switchToConfiguration() {
        switchView(Configuration.IDENTIFIER);
    }
}
