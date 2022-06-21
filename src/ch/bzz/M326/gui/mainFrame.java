package ch.bzz.M326.gui;

import ch.bzz.M326.company.Company;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
    private Authentifizierung authentifizierung;
    private JFrame frame;
    /**
     * Constructor for the MainFrame
     */
    public mainFrame(Company company){
        setVisible(true);
        setResizable(false);
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pane = new JTabbedPane();
        this.frame = this;
        getContentPane().add(pane);

        uebersichtTab = new Uebersicht(pane, company);
        zuordnungTab = new Zuordnung(pane, company);
        personenTab = new Personen(pane, company);
        stammdatenTab = new Stammdaten(pane, company);
        logbuchTab = new Logbuch(pane, company);

        pane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                int temp = pane.getSelectedIndex();

                authentifizierung = new Authentifizierung(frame, company);
                switch (temp){
                    case 1:
                        if (authentifizierung.isCorrect()){
                            pane.setSelectedIndex(temp);
                        }else {
                            System.out.println("Selber Schuld!");
                        }
                        break;

                }

            }
        });

    }
}
