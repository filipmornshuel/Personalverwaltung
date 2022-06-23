package ch.bzz.M326.gui;

import ch.bzz.M326.company.Company;
import ch.bzz.M326.employees.UebersichtFacade;
import ch.bzz.M326.employees.ZuordnungFacade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


/**
 * Our Übersicht-GUI
 * @author Filip Slavkovic
 * @since 2022-06-22
 * @version 1.0
 */
public class Uebersicht extends JPanel {
    /**
     * Komponenten für das Erzeugen des GUIs
     */
    private Vector<String> abiszList;
    private Vector<String> zbisaList;
    private JTabbedPane pane;
    private JLabel übersicht;
    private JList<String> personenListe;
    private JPanel personenPanel;
    private JPanel personenListPanel;
    private JPanel personenSuchPanel;
    private JPanel personenSuchEingabePanel;
    private JPanel personenSuchButtonPanel;
    private JPanel personenDetailPanel;
    private JPanel personenDetailBildMainPanel;
    private JPanel personenDetailBildNebenPanel;
    private JPanel personenDetailBildPanel;
    private JPanel personenDetailRollenPanel;
    private SpringLayout springLayout;
    private JScrollPane personenScrollPane;
    private GridBagConstraints gridBagConstraints;

    private JTextField suchEingabe;
    private JButton suchButton;

    private JPanel mainPanel;

    private JLabel name;
    private JTextField field;
    private JLabel platzhalter;
    private JLabel bild;
    private ImageIcon imageIcon;

    private JLabel abteilung;
    private JLabel funktion;
    private JLabel teams;
    private JLabel abteilung1;
    private JLabel funktion1;
    private JLabel teams1;
    private JTextField abteilungsField;
    private JTextField funktionenBox;
    private JTextField teamsBox;
    private ArrayList<String> funktionenListe;
    private ArrayList<String> teamsListe;

    private JPanel sortierungPanel;
    private JPanel sortierungComboButton;
    private JPanel sortierKeine;
    private JPanel sortierAbisZ;
    private JPanel sortierZbisA;
    private JRadioButton keineBox;
    private JRadioButton aBisZBox;
    private JRadioButton zBisABox;

    private JPanel filterPanel;
    private JPanel filterComboList;
    private JPanel filterAbteilungList;
    private JPanel filterFunktionsList;
    private JPanel filterTeamList;
    private JComboBox filterAbteilungCombo;
    private JComboBox filterFunktionCombo;
    private JComboBox filterTeamCombo;


    private JPanel filterSortierPanel;

    private UebersichtFacade uebersichtFacade;

    /**
     * Konstruktor für das Aufrufen der createZurodnungComponents-Methode
     * @param pane Weitergabe des JTabbedPanes
     */
    public Uebersicht(JTabbedPane pane, UebersichtFacade uebersichtFacade){
        this.pane = pane;
        this.uebersichtFacade = uebersichtFacade;
        createZuordnungComponents();
        pane.addTab("Übersicht", mainPanel);

    }

