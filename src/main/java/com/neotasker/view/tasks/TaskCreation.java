package com.neotasker.view.tasks;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;

import net.miginfocom.swing.MigLayout;

public class TaskCreation extends JPanel {
    public static final String IDENTIFIER = "Criar Tarefa";
    
    public JLabel identifierLabel;
    public JSeparator identifierSeparator;


    public JLabel titlePrompt;
    public JTextField titleField;
    public JLabel titleWarningField;

    public JLabel descriptionPrompt;
    public JTextField descriptionField;
    public JLabel descriptionWarningField;

    public JButton addButton;

    public TaskCreation() {
        super();

        // Set layout
        setLayout(new MigLayout("fillx", "20[left]"));

        // Create components
        this.identifierLabel = new JLabel(IDENTIFIER);
        this.identifierLabel.setFont(
            this.identifierLabel.getFont().deriveFont(22f)
        );
        this.identifierSeparator = new JSeparator(JSeparator.HORIZONTAL);

        // Title
        this.titlePrompt = new JLabel("Título");
        this.titlePrompt.setFont(
            this.titlePrompt.getFont().deriveFont(18f)
        );
        this.titleField = new JTextField();
        this.titleWarningField = new JLabel();

        // Description
        this.descriptionPrompt = new JLabel("Descrição");
        this.descriptionPrompt.setFont(
            this.descriptionPrompt.getFont().deriveFont(18f)
        );
        this.descriptionField = new JTextField();
        this.descriptionWarningField = new JLabel();

        // Add Button
        this.addButton = new JButton("Adicionar Tarefa");

        // Add components
        add(this.identifierLabel, "align center, wrap");
        add(this.identifierSeparator, "align center, grow, span, wrap");

        add(this.titlePrompt, "align left, wrap");
        add(this.titleField, "align left, grow, span, wrap");
        add(this.titleWarningField, "align left, grow, span, wrap");

        add(this.descriptionPrompt, "align left, wrap");
        add(this.descriptionField, "align left, grow, span, wmin 0, wrap");
        add(this.descriptionWarningField, "align left, wrap");
    }
}
