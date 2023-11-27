package com.neotasker.view.statistics;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

import net.miginfocom.swing.MigLayout;

import com.neotasker.controllers.StatisticsController;

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

    /**
     * Instantiates the statistics panel.
     */
    public Statistics() {
        StatisticsController methods = new StatisticsController();
        
        setLayout(new MigLayout("fillx", "20[left]"));

        this.identifierLabel = new JLabel(IDENTIFIER);
        this.identifierLabel.setFont(
            this.identifierLabel.getFont().deriveFont(IDENTIFIER_SIZE)
        );
        this.identifierSeparator = new JSeparator(JSeparator.HORIZONTAL);

        this.statsTable = new JTable();
        this.statsTable.setPreferredScrollableViewportSize(new Dimension(500, 70));
        this.statsTable.setFillsViewportHeight(true);
        this.statsTable.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Create a model for the table
        DefaultTableModel model = new DefaultTableModel();
        model.addRow(new Object[]{"Tasks Criadas", methods.getTasksCreated()});
        model.addRow(new Object[]{"Tasks Concluídas", methods.getTasksAccomplished()});
        model.addRow(new Object[]{"Tasks Programadas", methods.getTasksScheduled()});
        model.addRow(new Object[]{"Tasks Atrasadas", methods.getTasksDelayed()});
        this.statsTable.setModel(model);

         // Centralize the text in the table
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        this.statsTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        this.statsTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

        add(this.identifierLabel, "align center, wrap");
        add(this.identifierSeparator, "align center, grow, span, wrap");
        add(this.statsTable, "align center, wrap, grow");
    }
}

