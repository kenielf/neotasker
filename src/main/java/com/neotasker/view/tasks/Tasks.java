package com.neotasker.view.tasks;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;

import java.util.ArrayList;
import java.util.List;

import com.neotasker.controllers.TaskController;
import com.neotasker.model.Tag;
import com.neotasker.model.Task;
import com.neotasker.view.landing.Landing;

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
    public JScrollPane tablePane;
    public DefaultTableModel model;
    public static JTable table;
    public JButton refreshButton;
    public JButton deleteButton;
    public JButton toggleCompletionButton;

    /**
     * Instantiates the tasks panel.
     */
    public Tasks() {
        setLayout(new MigLayout("fillx", "10%[center]10%"));

        this.identifierLabel = new JLabel(IDENTIFIER);
        this.identifierLabel.setFont(
            this.identifierLabel.getFont().deriveFont(IDENTIFIER_SIZE)
        );
        this.identifierSeparator = new JSeparator(JSeparator.HORIZONTAL);

        // Get all Tasks
        this.model = new DefaultTableModel();
        model.addColumn("id");
        model.addColumn("Nome");
        model.addColumn("Descrição");
        model.addColumn("Data Criação");
        model.addColumn("Hora Criação");
        model.addColumn("Data Limite");
        model.addColumn("Hora Limite");
        model.addColumn("Tags");
        model.addColumn("Estado Conclusão");
        updateModel(model);
        Tasks.table = new JTable(model) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        Tasks.table.getColumnModel().getColumn(0).setMinWidth(0);
        Tasks.table.getColumnModel().getColumn(0).setMaxWidth(0);
        Tasks.table.getColumnModel().getColumn(0).setWidth(0);
        this.tablePane = new JScrollPane(Tasks.table);

        this.refreshButton = new JButton("Atualizar Tarefas");
        this.refreshButton.addActionListener(
            (ActionEvent e) -> updateTable()
        );

        this.deleteButton = new JButton("Deletar Tarefa");
        this.deleteButton.addActionListener(
            (ActionEvent e) -> deleteSelectedTask()
        );

        this.toggleCompletionButton = new JButton("Concluir / Reverter Conclusão");
        this.toggleCompletionButton.addActionListener(
            (ActionEvent e) -> taskToggleCompletion()
        );

        add(this.identifierLabel, "align center, span, wrap");
        add(this.identifierSeparator, "align center, grow, span, wrap");
        add(Tasks.table.getTableHeader(), "align center, grow, span, wrap");
        add(this.tablePane, "align center, grow, span, wrap");
        add(this.refreshButton, "align center, split 3");
        add(this.deleteButton, "align center");
        add(this.toggleCompletionButton, "align center, wrap");
    }

    public String tagsToString(List<Tag> tags) {
        String result = new String();
        for (int i=0; i<tags.size(); i++) {
            if (i == 0) {
                result = tags.get(i).getLabel();
            } else {
                result = result + ", " + tags.get(i).getLabel();
            }
        }
        return result;
    }

    private void updateModel(DefaultTableModel model) {
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
                new Object[]{
                    task.getId(),
                    task.getTitle(),
                    task.getDescription(),
                    task.getDateCreation().toString().split("T")[0],
                    task.getDateCreation().toString().split("T")[1],
                    (task.getDateDue()!=null)? task.getDateDue().toString().split("T")[0]: null,
                    (task.getDateDue()!=null)? task.getDateDue().toString().split("T")[1]: null,
                    tagsToString(task.getTags()),
                    task.getStatus()? "Completo" : "Incompleto"
                }
            );
        }

    }

    public void updateTable() {
        updateModel(this.model);
        Tasks.table.invalidate();
        Tasks.table.repaint();
    }

    public void deleteSelectedTask() {
        int row = Tasks.table.getSelectedRow();
        if (!(row < 0 || row > Tasks.table.getRowCount())) {
            int taskId = Integer.parseInt(Tasks.table.getValueAt(row, 0).toString());
            TaskController taskController = new TaskController();
            taskController.deleteTask(taskId);
            updateModel(this.model);
            // Update tables
            Landing rootWindow = (Landing) SwingUtilities.getRoot(this);
            rootWindow.content.statisticsView.updateTable();
            updateTable();
        }
    }

    public void taskToggleCompletion() {
        int row = Tasks.table.getSelectedRow();
        if (!(row < 0 || row > Tasks.table.getRowCount())) {
            int taskId = Integer.parseInt(Tasks.table.getValueAt(row, 0).toString());
            TaskController taskController = new TaskController();
            Task task = taskController.getTaskById(taskId);
            if (task.getStatus()) {
                task.setStatus(false);
            } else {
                task.setStatus(true);
            }
            taskController.updateTask(task);
            // Update Tables
            Landing rootWindow = (Landing) SwingUtilities.getRoot(this);
            rootWindow.content.statisticsView.updateTable();
            updateTable();
        }
    }
}
