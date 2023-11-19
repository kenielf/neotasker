package com.neotasker.view;

import java.awt.*;
import javax.swing.*;

import com.formdev.flatlaf.*;
import com.formdev.flatlaf.intellijthemes.*;

import com.neotasker.view.NavigationBar;
import com.neotasker.view.Theme;

public class StatsWindow extends CustomFrame{
    
    NavigationBar navbar;

    public StatsWindow() {
        super();
        setVisible(true);
        setTitle("Tela de Estatísticas e Informações");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        // pack();

        // Set theme
        Theme theme = new Theme();
        theme.getTheme();

        // Navigation Bar
        this.navbar = new NavigationBar();

        // Add components
        add(this.navbar);
    }

    @Override
    public void setDefaultCloseOperation(int mode) {
        super.setDefaultCloseOperation(mode);
    }

    public static void main(String[] args) {
        
        // Set important flags
        System.setProperty("awt.useSystemAAFontSettings", "on");  // Fixes Anti Aliasing on Unix-Like Platforms

        // Prepare Visual Components
        //System.setProperty(
        //        "awt.useSystemAAFontSettings", "on"); // Fixes Aliasing on Unix-Like Platforms

        // Built-In Themes
        // FlatDarculaLaf.setup();
        // FlatIntelliJLaf.setup();
        // FlatDarkLaf.setup();
        FlatLightLaf.setup();

        // Custom Themes
        //FlatDraculaIJTheme.setup();
        // FlatArcDarkOrangeIJTheme.setup();
        // FlatCobalt2IJTheme.setup();

        // Start Graphical Window
        // new ActivityList();

        // Create and show the GUI
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConfigWindow().setVisible(true);
            }
        });
    }
}
