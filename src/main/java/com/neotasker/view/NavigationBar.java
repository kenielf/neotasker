package com.neotasker.view;

import com.neotasker.view.components.JPromptField;
import com.neotasker.view.*;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NavigationBar extends JPanel {

    public String theme;

    JButton btnList;
    JButton btnCalendar;
    JButton btnStats;
    JPromptField txtSearch;
    JButton btnSearch;
    JButton btnAdd;
    JButton btnConfig;

    public NavigationBar() {
        super();

        // Set Theme
        Theme theme = new Theme();
        theme.getTheme();


        // Set Layout
        setLayout(new MigLayout("fillx", "25[left]50[center]50[right]25"));

        // --------------- buttons  and  textField----------------

        // List Button
        this.btnList = new JButton();
        this.btnList.setIcon(new ImageIcon(getClass().getResource("/icons/" + Theme.getTheme() + "/list-light.png")));
        this.btnList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActivityList activityList = new ActivityList();
            }
        });

        // Calendar Button
        this.btnCalendar = new JButton();
        this.btnCalendar.setIcon(new ImageIcon(getClass().getResource("/icons/" + Theme.getTheme() + "/calendar-blank-light.png")));
        this.btnCalendar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CalendarWindow calendarWindow = new CalendarWindow();
            }
        });

        // Stats Button
        this.btnStats = new JButton();
        this.btnStats.setIcon(new ImageIcon(getClass().getResource("/icons/" + Theme.getTheme() + "/chart-pie-slice-light.png")));
        this.btnStats.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StatsWindow statsWindow = new StatsWindow();
            }
        });

        // Search Bar
        this.txtSearch = new JPromptField("Procure por uma atividade, evento ou data marcada...");
        this.txtSearch.setFont(txtSearch.getFont().deriveFont(22f));
        this.txtSearch.setColumns(48);

        // Search Button
        this.btnSearch = new JButton();
        this.btnSearch.setIcon(new ImageIcon(getClass().getResource("/icons/" + Theme.getTheme() + "/magnifying-glass-light.png")));

        // Add Button
        this.btnAdd = new JButton();
        this.btnAdd.setIcon(new ImageIcon(getClass().getResource("/icons/" + Theme.getTheme() + "/plus-square-light.png")));

        // Config Button
        this.btnConfig = new JButton();
        this.btnConfig.setIcon(new ImageIcon(getClass().getResource("/icons/" + Theme.getTheme() + "/gear-six-light.png")));
        this.btnConfig.setVisible(true);
        this.btnConfig.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConfigWindow configWindow = new ConfigWindow();
            }
        });

        // Add Components to Bar
        add(btnList, "split 3");
        add(btnCalendar, "");
        add(btnStats, "");
        add(this.txtSearch, "split 2, grow");
        add(this.btnSearch, "");
        add(this.btnAdd, "split 2");
        add(this.btnConfig, "");
    }
}
