package com.neotasker.model;

import java.awt.Color;
import java.awt.Insets;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.inter.FlatInterFont;
import com.formdev.flatlaf.intellijthemes.FlatArcDarkOrangeIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;

public class Theme {
    public static final String SCALING_PERCENTAGE_KEY = "flatlaf.uiScale";
    public static final String SCALING_MINIMUM = "25%";
    public static final String SCALING_DEFAULT = "100%";
    public static final String SCALING_MAXIMUM = "200%";
    public static final String UI_THEME_KEY = "UI_THEME";
    public static final String UI_THEME_DEFAULT = "light";
    public static final String ICON_THEME_KEY = "ICON_THEME";
    public static final String ICON_THEME_DEFAULT = "dark";
    public static final String LOGO_ICON_PATH = "/icons/logo/neotasker.png";
    public static final String ALIASING_CUSTOM_KEY = "ALIASING_TYPE";
    public static final String ALIASING_SYSTEM_SYNC_KEY = "awt.useSystemAAFontSettings";
    public static final String ALIASING_SWING_TOGGLE_KEY = "swing.aatext";
    public static final Aliasing ALIASING_DEFAULT = Aliasing.SYSTEM;

    Theme() {
    }

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

    public static void setScalingPercentage(String percentage) {
        System.setProperty(SCALING_PERCENTAGE_KEY, percentage);
    }

    public static String getScalingPercentage() {
        return System.getProperty(SCALING_PERCENTAGE_KEY);
    }

    public static void setUiTheme(String theme) {
        System.setProperty(UI_THEME_KEY, theme);
    }

    public static String getUiTheme() {
        return System.getProperty(UI_THEME_KEY);
    }

    public static void setIconTheme(String theme) {
        System.setProperty(ICON_THEME_KEY, theme);
    }

    public static String getIconTheme() {
        return System.getProperty(ICON_THEME_KEY);
    }

    public static void setLightUiTheme() {
        try {
            setUiTheme("light");
            UIManager.setLookAndFeel(new FlatArcOrangeIJTheme());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    public static void setDarkUiTheme() {
        try {
            setUiTheme("dark");
            UIManager.setLookAndFeel(new FlatArcDarkOrangeIJTheme());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

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

    public static String getAntiAliasing() {
        return System.getProperty(ALIASING_CUSTOM_KEY);
    }

    public static String getIcon(String label) {
        String iconPath = "/icons/" + getIconTheme() + "/" + label + ".png";
        return iconPath;
    }

    public static void setDefaultFonts() {
        FlatInterFont.install();
        FlatLaf.setPreferredFontFamily( FlatInterFont.FAMILY );
        FlatLaf.setPreferredLightFontFamily( FlatInterFont.FAMILY_LIGHT );
        FlatLaf.setPreferredSemiboldFontFamily( FlatInterFont.FAMILY_SEMIBOLD );
    }

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

