package ch.bzz.M326.gui;

import ch.bzz.M326.company.Company;

import javax.swing.*;
import java.awt.*;

/**
 * Unser Logbuch-GUI für das Programm
 */
public class Logbuch extends JPanel{
    /**
     * Komponenten für das logPanel
     */
    private JTabbedPane pane;
    private JPanel logPanel;
    private JScrollPane logScrollPane;
    private JTextArea logArea;

    private Company company;
    /**
     * Konstruktor für LogBuch
     * @param pane Weitergabe des JTabbedPanes
     */
    public Logbuch(JTabbedPane pane, Company company){
        this.pane = pane;
        this.company = company;

        logPanel = new JPanel(new BorderLayout());
        logArea = new JTextArea();
        logArea.setEditable(true);
        logScrollPane = new JScrollPane(logArea,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
        logPanel.add(logScrollPane, BorderLayout.CENTER);
        for (int i = 0; i < company.getLogBook().getSize(); i++) {
            logArea.setText(logArea.getText() + company.getLogBook().getEntry(i) + "\n");
        }
        pane.addTab("Logbuch",logPanel);
    }

}
