package com.neotasker.model;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database {
    public static void createDatabase(File file) {
        // Get url
        String url = "jdbc:sqlite:" + file.toString();

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
