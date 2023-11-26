package com.neotasker.model;

/**
 * This class is responsible for storing the values for the software's 
 * configuration.
 */
public class Configuration {
    private String scalingPercentage;
    private String uiTheme;
    private String iconTheme;
    private Aliasing aliasingType;

    /**
     * Instantiates an empty configuration. This is meant to be filled later.
     */
    public Configuration() {
    }

    /**
     * Instantiates a complete configuration.
     *
     * @param scalingPercentage sets the ui scaling percentage, example: "200%".
     * @param uiTheme is either "light" or "dark".
     * @param iconTheme same as uiTheme - "light" or "dark".
     * @param aliasingType use {@link Aliasing} to set UI Aliasing
     */
    public Configuration(String scalingPercentage, String uiTheme, String iconTheme, Aliasing aliasingType) {
        this.scalingPercentage = scalingPercentage;
        this.uiTheme = uiTheme;
        this.iconTheme = iconTheme;
        this.aliasingType = aliasingType;
    }

    /**
     * UI scaling setter.
     *
     * @param scalingPercentage is a string starting with a number and ending with a "%".
     */
    public void setScalingPercentage(String scalingPercentage) {
        this.scalingPercentage = scalingPercentage;
    }

    /**
     * UI scaling getter.
     *
     * @return the percentage as a string.
     */
    public String getScalingPercentage() {
        return scalingPercentage;
    }

    /**
     * UI theme setter.
     *
     * @param uiTheme can be either "light" or "dark". Anything else will break.
     */
    public void setUiTheme(String uiTheme) {
        this.uiTheme = uiTheme;
    }
    
    /**
     * UI theme getter.
     *
     * @return returns the ui theme.
     */
    public String getUiTheme() {
        return uiTheme;
    }

    /**
     * Icon theme setter.
     *
     * @param iconTheme same as {@link setUiTheme}, can be ither "light" or "dark".
     */
    public void setIconTheme(String iconTheme) {
        this.iconTheme = iconTheme;
    }

    /**
     * Icon theme getter.
     *
     * @return returns the icon theme.
     */
    public String getIconTheme() {
        return iconTheme;
    }

    /**
     * Aliasing type setter.
     *
     * @param aliasingType uses {@link Aliasing}.
     */
    public void setAliasingType(Aliasing aliasingType) {
        this.aliasingType = aliasingType;
    }

    /**
     * Aliasing type getter.
     *
     * @return the type of aliasing.
     */
    public Aliasing getAliasingType() {
        return aliasingType;
    }
}
