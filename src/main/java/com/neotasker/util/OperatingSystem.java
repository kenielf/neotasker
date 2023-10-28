package com.neotasker.util;

import java.io.File;


public class OperatingSystem {
    private String platform;
    private File user_dir;
    private File data_root;
    private File database_file;

    public OperatingSystem() {
        // Detect Operating System
        this.platform = System.getProperty("os.name").toLowerCase();

        // Define Custom Folders
        String stringified_user_dir = System.getProperty("user.home");
        this.user_dir = new File(stringified_user_dir);

        if (this.platform.contains("windows")) {
            setWindowsPreferences();
        } else {
            setUnixPreferences();
        }

        // Create if it does not exist
        if (!this.data_root.exists()) {
            System.out.format("\u001b[36mCreating Data Directory...\u001b[00m\n");
            this.data_root.mkdir();
        }


        // Temporary Debug
        System.out.format("\u001b[34mPlatform:\u001b[00m %s\n", this.platform);
        System.out.format("\u001b[33mHome Directory:\u001b[00m %s\n", this.user_dir);
        System.out.format("\u001b[33mData Directory:\u001b[00m %s\n", this.data_root);
        System.out.format("\u001b[33mDatabase File:\u001b[00m %s\n", this.database_file);
    }

    private void setWindowsPreferences() {
        // Data Directory
        this.data_root = new File(
            System.getenv("LOCALAPPDATA") + "\\neotasker"
        );

        // Database File
        this.database_file = new File(
            this.data_root.toString() + "\\data.sqlite3"
        );
    }

    private void setUnixPreferences() {
        // Data Directory
        this.data_root = new File(
            this.user_dir.toString() + "/.local/share/neotasker/"
        );

        // Database File
        this.database_file = new File(
            this.data_root.toString() + "/data.sqlite3"
        );
    }

    public String getPlatform() {
        return this.platform;
    }

    public File getDataRoot() {
        return this.data_root;
    }

    public File getDatabaseFile() {
        return this.database_file;
    }
}