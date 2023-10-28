package com.neotasker.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.LayoutStyle;
import com.neotasker.view.advanced.*;
import com.neotasker.util.Constants;

public class ActivityList extends ResponsiveGUI {
    JLabel resolutionText;

    public ActivityList() {
        // Behaviour
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout());

        // Style
        setTitle(Constants.PROJECT_NAME);
        setBackground(new Color(204, 204, 204));

        // Add Resize Listener
        addComponentListener(new ResizeListener());

       // Add Content
       setResolutionText(
            String.format("Resolution: %dx%d", this.currentSize.width, this.currentSize.height)
        );

        // Visibility
        setVisible(true);
    }

    public void setResolutionText(String content) {
        this.resolutionText = new JLabel(content);
        this.resolutionText.addComponentListener(new ResizeListener() {
            //Dimension frameDimension = e.getComponent().getBounds().getSize();          
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                resolutionText.setText(
                    String.format(
                        "Resolution: %dx%d", this.componentDimension.width, this.componentDimension.height
                    )
                );
            }
        });
        add(this.resolutionText);
    }
}
