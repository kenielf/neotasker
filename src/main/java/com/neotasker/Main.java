package com.neotasker;

import com.neotasker.database.HibernateUtil;
import com.neotasker.utils.OperatingSystem;
import com.neotasker.view.landing.Landing;
import com.neotasker.controllers.ConfigurationController;
import com.neotasker.database.HibernateUtil;
import com.neotasker.model.Theme;

/**
 * This is the application's main class.
 */
public class Main {
    /**
     * The starting point of the program. This method is responsible for the 
     * control of the functions at runtime.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        // Operating System Handler
        new OperatingSystem();

        // Handle System Configuration
        new ConfigurationController();
        System.out.println("\u001b[33mUi Theme:\u001b[00m " + Theme.getUiTheme());
        System.out.println("\u001b[33mIcon Theme:\u001b[00m " + Theme.getIconTheme());

        // Initialize Database
        HibernateUtil.Initialize();

        // Initialize Graphical Environment
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Landing();
            }
        });
    }
}
