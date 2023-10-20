package com.neotasker.model;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database {
    public static void createDatabase(String file) {
        // Get user's home (maybe linux only?)
        String stringified_data_root = System.getProperty("user.home") + 
            "/.local/share/neotasker/";

        File data_root = new File(stringified_data_root);
        if (!data_root.exists()) {
            data_root.mkdir();
        }

        // Get url
        String url = "jdbc:sqlite:" + stringified_data_root + file;

        // Try connection
        try (Connection con = DriverManager.getConnection(url)) {
            if (con != null) {
                DatabaseMetaData meta = con.getMetaData();

                System.out.format("\u001b[33mMetadata:\u001b[00m %s\n", meta);
            }
        } catch (SQLException excep) {
            System.out.format("\u001b[31m%s\u001b[00m\n", excep.getMessage());
        }
    }
}
