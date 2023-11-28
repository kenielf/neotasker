package com.neotasker.view.tasks;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

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

    /**
     * Instantiates the tasks panel.
     */
    public Tasks() {
        setLayout(new MigLayout("fillx", "20[left]"));

        this.identifierLabel = new JLabel(IDENTIFIER);
        this.identifierLabel.setFont(
            this.identifierLabel.getFont().deriveFont(IDENTIFIER_SIZE)
        );
        this.identifierSeparator = new JSeparator(JSeparator.HORIZONTAL);

        add(this.identifierLabel, "align center, wrap");
        add(this.identifierSeparator, "align center, grow, span, wrap");

    }
}
