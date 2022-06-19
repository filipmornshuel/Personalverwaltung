package ch.bzz.M326.gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Unsere Zuordnung-GUI für das Programm
 */
public class Zuordnung extends JPanel {
    /**
     * Komponenten für das Erzeugen des GUIs
     */
    private JTabbedPane pane;
    private JLabel übersicht;
    private JList<String> personenListe;
    private ArrayList<String> personen;
    private JPanel personenPanel;
    private JPanel personenListPanel;
    private JPanel personenListButtonsPanel;
    private JPanel personenDetailPanel;
    private JPanel personenDetailBildMainPanel;
    private JPanel personenDetailBildNebenPanel;
    private JPanel personenDetailBildPanel;
    private JPanel personenDetailRollenPanel;
    private SpringLayout springLayout;
    private JScrollPane personenScrollPane;
    private GridBagConstraints gridBagConstraints;

    private JLabel name;
    private JTextField field;
    private JLabel platzhalter;
    private JLabel bild;
    private ImageIcon imageIcon;

    private JLabel abteilung;
    private JLabel funktion;
    private JLabel teams;
    private JTextField abteilungsField;
    private JComboBox funktionenBox;
    private JComboBox teamsBox;
    private ArrayList<String> funktionenListe;
    private ArrayList<String> teamsListe;


    /**
     * Konstruktor für das Aufrufen der createZurodnungComponents-Methode
     * @param pane Weitergabe des JTabbedPanes
     */
    public Zuordnung(JTabbedPane pane){
        this.pane = pane;

        createZuordnungComponents();
        pane.addTab("Zuordnung", personenPanel);

    }

    /**
     * Methode zum Initialisieren der Attribute
     */
    public void createZuordnungComponents(){

        personenPanel = new JPanel(new BorderLayout());
        personenListPanel = new JPanel(new BorderLayout());

        personenDetailPanel = new JPanel(new BorderLayout());
        personenDetailBildMainPanel = new JPanel(new BorderLayout());

        personenDetailBildPanel = new JPanel();
        springLayout = new SpringLayout();
        personenDetailBildPanel.setLayout(springLayout);


        personenDetailRollenPanel = new JPanel();
        personenDetailRollenPanel.setLayout(new GridBagLayout());
        gridBagConstraints = new GridBagConstraints();

        personenDetailBildNebenPanel = new JPanel();
        personenDetailBildNebenPanel.setLayout(new BoxLayout(personenDetailBildNebenPanel, BoxLayout.PAGE_AXIS));




        //Betreffend Liste
        personen = new ArrayList<>();
        for (int i = 0; i < 30; i++){
            personen.add("textjebigakockasdfghjk                  ");
        }
        personenPanel.setBorder(BorderFactory.createTitledBorder("Personen bearbeiten:"));
        personenListe = new JList<>();
        personenListe = new JList(personen.toArray());
        übersicht = new JLabel("Übersicht");
        personenScrollPane = new JScrollPane(personenListe,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
        personenListPanel.add(personenScrollPane, BorderLayout.CENTER);
        personenListPanel.add(übersicht, BorderLayout.NORTH);


        //DetailPanel betreffend
        personenDetailPanel.setBorder(BorderFactory.createTitledBorder("Detail:"));

        name = new JLabel("Name: ");
        field = new JTextField("Trulli Theo");
        platzhalter = new JLabel();
        bild = new JLabel();
        imageIcon = new ImageIcon("src/pic.png");
        bild.setIcon(imageIcon);

        abteilung = new JLabel("Abteilung: ");
        funktion = new JLabel("Funktion: ");
        teams = new JLabel("Teams: ");
        abteilungsField = new JTextField("Finance                     ");
        funktionenListe = new ArrayList<>();
        funktionenListe.add("Funktion wählen");
        teamsListe=new ArrayList<>();
        teamsListe.add("Team wählen");

        funktionenBox = new JComboBox(funktionenListe.toArray());
        teamsBox = new JComboBox(teamsListe.toArray());




        //personenDetailBildPanel.add(name);
        springLayout.putConstraint(SpringLayout.EAST, field, -90, SpringLayout.EAST, personenDetailBildPanel);
        springLayout.putConstraint(SpringLayout.NORTH, field, 0, SpringLayout.NORTH, personenDetailBildPanel);
        field.setColumns(20);
        personenDetailBildPanel.add(field);

        springLayout.putConstraint(SpringLayout.EAST, bild, 280, SpringLayout.WEST, personenDetailBildPanel);
        springLayout.putConstraint(SpringLayout.NORTH, bild, 50, SpringLayout.NORTH, personenDetailBildPanel);
        personenDetailBildPanel.add(bild);

        personenDetailBildNebenPanel.add(name);
        personenDetailBildNebenPanel.add(platzhalter);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy=0;
        personenDetailRollenPanel.add(abteilung, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy=0;
        personenDetailRollenPanel.add(abteilungsField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy=1;
        personenDetailRollenPanel.add(funktion, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy=1;
        personenDetailRollenPanel.add(funktionenBox, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy=2;
        personenDetailRollenPanel.add(teams, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy=2;
        personenDetailRollenPanel.add(teamsBox, gridBagConstraints);

        personenDetailBildMainPanel.add(personenDetailBildPanel, BorderLayout.CENTER);
        personenDetailBildMainPanel.add(personenDetailBildNebenPanel, BorderLayout.WEST);
        personenDetailBildMainPanel.add(new JSeparator(), BorderLayout.SOUTH);


        personenDetailPanel.add(personenDetailBildMainPanel, BorderLayout.CENTER);
        personenDetailPanel.add(personenDetailRollenPanel, BorderLayout.SOUTH);


        //ListPanel und DetailPanel zusammensetzen
        personenPanel.add(personenListPanel, BorderLayout.WEST);
        personenPanel.add(personenDetailPanel, BorderLayout.CENTER);

    }
}
