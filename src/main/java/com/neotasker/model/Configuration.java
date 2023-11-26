package com.neotasker.model;

public class Configuration {
    private String scalingPercentage;
    private String uiTheme;
    private String iconTheme;
    private Aliasing aliasingType;

    public Configuration() {
    }

    public Configuration(String scalingPercentage, String uiTheme, String iconTheme, Aliasing aliasingType) {
        this.scalingPercentage = scalingPercentage;
        this.uiTheme = uiTheme;
        this.iconTheme = iconTheme;
        this.aliasingType = aliasingType;
    }

    public void setScalingPercentage(String scalingPercentage) {
        this.scalingPercentage = scalingPercentage;
    }

    public String getScalingPercentage() {
        return scalingPercentage;
    }

    public void setUiTheme(String uiTheme) {
        this.uiTheme = uiTheme;
    }
    
    public String getUiTheme() {
        return uiTheme;
    }

    public void setIconTheme(String iconTheme) {
        this.iconTheme = iconTheme;
    }

    public String getIconTheme() {
        return iconTheme;
    }

    public void setAliasingType(Aliasing aliasingType) {
        this.aliasingType = aliasingType;
    }

    public Aliasing getAliasingType() {
        return aliasingType;
    }
}
