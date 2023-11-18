package com.neotasker.view;

import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ActivityList extends CustomFrame {
    NavigationBar navbar;

    JLabel testLabel;
    JButton testButton;

    public ActivityList() {
        super();
        setVisible(true);
        setLayout(new CardLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        // pack();

        // Navigation Bar
        this.navbar = new NavigationBar();

        // Label
        this.testLabel = new JLabel("Testing...");
        this.testLabel.setVisible(true);

        // Button
        this.testButton = new JButton("Click Here!");
        this.testButton.setVisible(true);
        int buttonSize = (int) Math.round(this.resolution.width * 0.2);
        this.testButton.setBounds(
                (this.resolution.width / 2) + (buttonSize / 2),
                (this.resolution.height / 2) + (buttonSize / 2),
                buttonSize,
                buttonSize);

        // Add components
        add(this.navbar);
        add(this.testLabel);
        add(this.testButton);
    }

    @Override
    public void setDefaultCloseOperation(int mode) {
        super.setDefaultCloseOperation(mode);
    }
}
