package com.neotasker.view.statistics;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;

import net.miginfocom.swing.MigLayout;

import com.neotasker.controllers.StatisticsController;
import com.neotasker.controllers.TaskController;

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

    public JTable statsTable;
    public int taskCount;
    public DefaultTableModel model;

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

        this.statsTable = new JTable();
        this.statsTable.setFillsViewportHeight(true);
        this.statsTable.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Create a model for the table
        this.model = new DefaultTableModel();
        
        model.addColumn("Estatística");
        model.addColumn("Valor");

        TaskController tc = new TaskController();
        this.taskCount = tc.getAllTasks().size();
        model.addRow(new Object[]{"Tasks Criadas", this.taskCount});
        model.addRow(new Object[]{"Tasks Concluídas", methods.getTasksAccomplished()});
        model.addRow(new Object[]{"Tasks Atrasadas", methods.getTasksDelayed()});

        this.statsTable.setModel(model);

        this.refreshButton = new JButton("Atualizar");
        this.refreshButton.addActionListener(
            (ActionEvent e) -> update()
        );

         // Centralize the text in the table
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        this.statsTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        this.statsTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

        add(this.identifierLabel, "align center, wrap");
        add(this.identifierSeparator, "align center, grow, span, wrap");
        add(this.statsTable, "align center, wrap, grow, span");
        add(this.refreshButton, "align right, wrap");
    }

    public void update() {
        TaskController tc = new TaskController();
        this.taskCount = tc.getAllTasks().size();
        this.model.setValueAt(tc.getAllTasks().size(), 0, 1);
        this.statsTable.invalidate();
        this.statsTable.repaint();
    }
}

