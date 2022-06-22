package ch.bzz.M326.gui;

import ch.bzz.M326.company.Company;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * The mainframe of all TabbedPanes
 * @author Filip Slavkovic
 * @since 2022-06-22
 * @version 1.0
 */
public class mainFrame extends JFrame {
    private JTabbedPane pane;
    private Logbuch logbuchTab;
    private Stammdaten stammdatenTab;
    private Personen personenTab;
    private Zuordnung zuordnungTab;
    private Uebersicht uebersichtTab;
    private Authentifizierung authentifizierung;
    private JFrame frame;
    private int cnt = 1;

    /**
     * Constructor to set all components to the Panel
     */
    public mainFrame(Company company){

        setVisible(true);
        setResizable(false);
        setSize(700,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.frame = this;
        pane = new JTabbedPane();
        getContentPane().add(pane);
        uebersichtTab = new Uebersicht(pane, company);
        zuordnungTab = new Zuordnung(pane, company);
        personenTab = new Personen(pane, company);
        stammdatenTab = new Stammdaten(pane, company);
        logbuchTab = new Logbuch(pane, company);

        pane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (pane.getSelectedIndex() != 0){
                    authentifizierung = new Authentifizierung(frame, company, pane);
                }
            }
        });
    }
}
