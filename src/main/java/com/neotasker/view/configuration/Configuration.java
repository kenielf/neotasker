package com.neotasker.view.configuration;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;

import com.formdev.flatlaf.FlatLaf;
import com.neotasker.controllers.ConfigurationController;
import com.neotasker.model.Aliasing;
import com.neotasker.model.Theme;
import com.neotasker.view.landing.Landing;

import net.miginfocom.swing.MigLayout;

/**
 * This class is responsible for graphically managing the configuration of
 * the application.
 */
public class Configuration extends JPanel {
    /** The identifier for the Card Layout and Label. */
    public static final String IDENTIFIER = "Configuração";
    /** The font size for the identifier. */
    public static final float IDENTIFIER_SIZE = 22f;
    /** The font size for the individual sections. */
    public static final float SECTION_SIZE = 16;

    /** The pane identifier label. */
    public JLabel identifierLabel;
    /** The pane separator. */
    public JSeparator identifierSeparator;

    /** The label for the theme section of the configuration. */
    public JLabel themeSectionLabel;

    /** The text label for the scaling option. */
    public JLabel scalingLabel;
    /** The display text for the scaling option. */
    public JLabel scalingValue;
    /** The slider for the scaling percentage. */
    public JSlider scalingSlider;
    /** The event timer to set the scaling percentage after one second. */
    public Timer scalingTimer;

    /** The text label for the UI theme option. */
    public JLabel uiThemeLabel;
    /** The mutually exclusive button group for the theme options. **/
    public ButtonGroup uiThemeButtons;
    /** The light theme option button **/
    public JRadioButton uiThemeLightButton;
    /** The dark theme option button **/
    public JRadioButton uiThemeDarkButton;

    /** The text label for the icon theme option. */
    public JLabel iconThemeLabel;
    /** The mutually exclusive button group for the icon theme options. **/
    public ButtonGroup iconThemeButtons;
    /** The light icon theme option button **/
    public JRadioButton iconThemeLightButton;
    /** The light icon theme option button **/
    public JRadioButton iconThemeDarkButton;

    /** The text label for the aliasing type option. */
    public JLabel aliasingSectionLabel;
    /** The mutually exclusive button group for the aliasing type options. **/
    public ButtonGroup aliasingButtons;
    /** Graphically set the aliasing type to "System". */
    public JRadioButton aliasingSystemButton;
    /** Graphically set the aliasing type to "On". */
    public JRadioButton aliasingOnButton;
    /** Graphically set the aliasing type to "Off". */
    public JRadioButton aliasingOffButton;

