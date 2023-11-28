package com.neotasker.view.tasks;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;

import java.util.List;

import com.neotasker.controllers.TaskController;
import com.neotasker.model.Task;

import net.miginfocom.swing.MigLayout;

/**
 * This class is responsible for displaying the tasks for the application.
 */
public class Tasks extends JPanel {
    /** The identifier for the Card Layout and label. */
    public static final String IDENTIFIER = "Tarefas";
    /** The font size for the identifier. */
    public static final float IDENTIFIER_SIZE = 22f;
    /** The text label for the identifier. */
    JLabel identifierLabel;
    /** The separator for the identifier. */
    public JSeparator identifierSeparator;
    public JScrollBar scrollBar;

    /**
     * Instantiates the tasks panel.
     */
    public Tasks() {
        setLayout(new MigLayout("fillx", "10%[left][]10%"));

        this.identifierLabel = new JLabel(IDENTIFIER);
        this.identifierLabel.setFont(
            this.identifierLabel.getFont().deriveFont(IDENTIFIER_SIZE)
        );
        this.identifierSeparator = new JSeparator(JSeparator.HORIZONTAL);

        // Get all Tasks
        TaskController tc = new TaskController();
        List<Task> tasks = tc.getAllTasks();

        for (int i=0; i<tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.println(task.getTitle());
        }

        add(this.identifierLabel, "align center, span, wrap");
        add(this.identifierSeparator, "align center, grow, span, wrap");

    }
}
