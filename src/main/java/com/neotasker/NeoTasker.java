/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.neotasker;
import com.neotasker.util.OperatingSystem;

import java.util.List;

import org.hibernate.SessionFactory;

import com.neotasker.database.HibernateUtil;
import com.neotasker.controller.TaskController;
import com.neotasker.model.Task;

import com.formdev.flatlaf.*;
import com.formdev.flatlaf.intellijthemes.*;
import com.neotasker.view.*;
/**
 *
 * @author kenielf
 */
public class NeoTasker {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        // OS Handling
        OperatingSystem os = new OperatingSystem();

        // Testing Hibernate
        SessionFactory util = HibernateUtil.getSessionFactory();
        TaskController taskDAO = new TaskController();
        Task task = new Task("Create Something", "Actually Tries to Create Something");
        taskDAO.registerTask(task);
        System.out.println("Created Task.");

        // Querying Tasks
        //List<Task> tasks = taskDAO.getAllTasks();
        //for (int i=0; i<tasks.size(); i++) {
        //    System.out.println(tasks.get(i));
        //};

        // Set important flags
        System.setProperty("awt.useSystemAAFontSettings", "on");  // Fixes Anti Aliasing on Unix-Like Platforms

        // Prepare Visual Components
        //System.setProperty(
        //        "awt.useSystemAAFontSettings", "on"); // Fixes Aliasing on Unix-Like Platforms

        // Built-In Themes
        // FlatDarculaLaf.setup();
        // FlatIntelliJLaf.setup();
        // FlatDarkLaf.setup();
        // FlatLightLaf.setup();

        // Custom Themes
        FlatDraculaIJTheme.setup();
        // FlatArcDarkOrangeIJTheme.setup();
        // FlatCobalt2IJTheme.setup();

        // Start Graphical Window
        // new ActivityList();

        // Create and show the GUI
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ActivityList().setVisible(true);
            }
        });
    }
}
