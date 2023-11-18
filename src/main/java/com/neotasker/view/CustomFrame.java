package com.neotasker.view;

import java.awt.*;

import javax.swing.*;

public class CustomFrame extends JFrame {
    public Toolkit toolkit;
    public Dimension resolution;

    CustomFrame() {
        super();

        // Set toolkit and resolution
        this.toolkit = Toolkit.getDefaultToolkit();
        this.resolution = this.toolkit.getScreenSize().getSize();

        // Set default size
        setSize(this.resolution.width, this.resolution.height);
    }
}
