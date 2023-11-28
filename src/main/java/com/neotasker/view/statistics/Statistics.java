package com.neotasker.view.statistics;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

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

    /**
     * Instantiates the statistics panel.
     */
    public Statistics() {
        setLayout(new MigLayout("fillx", "20[left]"));

        this.identifierLabel = new JLabel(IDENTIFIER);
        this.identifierLabel.setFont(
            this.identifierLabel.getFont().deriveFont(IDENTIFIER_SIZE)
        );

        add(this.identifierLabel);
    }
}

