package ch.bzz.M326.gui;

import ch.bzz.M326.company.Company;

import javax.swing.*;

/**
 * The MainFrame all panes find here the path
 */
public class mainFrame extends JFrame {
    /**
     * Components for the MainFrame
     */
    private JTabbedPane pane;
    private Logbuch logbuchTab;
    private Stammdaten stammdatenTab;
    private Personen personenTab;
    private Zuordnung zuordnungTab;
    private Uebersicht uebersichtTab;

    /**
     * Constructor for the MainFrame
     */
    public mainFrame(Company company){
        setVisible(true);
        setResizable(false);
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pane = new JTabbedPane();
        getContentPane().add(pane);
        uebersichtTab = new Uebersicht(pane, company);
        zuordnungTab = new Zuordnung(pane, company);
        personenTab = new Personen(pane, company);
        stammdatenTab = new Stammdaten(pane, company);
        logbuchTab = new Logbuch(pane, company);
    }
}
