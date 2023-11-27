package com.neotasker.view.calendar;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;

import net.miginfocom.swing.MigLayout;

/**
 * This class is responsible for displaying the calendar panel.
 */
public class Calendar extends JPanel {
    /** The identifier for the Card Layout and label. */
    public static final String IDENTIFIER = "Calendário";
    /** The font size for the identifier. */
    public static final float IDENTIFIER_SIZE = 22f;
    /** The text label for the identifier. */
    JLabel identifierLabel;
    /** The separator for the identifier. */
    public JSeparator identifierSeparator;

    /**
     * Instantiates the calendar panel.
     */
    public Calendar() {
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
