/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.neotasker;
import com.neotasker.util.OperatingSystem;
import com.neotasker.model.Database;
import com.neotasker.view.ActivitiesList;

/**
 *
 * @author kenielf
 */
public class NeoTasker {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        // OS Handling
        OperatingSystem os = new OperatingSystem();

        // Create Database
        Database.createDatabase(os.getDatabaseFile());

        // Set important flags
        System.setProperty("awt.useSystemAAFontSettings", "on");  // Fixes Anti Aliasing on Unix-Like Platforms

        // Start Front End
        ActivitiesList main = new ActivitiesList();
    }
}
