package com.neotasker.view.advanced;

import java.awt.*;
import javax.swing.*;

public class ResponsiveGUI extends JFrame {
    private Toolkit tk;
    public Dimension currentSize;

    public ResponsiveGUI() {
        this.tk = Toolkit.getDefaultToolkit();
        this.currentSize = tk.getScreenSize();

    }
}
