package com.neotasker;

import com.neotasker.database.HibernateUtil;
import com.neotasker.utils.OperatingSystem;

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

        // Database Handler
        HibernateUtil.Initialize();

        // Safe Exit
        System.exit(1);
    }
}
