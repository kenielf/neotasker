package com.neotasker;

import com.neotasker.database.HibernateUtil;
import com.neotasker.utils.OperatingSystem;
import com.neotasker.view.landing.Landing;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.LoggerConfig;

import java.util.Map;

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
        // Operating System Handler
        new OperatingSystem();

        // Database Handler
        HibernateUtil.Initialize();

        // Disable Logging
        LoggerContext logContext = (LoggerContext) LogManager.getContext(false);
        Map<String, LoggerConfig> map = logContext.getConfiguration().getLoggers();
        for (String key: map.keySet()) {
            LoggerConfig logger = map.get(key);
            logger.setLevel(Level.OFF);
        }

        // Handle System Configuration
        new ConfigurationController();

        // Initialize Graphical Environment
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Landing();
            }
        });
    }
}