    /**
     * Methode zum Initialisieren der Attribute
     */
    public void createZuordnungComponents(){

        mainPanel = new JPanel(new BorderLayout());

        personenPanel = new JPanel(new BorderLayout());
        personenPanel.setPreferredSize(new Dimension(450,290));
        personenListPanel = new JPanel(new BorderLayout());

        personenSuchPanel = new JPanel(new BorderLayout());
        personenSuchEingabePanel = new JPanel(new BorderLayout());
        personenSuchButtonPanel = new JPanel(new BorderLayout());


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

        sortierungPanel = new JPanel(new BorderLayout());
        sortierungComboButton = new JPanel(new BorderLayout());
        sortierKeine = new JPanel(new BorderLayout());
        sortierAbisZ = new JPanel(new BorderLayout());
        sortierZbisA = new JPanel(new BorderLayout());
        keineBox = new JRadioButton("keine");
        aBisZBox = new JRadioButton("A-Z");
        zBisABox = new JRadioButton("Z-A");




        filterPanel = new JPanel(new BorderLayout());
        filterComboList = new JPanel();
        filterComboList.setLayout(new GridBagLayout());
        filterAbteilungList = new JPanel(new BorderLayout());
        filterFunktionsList = new JPanel(new BorderLayout());
        filterTeamList = new JPanel(new BorderLayout());


        filterSortierPanel = new JPanel(new BorderLayout());


        mainPanel.setBorder(BorderFactory.createTitledBorder(""));


        //Betreffend Personen
        personenPanel.setBorder(BorderFactory.createTitledBorder("Personen:"));
        personenListe = new JList<>();

        übersicht = new JLabel("Übersicht");
        Vector<String> persons = new Vector(Arrays.asList(uebersichtFacade.getMitarbeiterNameListe().toArray()));
        Vector<String> oldPersons = new Vector(Arrays.asList(uebersichtFacade.getMitarbeiterNameListe().toArray()));
        personenListe = new JList(persons.toArray());
        personenListe.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() == 1) {
                    int index = personenListe.getSelectedIndex();
                    if (index >= 0) {
                        field.setText(uebersichtFacade.getMitarbeiterListe().get(index).getFristName()+ " "+uebersichtFacade.getMitarbeiterListe().get(index).getLastName());

                    }
                }
            }
        });
        personenScrollPane = new JScrollPane(personenListe,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
        personenListPanel.add(personenScrollPane, BorderLayout.CENTER);
        personenListPanel.add(übersicht, BorderLayout.NORTH);
        personenListPanel.add(personenSuchPanel, BorderLayout.SOUTH);
        personenSuchPanel.add(personenSuchEingabePanel, BorderLayout.SOUTH);
        personenSuchPanel.add(personenSuchButtonPanel, BorderLayout.NORTH);
        suchEingabe = new JTextField("Name eingeben");
        suchButton = new JButton();
        ImageIcon searchBild = new ImageIcon(new ImageIcon("src/search-bar.png").getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH));
        suchButton.setIcon(searchBild);
        personenSuchEingabePanel.add(suchEingabe, BorderLayout.CENTER);
        personenSuchButtonPanel.add(suchButton,BorderLayout.WEST);
        suchEingabe.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                suchEingabe.setText("");
            }
        });
        suchButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Vector<String> foundItem = new Vector();
                for (int i = 0; i < persons.size(); i++) {
                    if (persons.get(i).contains(suchEingabe.getText())){
                        foundItem.add(persons.get(i));
                    }
                }
                personenListe.setListData(foundItem);
            }
        });


        //DetailPanel betreffend
        personenDetailPanel.setBorder(BorderFactory.createTitledBorder("Detail:"));

        name = new JLabel("Name:");
        field = new JTextField(uebersichtFacade.getMitarbeiterNameListe().get(0));
        field.setEditable(false);
        platzhalter = new JLabel();
        bild = new JLabel();
        imageIcon = new ImageIcon(new ImageIcon("src/pic.png").getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));
        bild.setIcon(imageIcon);

        abteilung = new JLabel("Abteilung: ");
        funktion = new JLabel("Funktion: ");
        teams = new JLabel("Teams: ");
        abteilung1 = new JLabel("Abteilung: ");
        funktion1 = new JLabel("Funktion: ");
        teams1 = new JLabel("Teams: ");
        abteilungsField = new JTextField(uebersichtFacade.getMitarbeiterListe().get(0).getDepartment().getName());
        abteilungsField.setEditable(false);
        abteilungsField.setPreferredSize(new Dimension(220, 20));
        funktionenListe = new ArrayList<>();
        funktionenListe.add("Funktion wählen");
        teamsListe=new ArrayList<>();
        teamsListe.add("Team wählen");

        funktionenBox = new JTextField(uebersichtFacade.getMitarbeiterListe().get(0).getJobfunction());
        funktionenBox.setPreferredSize(new Dimension(150, 30));
        teamsBox = new JTextField(uebersichtFacade.getMitarbeiterListe().get(0).getTeam());
        teamsBox.setPreferredSize(new Dimension(150, 30));
        funktionenBox.setEditable(false);
        teamsBox.setEditable(false);



        //personenDetailBildPanel.add(name);
        springLayout.putConstraint(SpringLayout.EAST, field, -90, SpringLayout.EAST, personenDetailBildPanel);
        springLayout.putConstraint(SpringLayout.NORTH, field, 0, SpringLayout.NORTH, personenDetailBildPanel);
        field.setColumns(20);
        personenDetailBildPanel.add(field);

        springLayout.putConstraint(SpringLayout.EAST, bild, 220, SpringLayout.WEST, personenDetailBildPanel);
        springLayout.putConstraint(SpringLayout.NORTH, bild, 20, SpringLayout.NORTH, personenDetailBildPanel);
        personenDetailBildPanel.add(bild);

        personenDetailBildNebenPanel.add(name);
        personenDetailBildNebenPanel.add(platzhalter);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy=0;
        personenDetailRollenPanel.add(abteilung1, gridBagConstraints);

        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy=0;
        personenDetailRollenPanel.add(abteilungsField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy=1;
        personenDetailRollenPanel.add(funktion1, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy=1;
        personenDetailRollenPanel.add(funktionenBox, gridBagConstraints);

        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy=1;
        personenDetailRollenPanel.add(teams1, gridBagConstraints);

        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy=1;
        personenDetailRollenPanel.add(teamsBox, gridBagConstraints);

        personenDetailBildMainPanel.add(personenDetailBildPanel, BorderLayout.CENTER);
        personenDetailBildMainPanel.add(personenDetailBildNebenPanel, BorderLayout.WEST);
        personenDetailBildMainPanel.add(new JSeparator(), BorderLayout.SOUTH);


        personenDetailPanel.add(personenDetailBildMainPanel, BorderLayout.CENTER);
        personenDetailPanel.add(personenDetailRollenPanel, BorderLayout.SOUTH);

        //Sortier
        sortierungPanel.setBorder(BorderFactory.createTitledBorder("Sortierung:"));
        sortierungPanel.setPreferredSize(new Dimension(180,140));
        sortierungPanel.add(sortierungComboButton, BorderLayout.EAST);
        sortierungComboButton.add(sortierKeine, BorderLayout.NORTH);
        sortierungComboButton.add(sortierAbisZ, BorderLayout.CENTER);
        sortierungComboButton.add(sortierZbisA, BorderLayout.SOUTH);
        sortierKeine.add(keineBox, BorderLayout.CENTER);
        sortierAbisZ.add(aBisZBox, BorderLayout.CENTER);
        sortierZbisA.add(zBisABox, BorderLayout.CENTER);
        keineBox.setSelected(true);
        abiszList = new Vector<>(persons);
        Collections.sort(abiszList);
        zbisaList = new Vector<>(persons);
        Collections.sort(zbisaList, Comparator.reverseOrder());
        keineBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                keineBox.setSelected(true);
                if (keineBox.isSelected() == true){
                    aBisZBox.setSelected(false);
                    zBisABox.setSelected(false);
                    personenListe.setListData(persons);
                }
            }
        });

        aBisZBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (aBisZBox.isSelected() == true){
                    keineBox.setSelected(false);
                    zBisABox.setSelected(false);
                    personenListe.setListData(abiszList);
                }
            }
        });

        zBisABox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (zBisABox.isSelected() == true){
                    keineBox.setSelected(false);
                    aBisZBox.setSelected(false);
                    personenListe.setListData(zbisaList);
                }
            }
        });


        //Filter
        filterPanel.setBorder(BorderFactory.createTitledBorder("Filter:"));
        filterPanel.setPreferredSize(new Dimension(550,110));
        filterPanel.add(filterComboList, BorderLayout.CENTER);
        filterComboList.setPreferredSize(new Dimension(550,110));
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy=0;
        filterComboList.add(filterAbteilungList, gridBagConstraints);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy=0;
        filterComboList.add(abteilung, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy=1;
        filterComboList.add(filterFunktionsList, gridBagConstraints);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy=1;
        filterComboList.add(funktion, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy=2;
        filterComboList.add(filterTeamList, gridBagConstraints);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy=2;
        filterComboList.add(teams, gridBagConstraints);
        filterAbteilungCombo = new JComboBox(uebersichtFacade.getAllDepartments().toArray());
        filterFunktionCombo = new JComboBox(uebersichtFacade.getAllJobFunctions().toArray());
        filterTeamCombo = new JComboBox(uebersichtFacade.getAllTeams().toArray());
        filterAbteilungCombo.setPreferredSize(new Dimension(200,30));
        filterFunktionCombo.setPreferredSize(new Dimension(200,30));
        filterTeamCombo.setPreferredSize(new Dimension(200, 30));
        filterAbteilungList.add(filterAbteilungCombo);
        filterFunktionsList.add(filterFunktionCombo);
        filterTeamList.add(filterTeamCombo);
        filterAbteilungCombo.setEditable(false);
        filterTeamCombo.setEditable(false);
        filterFunktionCombo.setEditable(false);
        filterAbteilungCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < uebersichtFacade.getAllDepartments().size(); i++) {
                    if (filterAbteilungCombo.getSelectedItem() == uebersichtFacade.getMitarbeiterListe().get(i).getDepartment()){
                        Vector<String> abteilungfilterlist = new Vector<>();
                        abteilungfilterlist.add(uebersichtFacade.getMitarbeiterListe().get(i).getName());
                    }
                }
            }
        });
        filterTeamCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < uebersichtFacade.getAllDepartments().size(); i++) {
                    if (filterAbteilungCombo.getSelectedItem() == uebersichtFacade.getMitarbeiterListe().get(i).getTeam()){
                        Vector<String> teamfilterlist = new Vector<>();
                        teamfilterlist.add(uebersichtFacade.getMitarbeiterListe().get(i).getName());
                    }
                }
            }
        });
        filterFunktionCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vector<String> funktionfilterlist = new Vector<>();
                for (int i = 0; i < uebersichtFacade.getAllDepartments().size(); i++) {
                    if (filterAbteilungCombo.getSelectedItem() == uebersichtFacade.getMitarbeiterListe().get(i).getJobfunction()){
                        funktionfilterlist.add(uebersichtFacade.getMitarbeiterListe().get(i).getName());
                    }
                }
                personenListe.setListData(funktionfilterlist);
            }
        });
        filterFunktionCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vector<String> funktionfilterlist = new Vector<>();
                for (int i = 0; i < uebersichtFacade.getAllDepartments().size(); i++) {
                    if (filterAbteilungCombo.getSelectedItem() == uebersichtFacade.getMitarbeiterListe().get(i).getJobfunction()){
                        funktionfilterlist.add(uebersichtFacade.getMitarbeiterListe().get(i).getName());
                    }
                }
                personenListe.setListData(funktionfilterlist);
            }
        });
        filterAbteilungCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vector<String> abteilungFilterlist = new Vector<>();
                for (int i = 0; i < uebersichtFacade.getAllDepartments().size(); i++) {
                    if (filterAbteilungCombo.getSelectedItem() == uebersichtFacade.getMitarbeiterListe().get(i).getDepartment()){
                        abteilungFilterlist.add(uebersichtFacade.getMitarbeiterListe().get(i).getName());
                    }
                }
                personenListe.setListData(abteilungFilterlist);
            }
        });
        filterTeamCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vector<String> teamfilterlist = new Vector<>();
                for (int i = 0; i < uebersichtFacade.getAllTeams().size(); i++) {
                    if (filterTeamCombo.getSelectedItem() == uebersichtFacade.getMitarbeiterListe().get(i).getTeam()){
                        teamfilterlist.add(uebersichtFacade.getMitarbeiterListe().get(i).getName());
                    }
                }
                personenListe.setListData(teamfilterlist);
            }
        });


        personenListe.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() == 1) {
                    int index = personenListe.getSelectedIndex();
                    if (index >= 0) {
                        field.setText(uebersichtFacade.getMitarbeiterListe().get(index).getFristName()+ " "+uebersichtFacade.getMitarbeiterListe().get(index).getLastName());
                        abteilungsField.setText(uebersichtFacade.getMitarbeiterListe().get(index).getDepartment().getName());
                        funktionenBox.setText(uebersichtFacade.getMitarbeiterListe().get(index).getJobfunction());
                        teamsBox.setText(uebersichtFacade.getMitarbeiterListe().get(index).getTeam());
                    }
                }
            }
        });


        //Panels zusammensetzen
        mainPanel.add(personenPanel, BorderLayout.NORTH);
        mainPanel.add(filterSortierPanel, BorderLayout.SOUTH);
        personenPanel.add(personenListPanel, BorderLayout.WEST);
        personenPanel.add(personenDetailPanel, BorderLayout.CENTER);
        filterSortierPanel.add(sortierungPanel, BorderLayout.WEST);
        filterSortierPanel.add(filterPanel, BorderLayout.EAST);



    }
}
