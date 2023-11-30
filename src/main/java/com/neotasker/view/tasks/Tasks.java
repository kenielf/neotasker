package com.neotasker.view.tasks;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.swingx.plaf.TableAddon;

import java.awt.event.ActionEvent;

import java.util.ArrayList;
import java.util.List;

import com.neotasker.controllers.TagController;
import com.neotasker.controllers.TaskController;
import com.neotasker.model.Task;
import com.neotasker.model.Tag;

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
    public DefaultTableModel model;
    public static JTable table;
    public JButton refreshButton;

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
        this.model = new DefaultTableModel();
        model.addColumn("Nome");
        model.addColumn("Descrição");
        model.addColumn("Data Limite");
        model.addColumn("Tags");
        TaskController tc = new TaskController();
        List<Task> tasks = tc.getAllTasks();
        for (int i=0; i<tasks.size(); i++) {
            Task task = tasks.get(i);
            model.addRow(
                new Object[]{task.getTitle(), task.getDescription(), task.getDateDue(), listToString(task)}
            );
        }
        Tasks.table = new JTable(model);
        this.refreshButton = new JButton("Atualizar Tarefas");
        this.refreshButton.addActionListener(
            (ActionEvent e) -> updateTable()
        );


        add(this.identifierLabel, "align center, span, wrap");
        add(this.identifierSeparator, "align center, grow, span, wrap");
        add(Tasks.table.getTableHeader(), "align center, grow, span, wrap");
        add(Tasks.table, "align center, grow, span, wrap");
        add(this.refreshButton, "align center, span, wrap");
    }

    public void updateTable() {
        // Remove all rows
        if (model.getRowCount() > 0) {
            for (int i = model.getRowCount() - 1; i > -1; i--) {
                model.removeRow(i);
            }
        }

        TaskController tc = new TaskController();
        List<Task> tasks = tc.getAllTasks();
        for (int i=0; i<tasks.size(); i++) {
            Task task = tasks.get(i);
            model.addRow(
                new Object[]{task.getTitle(), task.getDescription(), task.getDateDue(), listToString(task)}
            );
        }
        Tasks.table.invalidate();
        Tasks.table.repaint();
    }

    public String listToString(Task task){
        // Change the List to String 
        String tagLabel = new String();

        List<Tag> tagList = new ArrayList<>();

        tagList = task.getTags();
        for(int i = 0; i < tagList.size(); i++){
            tagLabel = tagLabel + ", " + tagList.get(i).getLabel();
        }

        return tagLabel;
    }
}
