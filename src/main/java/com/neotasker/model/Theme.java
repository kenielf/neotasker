package com.neotasker.model;

import java.awt.Color;
import java.awt.Insets;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.inter.FlatInterFont;
import com.formdev.flatlaf.intellijthemes.FlatArcDarkOrangeIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;

/**
 * This class is responsible for setting and managing theme properties. This 
 * class must not be instantiated.
 */
public class Theme {
    /** This is the property key related to the UI scaling. */
    public static final String SCALING_PERCENTAGE_KEY = "flatlaf.uiScale";
    /** This is the minimum value for the UI scaling. */
    public static final String SCALING_MINIMUM = "25%";
    /** This is the default value for the UI scaling. */
    public static final String SCALING_DEFAULT = "100%";
    /** This is the maximum value for the UI scaling. */
    public static final String SCALING_MAXIMUM = "200%";
    /** This is the property key related to the UI theme. */
    public static final String UI_THEME_KEY = "UI_THEME";
    /** This is the default UI theme. */
    public static final String UI_THEME_DEFAULT = "light";
    /** This is the property key related to the icon theme. */
    public static final String ICON_THEME_KEY = "ICON_THEME";
    /** This is the default icon theme */
    public static final String ICON_THEME_DEFAULT = "dark";
    /** This is the default path for the application logo. */
    public static final String LOGO_ICON_PATH = "/icons/logo/neotasker.png";
    /** This is the property key related to the aliasing type. */
    public static final String ALIASING_CUSTOM_KEY = "ALIASING_TYPE";
    /** This is the property key related to the system synchronization of the aliasing type. */
    public static final String ALIASING_SYSTEM_SYNC_KEY = "awt.useSystemAAFontSettings";
    /** This is the property key related to the toggle of the aliasing type */
    public static final String ALIASING_SWING_TOGGLE_KEY = "swing.aatext";
    /** This is the default aliasing type */
    public static final Aliasing ALIASING_DEFAULT = Aliasing.SYSTEM;

    /**
     * Does nothing when instantiated.
     */
    Theme() {
    }

    /**
     * Initializes the theme settings for the entire application.
     *
     * @param scalingPercentage same as Configuration.setAntiAliasing.
     * @param uiTheme same as Configuration.setUiTheme.
     * @param iconTheme same as Configuration.iconTheme.
     * @param aliasingType same as Configuration.aliasingType.
     */
    public static void Initialize(String scalingPercentage, String uiTheme, String iconTheme, Aliasing aliasingType) {
        setScalingPercentage(scalingPercentage);
        setDefaultFonts();
        if (uiTheme.equals("dark")) {
            setDarkUiTheme();
        } else {
            setLightUiTheme();
        }
        setIconTheme(iconTheme);
        setAntiAliasing(aliasingType);
        setFlatLafPreferences();
    }

    /**
     * Scaling percentage setter for the whole application.
     *
     * @param percentage the value of the scaling percentage as a string with a "%".
     */
    public static void setScalingPercentage(String percentage) {
        System.setProperty(SCALING_PERCENTAGE_KEY, percentage);
    }

    /**
     * Scaling percentage getter for the whole application.
     *
     * @return the value of the scaling percentage as a string.
     */
    public static String getScalingPercentage() {
        return System.getProperty(SCALING_PERCENTAGE_KEY);
    }

    /**
     * UI theme setter.
     *
     * @param theme can be either "light" or "dark" - same as Configuration.
     */
    public static void setUiTheme(String theme) {
        System.setProperty(UI_THEME_KEY, theme);
    }

    /**
     * UI theme getter.
     *
     * @return the UI theme as a string.
     */
    public static String getUiTheme() {
        return System.getProperty(UI_THEME_KEY);
    }

    /**
     * Icon theme setter.
     *
     * @param theme can be either "light" or "dark" - same as Configuration.
     */
    public static void setIconTheme(String theme) {
        System.setProperty(ICON_THEME_KEY, theme);
    }

    /**
     * Icon theme getter.
     *
     * @return the icon theme as a string.
     */
    public static String getIconTheme() {
        return System.getProperty(ICON_THEME_KEY);
    }

    /**
     * Sets the UI theme to "light".
     */
    public static void setLightUiTheme() {
        try {
            setUiTheme("light");
            UIManager.setLookAndFeel(new FlatArcOrangeIJTheme());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sets the UI theme to "dark".
     */
    public static void setDarkUiTheme() {
        try {
            setUiTheme("dark");
            UIManager.setLookAndFeel(new FlatArcDarkOrangeIJTheme());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    /**
     * Aliasing type setter.
     *
     * @param option Uses {@link Aliasing} - same as Configuration.
     */
    public static void setAntiAliasing(Aliasing option) {
        switch (option) {
            default:
            case SYSTEM:
                System.setProperty(ALIASING_CUSTOM_KEY, Aliasing.SYSTEM.toString());
                System.clearProperty(ALIASING_SWING_TOGGLE_KEY);
                System.setProperty(ALIASING_SYSTEM_SYNC_KEY, "on");
                break;

            case ENABLED:
                System.setProperty(ALIASING_CUSTOM_KEY, Aliasing.ENABLED.toString());
                System.clearProperty(ALIASING_SYSTEM_SYNC_KEY);
                System.setProperty(ALIASING_SWING_TOGGLE_KEY, "on");
                break;

            case DISABLED:
                System.setProperty(ALIASING_CUSTOM_KEY, Aliasing.DISABLED.toString());
                System.clearProperty(ALIASING_SYSTEM_SYNC_KEY);
                System.setProperty(ALIASING_SWING_TOGGLE_KEY, "off");
        }
    }

    /**
     * Aliasing type getter.
     *
     * @return the aliasing type with {@link Aliasing}.
     */
    public static String getAntiAliasing() {
        return System.getProperty(ALIASING_CUSTOM_KEY);
    }

    /**
     * Get the path of an icon for 'GetResource()'.
     *
     * @param label the file name without extension.
     * @return the full relative path to the file with the extension added.
     */
    public static String getIcon(String label) {
        String iconPath = "/icons/" + getIconTheme() + "/" + label + ".png";
        return iconPath;
    }

    /**
     * Sets the default font for the whole application
     */
    public static void setDefaultFonts() {
        FlatInterFont.install();
        FlatLaf.setPreferredFontFamily( FlatInterFont.FAMILY );
        FlatLaf.setPreferredLightFontFamily( FlatInterFont.FAMILY_LIGHT );
        FlatLaf.setPreferredSemiboldFontFamily( FlatInterFont.FAMILY_SEMIBOLD );
    }

    /**
     * Sets the FlatLaf preferences, can be customized by changing the fields.
     */
    public static void setFlatLafPreferences() {
        //UIManager.put( "Button.arc", 999 );
        //UIManager.put( "Component.arc", 999 );
        //UIManager.put( "ProgressBar.arc", 999 );
        //UIManager.put( "TextComponent.arc", 999 );
        UIManager.put( "Component.arrowType", "chevron" );
        UIManager.put( "Component.innerFocusWidth", 1 );
        UIManager.put( "Button.innerFocusWidth", 1 );
        UIManager.put( "ScrollBar.trackArc", 999 );
        UIManager.put( "ScrollBar.thumbArc", 999 );
        UIManager.put( "ScrollBar.trackInsets", new Insets( 2, 4, 2, 4 ) );
        UIManager.put( "ScrollBar.thumbInsets", new Insets( 2, 2, 2, 2 ) );
        UIManager.put( "ScrollBar.track", new Color( 0xe0e0e0 ) );
    }
}

