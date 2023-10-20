package com.neotasker.model;

import java.io.File;


public class OperatingSystem {
    private String platform;
    private File user_dir;
    private File data_root;

    public OperatingSystem() {
        // Detect Operating System
        this.platform = System.getProperty("os.name");

        // Define Custom Folders
        this.user_dir = new File(System.getProperty("user.home"));

        // Temporary Debug
        System.out.format("\u001b[34mPlatform:\u001b[00m %s\n", this.platform);
        System.out.format("\u001b[33mHome Directory:\u001b[00m %s\n", this.user_dir);
    }
}
