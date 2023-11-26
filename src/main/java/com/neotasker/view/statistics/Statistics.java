package com.neotasker.view.statistics;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class Statistics extends JPanel {
    public static final String IDENTIFIER = "Estatísticas";
    public static final float IDENTIFIER_SIZE = 22f;
    JLabel identifierLabel;

    public Statistics() {
        setLayout(new MigLayout("fillx", "20[left]"));

        this.identifierLabel = new JLabel(IDENTIFIER);
        this.identifierLabel.setFont(
            this.identifierLabel.getFont().deriveFont(IDENTIFIER_SIZE)
        );

        add(this.identifierLabel);
    }
}