    /**
     * Instantiates the configuration panel.
     */
    public Configuration() {
        setLayout(new MigLayout("fillx", "10%[left][center][right]10%"));

        this.identifierLabel = new JLabel(IDENTIFIER);
        this.identifierLabel.setFont(
            this.identifierLabel.getFont().deriveFont(IDENTIFIER_SIZE)
        );
        this.identifierSeparator = new JSeparator(JSeparator.HORIZONTAL);

        // Add UI Theme Configuration
        this.themeSectionLabel = new JLabel("Tema");
        this.themeSectionLabel.setFont(this.themeSectionLabel
            .getFont().deriveFont(IDENTIFIER_SIZE)
        );


        // Add UI Scaling Configuration
        this.scalingLabel = new JLabel("Escala da Interface");
        this.scalingValue = new JLabel(Theme.getScalingPercentage());
        this.scalingSlider = new JSlider(JSlider.HORIZONTAL,
            Integer.parseInt(Theme.SCALING_MINIMUM.replace("%", "")),
            Integer.parseInt(Theme.SCALING_MAXIMUM.replace("%", "")),
            100
            //Integer.parseInt(Theme.getScalingPercentage().replace("%", ""))
        );
        this.scalingSlider.setValue(
            Integer.parseInt(Theme.getScalingPercentage().replace("%", ""))
        );
        this.scalingSlider.setPaintTicks(true);
        this.scalingSlider.setPaintTrack(true);
        this.scalingSlider.setPaintLabels(true);
        this.scalingSlider.setMajorTickSpacing(25);
        this.scalingSlider.setMinorTickSpacing(5);
        this.scalingSlider.addChangeListener(
            (ChangeEvent e) -> scalingTimer.restart()
        );
        this.scalingSlider.addChangeListener(
            (ChangeEvent e) -> this.scalingValue.setText(
                String.format("%d%%", this.scalingSlider.getValue())
            )
        );
        this.scalingTimer = new Timer(1000, (ActionEvent e) -> setScalingValue());
        this.scalingTimer.setRepeats(false);

        // Add UI Theme Configuration
        this.uiThemeLabel = new JLabel("Tema da Interface");
        this.uiThemeButtons = new ButtonGroup();
        this.uiThemeLightButton = new JRadioButton("Claro");
        this.uiThemeLightButton.addItemListener(
            (ItemEvent e) -> {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    this.setLightUITheme();
                }
            }
        );
        this.uiThemeButtons.add(this.uiThemeLightButton);
        this.uiThemeDarkButton = new JRadioButton("Escuro");
        this.uiThemeDarkButton.addItemListener(
            (ItemEvent e) -> {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    this.setDarkUITheme();
                }
            }
        );
        this.uiThemeButtons.add(this.uiThemeDarkButton);

        if (Theme.getUiTheme().equals("light")) {
            this.uiThemeLightButton.setSelected(true);
        } else {
            this.uiThemeDarkButton.setSelected(true);
        }

        // Add Icon Theme Configuration
        this.iconThemeLabel = new JLabel("Tema dos Ícones");
        this.iconThemeButtons = new ButtonGroup();
        this.iconThemeLightButton = new JRadioButton("Claro");
        this.iconThemeLightButton.addActionListener(
            (ActionEvent e) -> setIconLightTheme()
        );
        this.iconThemeButtons.add(this.iconThemeLightButton);
        this.iconThemeDarkButton = new JRadioButton("Escuro");
        this.iconThemeDarkButton.addActionListener(
            (ActionEvent e) -> setIconDarkTheme()
        );
        this.iconThemeButtons.add(this.iconThemeDarkButton);

        if (Theme.getIconTheme().equals("light")) {
            this.iconThemeLightButton.setSelected(true);
        } else {
            this.iconThemeDarkButton.setSelected(true);
        }
        

        // Add Aliasing Configuration
        this.aliasingSectionLabel = new JLabel("Anti-Serrilhado");
        this.aliasingButtons = new ButtonGroup();
        this.aliasingSystemButton = new JRadioButton("Sistema");
        this.aliasingSystemButton.addActionListener(
            (ActionEvent e) -> setAliasingSystem()
        );
        this.aliasingButtons.add(this.aliasingSystemButton);
        this.aliasingOnButton = new JRadioButton("Habilitado");
        this.aliasingOnButton.addActionListener(
            (ActionEvent e) -> setAliasingOn()
        );
        this.aliasingButtons.add(this.aliasingOnButton);
        this.aliasingOffButton = new JRadioButton("Desabilitado");
        this.aliasingOffButton.addActionListener(
            (ActionEvent e) -> setAliasingOff()
        );
        this.aliasingButtons.add(this.aliasingOffButton);

        Aliasing aliasing = Aliasing.valueOf(Theme.getAntiAliasing());
        switch (aliasing) {
            case SYSTEM:
                this.aliasingSystemButton.setSelected(true);
                break;
            case ENABLED:
                this.aliasingOnButton.setSelected(true);
                break;
            case DISABLED:
                this.aliasingOffButton.setSelected(true);
                break;
        }

        // Add content
        add(this.identifierLabel, "align center, span, wrap");
        add(this.identifierSeparator, "span, growx, wrap");

        add(this.themeSectionLabel, "align left, wrap");

        add(this.scalingLabel, "align left");
        add(this.scalingValue, "align right, wrap");
        add(this.scalingSlider, "gapleft 5%, gapright 5%, growx, span");

        add(this.uiThemeLabel, "align left");
        add(this.uiThemeLightButton, "align right, split 2");
        add(this.uiThemeDarkButton, "wrap");

        add(this.iconThemeLabel, "align left");
        add(this.iconThemeLightButton, "align right, split 2");
        add(this.iconThemeDarkButton, "wrap");

        add(this.aliasingSectionLabel, "align left");
        add(this.aliasingSystemButton, "align right, split 3");
        add(this.aliasingOnButton, "");
        add(this.aliasingOffButton, "wrap");
    }

    /**
     * Reloads the entire Look and Feel of the application.
     */
    public void resetUITheme() {
        if (Theme.getUiTheme().equals("light")) {
            setLightUITheme();
        } else {
            setDarkUITheme();
        }
    }

    /**
     * Modifies the scaling value according to user input.
     */
    public void setScalingValue() {
        if (this.scalingSlider != null) {
            String percentage = String.format("%d%%", this.scalingSlider.getValue());
            Theme.setScalingPercentage(percentage);
            ConfigurationController.updateConfiguration();
            resetUITheme();
            resetWindow();
        }
    }

    /**
     * Graphically sets the UI theme to "light".
     */
    public void setLightUITheme() {
        Theme.setLightUiTheme();
        ConfigurationController.updateConfiguration();
        resetWindow();
    }

    /**
     * Graphically sets the UI theme to "dark".
     */
    public void setDarkUITheme() {
        Theme.setDarkUiTheme();
        ConfigurationController.updateConfiguration();
        resetWindow();
    }

    /**
     * Graphically sets the icon theme to "light".
     */
    public void setIconLightTheme() {
        Theme.setIconTheme("light");
        ConfigurationController.updateConfiguration();
        resetWindow();
    }

    /**
     * Graphically sets the icon theme to "dark".
     */
    public void setIconDarkTheme() {
        Theme.setIconTheme("dark");
        ConfigurationController.updateConfiguration();
        resetWindow();
    }

    /**
     * Graphically sets the aliasing type to "System".
     */
    public void setAliasingSystem() {
        Theme.setAntiAliasing(Aliasing.SYSTEM);
        ConfigurationController.updateConfiguration();
        resetUITheme();
        resetWindow();
    }

    /**
     * Graphically sets the aliasing type to "On".
     */
    public void setAliasingOn() {
        Theme.setAntiAliasing(Aliasing.ENABLED);
        ConfigurationController.updateConfiguration();
        resetUITheme();
        resetWindow();
    }

    /**
     * Graphically sets the aliasing type to "Off".
     */
    public void setAliasingOff() {
        Theme.setAntiAliasing(Aliasing.DISABLED);
        ConfigurationController.updateConfiguration();
        resetUITheme();
        resetWindow();
    }

    /**
     * Resets and updates all window components.
     */
    private void resetWindow() {
        Landing rootWindow = (Landing) SwingUtilities.getRoot(this);
        if (rootWindow != null) {
            FlatLaf.revalidateAndRepaintAllFramesAndDialogs();
            SwingUtilities.updateComponentTreeUI(rootWindow);
            rootWindow.navBar.UpdateIcons();
        }
    }
}
