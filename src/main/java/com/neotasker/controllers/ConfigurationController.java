package com.neotasker.controllers;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.neotasker.model.Aliasing;
import com.neotasker.model.Configuration;
import com.neotasker.model.Theme;
import com.neotasker.platform.OperatingSystem;

/**
 * Environment based configuration.
 */
public class ConfigurationController {
    private Gson gson;
    private HashMap<String, String> json;
    private Configuration config;

    /**
     * Instantiates the configuration for the entire application.
     */
    public ConfigurationController() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.json = new HashMap<String, String>();

        if (OperatingSystem.getConfigurationFile().exists()) {
            // Load it
            try {
                JsonReader reader = new JsonReader(
                    new FileReader(OperatingSystem.getConfigurationFile())
                );
                this.json = gson.fromJson(reader, HashMap.class);
                if (this.json == null) {
                    this.config = createDefault();
                    writeConfig(this.config);
                } else {
                    this.config = new Configuration(
                        json.get("scalingPercentage"),
                        json.get("uiTheme"),
                        json.get("iconTheme"),
                        Aliasing.valueOf(json.get("aliasingType"))
                    );
                }

            } catch (NullPointerException e) {
                this.config = createDefault();
                writeConfig(this.config);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        } else {
            // Create it with defaults and save to its file
            this.config = createDefault();
            writeConfig(this.config);
        }

        // Initialize it
        Theme.Initialize(
            config.getScalingPercentage(),
            config.getUiTheme(),
            config.getIconTheme(),
            config.getAliasingType()
        );
    }

    /**
     * Statically creates a configuration for cases where it is invalid or 
     * does not exist.
     *
     * @return the configuration with default options.
     */
    public static Configuration createDefault() {
        Configuration config = new Configuration();
        config.setScalingPercentage(Theme.SCALING_DEFAULT);
        config.setUiTheme(Theme.UI_THEME_DEFAULT);
        config.setIconTheme(Theme.ICON_THEME_DEFAULT);
        config.setAliasingType(Theme.ALIASING_DEFAULT);
        return config;
    }

    /**
     * Overwrites the configuration file - works both if the file 
     * exists or not.
     */
    public static void updateConfiguration() {
        Configuration config = new Configuration();
        config.setScalingPercentage(Theme.getScalingPercentage());
        config.setUiTheme(Theme.getUiTheme());
        config.setIconTheme(Theme.getIconTheme());
        config.setAliasingType(Aliasing.valueOf(Theme.getAntiAliasing()));
        writeConfig(config);
    }

    /**
     * Writes the configuration to the file, can be used anywhere.
     * 
     * @param config the configuration that will be saved.
     */
    public static void writeConfig(Configuration config) {
        try {
            BufferedWriter writer = new BufferedWriter(
                new FileWriter(OperatingSystem.getConfigurationFile())
            );
            writer.append(
                new GsonBuilder().setPrettyPrinting().create().toJson(config)
            );
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
