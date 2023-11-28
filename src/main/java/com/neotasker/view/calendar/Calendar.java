package com.neotasker.view.calendar;

import java.time.DayOfWeek;
import java.util.Locale;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.UIManager;

import org.jdesktop.swingx.JXMonthView;
import org.jdesktop.swingx.SwingXUtilities;
import org.jdesktop.swingx.plaf.UIManagerExt;

import net.miginfocom.swing.MigLayout;

/**
 * This class is responsible for displaying the calendar panel.
 */
public class Calendar extends JPanel {
    /** The identifier for the Card Layout and label. */
    public static final String IDENTIFIER = "Calendário";
    /** The font size for the identifier. */
    public static final float IDENTIFIER_SIZE = 22f;
    /** The text label for the identifier. */
    public JLabel identifierLabel;
    public JSeparator identifierSeparator;

    public JPanel calendarPanel;
    public JXMonthView calendar;

    /**
     * Instantiates the calendar panel.
     */
    public Calendar() {
        setLayout(new MigLayout("fillx", "10%[left][center][right]10%"));

        this.identifierLabel = new JLabel(IDENTIFIER);
        this.identifierLabel.setFont(
            this.identifierLabel.getFont().deriveFont(IDENTIFIER_SIZE)
        );
        this.identifierSeparator = new JSeparator();

        this.calendarPanel = new JPanel();
        this.calendarPanel.setLayout(new MigLayout("fillx"));
        Locale lang = new Locale("pt", "BR");
        this.calendar = new JXMonthView();
        this.calendar.setSize(this.calendarPanel.getSize());
        this.calendar.setLocale(lang);
        this.calendar.setComponentInputMapEnabled(true);
        this.calendar.setFirstDayOfWeek(1);
        this.calendar.setShowingLeadingDays(true);
        this.calendar.setShowingTrailingDays(true);
        this.calendar.setTraversable(true);
        this.calendar.setZoomable(false);
        this.calendarPanel.add(this.calendar, "align center, span");
        //this.calendar.setFirstDayOfWeek(java.util.Calendar.SUNDAY);
        //this.calendar.setLayout(new MigLayout("fillx"));


        add(this.identifierLabel, "align left, wrap");
        add(this.identifierSeparator, "growx, span, wrap");
        add(this.calendarPanel, "growx, span, align center");
    }
}
