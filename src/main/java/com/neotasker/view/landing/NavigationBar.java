package com.neotasker.view.landing;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import com.neotasker.model.Theme;
import com.neotasker.view.basecomponents.JPromptField;

import net.miginfocom.swing.MigLayout;

public class NavigationBar extends JPanel {
    public static final float searchPromptFontSize = 22f;
    public static final int searchBarColumns = 48;

    JButton listButton;
    JButton calendarButton;
    JButton statisticsButton;
    JPromptField searchBar;
    JButton searchButton;
    JButton addButton;
    JButton configurationButton;
    JSeparator separator;

    public NavigationBar() {
        super();

        // Set Layout
        setLayout(new MigLayout("fillx", "25[left]50[center]50[right]25"));

        // Add Buttons
        this.listButton = new JButton();
        this.listButton.setIcon(
            new ImageIcon(getClass().getResource(
                Theme.getIcon("list-checks-light")
            ))
        );

        this.calendarButton = new JButton();
        this.calendarButton.setIcon(
            new ImageIcon(getClass().getResource(
                Theme.getIcon("calendar-blank-light")
            ))
        );

        // chart-pie-slice-light
        this.statisticsButton = new JButton();
        this.statisticsButton.setIcon(
            new ImageIcon(getClass().getResource(
                Theme.getIcon("chart-pie-slice-light")
            ))
        );

        this.searchBar = new JPromptField("Pesquisar Tarefas");
        this.searchBar.setFont(this.searchBar.getFont().deriveFont(searchPromptFontSize));
        this.searchBar.setColumns(searchBarColumns);

        this.searchButton = new JButton();
        this.searchButton.setIcon(
            new ImageIcon(getClass().getResource(
                Theme.getIcon("magnifying-glass-light")
            ))
        );

        this.addButton = new JButton();
        this.addButton.setIcon(
            new ImageIcon(getClass().getResource(
                Theme.getIcon("plus-circle-light")
            ))
        );

        this.configurationButton = new JButton();
        this.configurationButton.setIcon(
            new ImageIcon(getClass().getResource(
                Theme.getIcon("gear-six-light")
            ))
        );

        this.separator = new JSeparator(SwingConstants.HORIZONTAL);

        // Add Components to Bar
        add(this.listButton, "split 3");
        add(this.calendarButton, "");
        add(this.statisticsButton, "");
        add(this.searchBar, "split 2, grow");
        add(this.searchButton, "");
        add(this.addButton, "split 2");
        add(this.configurationButton, "wrap");
        add(this.separator, "growx, span");
    }

    public void UpdateIcons() {
        this.listButton.setIcon(
            new ImageIcon(getClass().getResource(
                Theme.getIcon("list-checks-light")
            ))
        );

        this.calendarButton.setIcon(
            new ImageIcon(getClass().getResource(
                Theme.getIcon("calendar-blank-light")
            ))
        );

        this.statisticsButton.setIcon(
            new ImageIcon(getClass().getResource(
                Theme.getIcon("chart-pie-slice-light")
            ))
        );

        this.searchButton.setIcon(
            new ImageIcon(getClass().getResource(
                Theme.getIcon("magnifying-glass-light")
            ))
        );

        this.addButton.setIcon(
            new ImageIcon(getClass().getResource(
                Theme.getIcon("plus-circle-light")
            ))
        );

        this.configurationButton.setIcon(
            new ImageIcon(getClass().getResource(
                Theme.getIcon("gear-six-light")
            ))
        );
    }
}
