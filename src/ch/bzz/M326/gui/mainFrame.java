package ch.bzz.M326.gui;

import javax.swing.*;

/**
 * Das MainFrame, indem alle Panes zueinanderfinden
 */
public class mainFrame extends JFrame {
    /**
     * Komponenten für das MainFrame
     */
    private JTabbedPane pane;
    private Logbuch logbuchTab;
    private Stammdaten stammdatenTab;
    private Personen personenTab;
    private Zuordnung zuordnungTab;

    /**
     * Konstruktor für das MainFrame
     */
    public mainFrame(){
        setVisible(true);
        setResizable(false);
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pane = new JTabbedPane();
        getContentPane().add(pane);
        zuordnungTab = new Zuordnung(pane);
        personenTab = new Personen(pane);
        stammdatenTab = new Stammdaten(pane);
        logbuchTab = new Logbuch(pane);
    }
}
