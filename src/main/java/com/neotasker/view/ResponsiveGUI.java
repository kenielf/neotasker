package com.neotasker.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ResponsiveGUI extends JFrame {
    private Dimension screenDimension;
    private Dimension frameDimension;

    public ResponsiveGUI() {
        this.screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        pack();
        setSize(this.screenDimension.width, this.screenDimension.height);
        setLayout(null);

        //
        this.frameDimension = getSize();
        
        // Set default close op
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Set color
        getContentPane().setBackground(new Color(204, 204, 204));

        // Print Info
        System.out.format(
            "\u001b[35m[INFO]\u001b[00m %dx%d\n", this.screenDimension.width, this.screenDimension.height
        );

        // Add button
        addButton();
    }

    private void addButton() {
        JButton button = new JButton("Test");
        //
        // Set button size
        button.setSize(new Dimension(
            this.screenDimension.width / 5,
            this.screenDimension.height / 5)
        );

        System.out.println("Hello, world");

        add(button);
    }
}
