package com.neotasker.platform;

import java.io.File;

/**
 * This is the class responsible for managing the Operating System.
 */
public class OperatingSystem {
    /** Operating system platform environment property key. */
    public static final String OS_KEY = "os.name";
    /** User's home directory environment property key. */
    public static final String HOME_KEY = "user.home";
    /** Project's directory environment property key. */
    public static final String PROJECT_DIR_KEY = "NEOTASKER_DIR";
    /** Project's database file environment property key. */
    public static final String DATABASE_FILE_KEY = "NEOTASKER_DB_FILE";
    /** Project's database file name environment property key. */
    public static final String DATABASE_FILE_NAME = "data.sqlite3";
    /** Project's configuration environment property key. */
    public static final String CONFIGURATION_KEY = "NEOTASKER_CONFIG";
    /** Project's configuration file environment property key. */
    public static final String CONFIGURATION_FILE = "config.json";

    /**
     * This {@link java.lang.reflect.Constructor} is responsible for 
     * configuring the environment according to the Operating System.
     */
    public OperatingSystem () {
        String platform = System.getProperty("os.name").toLowerCase().strip();

        if (platform.startsWith("win")) {
            configureWindowsEnvironment();
        } else {
            configureUnixLikeEnvironment();
        }
    }

    /**
     * This method is tied specifically to the Windows environment, called by
     * the constructor.
     *
     * Sets the environment configuration for relevant files and directories.
     * @see OperatingSystem
     */
    public void configureWindowsEnvironment() {
        // INFO: Project Data Directory
        String dataPath = System.getenv("LOCALAPPDATA") + "\\" + Constants.PROJECT_NAME;
        createDataDirectory(dataPath);
        System.setProperty(PROJECT_DIR_KEY, dataPath);

        // INFO: Project Database File
        String dbPath = dataPath + "\\" + DATABASE_FILE_NAME;
        System.setProperty(DATABASE_FILE_KEY, dbPath);

        // INFO: Project Configuration File
        String configFile = dataPath + "\\" + CONFIGURATION_FILE;
        System.setProperty(CONFIGURATION_KEY, configFile);
    }

    /**
     * This method is tied specifically to the Unix-Like environment, and 
     * works for Linux, Unix, BSDs and Mac - in theory.
     *
     * Sets the environment configuration for relevant files and directories.
     * @see OperatingSystem
     */
    public void configureUnixLikeEnvironment() {
        // INFO: Project Data Directory
        String dataPath = getHomeDirectory().toString() + "/.local/share/" + Constants.PROJECT_NAME;
        createDataDirectory(dataPath);
        System.setProperty(PROJECT_DIR_KEY, dataPath);

        // INFO: Project Database File
        String dbPath = dataPath + "/" + DATABASE_FILE_NAME;
        System.setProperty(DATABASE_FILE_KEY, dbPath);

        // INFO: Project Configuration File
        String configFile = dataPath + "/" + CONFIGURATION_FILE;
        System.setProperty(CONFIGURATION_KEY, configFile);
    }

    /**
     * A platform independent method of getting the user's home directory.
     *
     * @return the user's home directory as a java {@link File}.
     */
    public static File getHomeDirectory() {
        String homePath = System.getProperty("user.home");
        return new File(homePath);
    }

    /**
     * Creates the application's data directory, where all relevant files 
     * created by the app will be placed.
     *
     * @param path the path to create the directory.
     */
    private void createDataDirectory(String path) {
        File dataDir = new File(path);
        if (!dataDir.exists()) {
            dataDir.mkdir();
        }
    }

    /**
     * Gets the data directory for external use.
     * @return the data directory as a java {@link File} object.
     * @see File
     */
    public static File getDataDirectory() {
        return new File(System.getProperty(PROJECT_DIR_KEY));
    }

    /**
     * Gets the database file for external use.
     * @return the database file as a java {@link File} object.
     * @see File
     */
    public static File getDatabaseFile() {
        return new File(System.getProperty(DATABASE_FILE_KEY));
    }

    /**
     * Gets the database file for external use.
     * @return the database file as a java {@link File} object.
     * @see File
     */
    public static File getConfigurationFile() {
        return new File(System.getProperty(CONFIGURATION_KEY));
    }
}

