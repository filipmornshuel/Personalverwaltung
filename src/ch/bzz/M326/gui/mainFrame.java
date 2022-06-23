package ch.bzz.M326.gui;

import ch.bzz.M326.company.AuthentificationFacade;
import ch.bzz.M326.company.Company;
import ch.bzz.M326.company.StammdatenFacade;
import ch.bzz.M326.employees.PersonErfassenFacade;
import ch.bzz.M326.employees.PersonenFacade;
import ch.bzz.M326.employees.UebersichtFacade;
import ch.bzz.M326.employees.ZuordnungFacade;
import ch.bzz.M326.log.LogBookFacade;

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
    public mainFrame(
        StammdatenFacade stammdatenFacade,
        AuthentificationFacade authentificationFacade,
        PersonenFacade personenFacade,
        PersonErfassenFacade personErfassenFacade,
        UebersichtFacade uebersichtFacade,
        ZuordnungFacade zuordnungFacade,
        LogBookFacade logBookFacade
    ){

        setVisible(true);
        setResizable(false);
        setSize(700,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.frame = this;
        pane = new JTabbedPane();
        getContentPane().add(pane);
        uebersichtTab = new Uebersicht(pane, uebersichtFacade);
        zuordnungTab = new Zuordnung(pane, zuordnungFacade);
        personenTab = new Personen(pane, personenFacade, personErfassenFacade);
        stammdatenTab = new Stammdaten(pane, stammdatenFacade);
        logbuchTab = new Logbuch(pane, logBookFacade);

        pane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (pane.getSelectedIndex() != 0){
                    authentifizierung = new Authentifizierung(frame, authentificationFacade, pane);
                }
            }
        });
    }
}
