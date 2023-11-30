package com.neotasker.view.statistics;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;

import net.miginfocom.swing.MigLayout;

import java.util.List;

import com.neotasker.controllers.StatisticsController;
import com.neotasker.controllers.TaskController;
import com.neotasker.model.Task;

/**
 * This class is responsible for displaying the statistics for the application.
 */
public class Statistics extends JPanel {
    /** The identifier for the Card Layout and label. */
    public static final String IDENTIFIER = "Estatísticas";
    /** The font size for the identifier. */
    public static final float IDENTIFIER_SIZE = 22f;
    /** The text label for the identifier. */
    JLabel identifierLabel;
    /** The separator for the identifier. */
    public JSeparator identifierSeparator;

    public DefaultTableModel model;
    public static JTable statsTable;
    public int taskCount;

    public JButton refreshButton;

    /**
     * Instantiates the statistics panel.
     */
    public Statistics() {
        StatisticsController methods = new StatisticsController();
        
        setLayout(new MigLayout("fillx", "10%[center][right]10%"));

        this.identifierLabel = new JLabel(IDENTIFIER);
        this.identifierLabel.setFont(
            this.identifierLabel.getFont().deriveFont(IDENTIFIER_SIZE)
        );
        this.identifierSeparator = new JSeparator(JSeparator.HORIZONTAL);

        Statistics.statsTable = new JTable();
        //this.statsTable.setFillsViewportHeight(true);
        //this.statsTable.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Create a model for the table
        this.model = new DefaultTableModel();
        
        model.addColumn("Estatística");
        model.addColumn("Valor");


        Statistics.statsTable.setModel(model);

        this.refreshButton = new JButton("Atualizar Estatísticas");
        this.refreshButton.addActionListener(
            (ActionEvent e) -> updateTable()
        );
        updateTable();

         // Centralize the text in the table

        add(this.identifierLabel, "align center, span, wrap");
        add(this.identifierSeparator, "align center, grow, span, wrap");
        add(Statistics.statsTable.getTableHeader(), "align center, grow, span, wrap");
        add(Statistics.statsTable, "align center, wrap, grow, span");
        add(this.refreshButton, "align right, wrap");
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

        model.addRow(
            new Object[]{"Tasks Criadas", tasks.size()}
        );
        model.addRow(
            new Object[]{"Tasks Concluídas", null}
        );
        model.addRow(
            new Object[]{"Tasks Atrasadas", null}
        );

        Statistics.statsTable.invalidate();
        Statistics.statsTable.repaint();
    }
}

