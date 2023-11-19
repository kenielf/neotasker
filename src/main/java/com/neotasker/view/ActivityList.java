package com.neotasker.view;

import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ActivityList extends CustomFrame {

    NavigationBar navbar;

    public ActivityList() {
        super();
        setVisible(true);
        setTitle("Lista de Atividades");
        setLayout(new CardLayout());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        // pack();

        // Navigation Bar
        this.navbar = new NavigationBar();

        // Add components
        add(this.navbar);
    }

    @Override
    public void setDefaultCloseOperation(int mode) {
        super.setDefaultCloseOperation(mode);
    }
}
