package com.neotasker.view.tasks;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class Tasks extends JPanel {
    public static final String IDENTIFIER = "Tarefas";
    public static final float IDENTIFIER_SIZE = 22f;
    JLabel identifierLabel;

    public Tasks() {
        setLayout(new MigLayout("fillx", "20[left]"));

        this.identifierLabel = new JLabel(IDENTIFIER);
        this.identifierLabel.setFont(
            this.identifierLabel.getFont().deriveFont(IDENTIFIER_SIZE)
        );

        add(this.identifierLabel);
    }
}

