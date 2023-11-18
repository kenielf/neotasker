package com.neotasker.view;

import com.neotasker.view.components.JPromptField;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class NavigationBar extends JPanel {
    public String theme;

    JButton listButton;
    JButton calendarButton;
    JButton statisticsButton;
    JPromptField searchBar;
    JButton searchButton;
    JButton addButton;
    JButton configurationButton;

    public NavigationBar() {
        super();

        // Set Layout
        setLayout(new MigLayout("fillx", "25[left]50[center]50[right]25"));

        // Add Buttons
        this.listButton = new JButton();
        this.listButton.setIcon(
                new ImageIcon(
                        getClass().getResource("/icons/" + Theme.getTheme() + "/list-light.png")));

        this.calendarButton = new JButton();
        this.calendarButton.setIcon(
                new ImageIcon(
                        getClass()
                                .getResource(
                                        "/icons/"
                                                + Theme.getTheme()
                                                + "/calendar-blank-light.png")));

        this.statisticsButton = new JButton();
        this.statisticsButton.setIcon(
                new ImageIcon(
                        getClass()
                                .getResource(
                                        "/icons/"
                                                + Theme.getTheme()
                                                + "/chart-pie-slice-light.png")));

        this.searchBar = new JPromptField("Pesquisar Tasks");
        this.searchBar.setFont(searchBar.getFont().deriveFont(22f));
        this.searchBar.setColumns(48);

        this.searchButton = new JButton();
        this.searchButton.setIcon(
                new ImageIcon(
                        getClass()
                                .getResource(
                                        "/icons/"
                                                + Theme.getTheme()
                                                + "/magnifying-glass-light.png")));

        this.addButton = new JButton();
        this.addButton.setIcon(
                new ImageIcon(
                        getClass()
                                .getResource(
                                        "/icons/" + Theme.getTheme() + "/plus-square-light.png")));

        this.configurationButton = new JButton();
        this.configurationButton.setIcon(
                new ImageIcon(
                        getClass()
                                .getResource(
                                        "/icons/" + Theme.getTheme() + "/gear-six-light.png")));
        this.configurationButton.setVisible(true);

        // Add Components to Bar
        add(listButton, "split 3");
        add(calendarButton, "");
        add(statisticsButton, "");
        add(this.searchBar, "split 2, grow");
        add(this.searchButton, "");
        add(this.addButton, "split 2");
        add(this.configurationButton, "");
    }
}
