package com.neotasker.view.landing;

import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.neotasker.platform.Constants;

import net.miginfocom.swing.MigLayout;

/**
 * This class is responsible for drawing the main frame of the application on 
 * the screen.
 */
public class Landing extends JFrame {
    /** The navigation bar. */
    public NavigationBar navBar;
    /** The content panel. */
    public ContentPanel content;

    /**
     * Instantiates the landing frame.
     */
    public Landing() {
        // Instantiate JFrame Properties
        super();

        // Define Properties
        setLayout(new MigLayout("fillx", "[center]"));
        setTitle(Constants.PROJECT_NAME);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800, 600));
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);

        // Add Frame Icon
        setIconImage(new ImageIcon(getClass()
            .getResource("/icons/logo/neotasker.png")).getImage()
        );

        // Add Components
        this.navBar = new NavigationBar();
        this.navBar.listButton.addActionListener(
            (ActionEvent e) -> content.switchToTasks()
        );
        this.navBar.calendarButton.addActionListener(
            (ActionEvent e) -> content.switchToCalendar()
        );
        this.navBar.statisticsButton.addActionListener(
            (ActionEvent e) -> content.switchToStatistics()
        );
        this.navBar.addButton.addActionListener(
            (ActionEvent e) -> content.switchToTaskCreation()
        );
        this.navBar.configurationButton.addActionListener(
            (ActionEvent e) -> content.switchToConfiguration()
        );

        // Content Pane
        this.content = new ContentPanel();

        // Add them
        add(this.navBar, "wrap");
        add(this.content, "growx, span");

        // Define Visibility
        setVisible(true);
    }
}
