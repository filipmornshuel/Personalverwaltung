package ch.bzz.M326.gui;

import ch.bzz.M326.company.Company;
import ch.bzz.M326.log.LogBookFacade;

import javax.swing.*;
import java.awt.*;

/**
 * Our Logbuch-GUI
 * @author Filip Slavkovic
 * @since 2022-06-22
 * @version 1.0
 */
public class Logbuch extends JPanel{
    private JTabbedPane pane;
    private JPanel logPanel;
    private JScrollPane logScrollPane;
    private JTextArea logArea;

    private LogBookFacade logBookFacade;
    /**
     * Constructor for the LogBuch
     * @param pane to set the JTabbedPane
     * @param logBookFacade to set the facade
     */
    public Logbuch(JTabbedPane pane, LogBookFacade logBookFacade){
        this.pane = pane;
        this.logBookFacade = logBookFacade;

        logPanel = new JPanel(new BorderLayout());
        logArea = new JTextArea();
        logArea.setEditable(true);
        logScrollPane = new JScrollPane(logArea,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
        logPanel.add(logScrollPane, BorderLayout.CENTER);
        for (int i = 0; i < logBookFacade.getAllEntries(logBookFacade.getLogBook()).size(); i++) {
            logArea.setText(logArea.getText() + logBookFacade.getLogBook().getEntry(i) + "\n");
        }
        pane.addTab("Logbuch",logPanel);
    }

}
