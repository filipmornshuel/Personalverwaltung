package ch.bzz.M326.gui;

import ch.bzz.M326.company.Company;
import ch.bzz.M326.employees.Person;
import ch.bzz.M326.employees.PersonErfassenFacade;
import ch.bzz.M326.employees.PersonenFacade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Our Personen-GUI
 * @author Filip Slavkovic
 * @since 2022-06-20
 * @version 1.0
 */
public class Personen extends JPanel {
    private JTabbedPane pane;
    private JLabel uebersicht;
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
    private JButton delete;
    private JButton bearbeiten;
    private JButton create;

    private JLabel name;
    private JTextField field;
    private JLabel platzhalter;
    private JLabel bild;
    private ImageIcon imageIcon;

    private JCheckBox hrM;
    private JCheckBox adminstrator;

    private PersonenFacade personenFacade;
    private PersonErfassenFacade personErfassenFacade;
    DefaultListModel<String> modelPersonen;

    /**
     * Constructor to run the createPersonenComponents-Method and initializePanels-Method
     * @param pane to set the JTabbedPane
     * @param personenFacade to set the facade
     */
    public Personen(JTabbedPane pane, PersonenFacade personenFacade, PersonErfassenFacade personErfassenFacade){
        this.pane = pane;
        this.personenFacade = personenFacade;
        this.personErfassenFacade = personErfassenFacade;
        initializePanels();
        createPersonenComponents();
        pane.addTab("Personen", personenPanel);
    }

    /**
     * Method to initialize Panels
     */
    public void initializePanels(){
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

        personenListButtonsPanel = new JPanel(new GridLayout(1,3));
    }

    /**
     * Method to initialize all components and adding to the panels
     */
    public void createPersonenComponents(){

        modelPersonen = new DefaultListModel<>();
        for (int i = 0; i < personenFacade.getMitarbeiterListe().size(); i++) {
            modelPersonen.addElement(personenFacade.getMitarbeiterNameListe().get(i));
        }
        //Components
        name = new JLabel("Name: ");
        platzhalter = new JLabel();
        field = new JTextField(personenFacade.getMitarbeiterNameListe().get(0));
        bild = new JLabel();
        imageIcon = new ImageIcon("src/pic.png");
        bild.setIcon(imageIcon);

        //Detail-Checkbox
        hrM = new JCheckBox("HR-Mtiarbeiter");
        adminstrator = new JCheckBox("Adminstrator: ");

        //ListButtons
        delete = new JButton("Delete");
        bearbeiten = new JButton("Edit");
        create = new JButton("New");

        //List
        personenListe = new JList<>();
        personenListe = new JList<>(modelPersonen);
        MouseListener mouseListener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                field.setText(personenListe.getSelectedValue());


            }
        };
        personenListe.addMouseListener(mouseListener);

        uebersicht = new JLabel("Übersicht");

        //List
        personenPanel.setBorder(BorderFactory.createTitledBorder("Personen bearbeiten:"));

        personenScrollPane = new JScrollPane(personenListe,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
        personenListPanel.add(personenScrollPane, BorderLayout.CENTER);

        //ListButtons
        personenListButtonsPanel.add(create);
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CreatePersonDialog("Person erfassen", personenFacade, modelPersonen, personErfassenFacade);
            }
        });


        personenListButtonsPanel.add(delete);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                personenFacade.removePerson(personenFacade.getMitarbeiterListe().get(personenListe.getSelectedIndex()));
                modelPersonen.removeElement(personenListe.getSelectedValue());
            }
        });
        personenListButtonsPanel.add(bearbeiten);
        bearbeiten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdatePersonDialog("Person bearbeiten", personenFacade, modelPersonen, personenListe, personErfassenFacade);
            }
        });

        //Adding ListButtonsPanel to ListPanel
        personenListPanel.add(personenListButtonsPanel, BorderLayout.SOUTH);
        personenListPanel.add(uebersicht, BorderLayout.NORTH);

        //DetailPanel
        personenDetailPanel.setBorder(BorderFactory.createTitledBorder("Detail:"));

        //With SpringLayout
        springLayout.putConstraint(SpringLayout.EAST, field, -90, SpringLayout.EAST, personenDetailBildPanel);
        springLayout.putConstraint(SpringLayout.NORTH, field, 0, SpringLayout.NORTH, personenDetailBildPanel);
        field.setColumns(20);
        personenDetailBildPanel.add(field);

        //With SpringLayout
        springLayout.putConstraint(SpringLayout.EAST, bild, 320, SpringLayout.WEST, personenDetailBildPanel);
        springLayout.putConstraint(SpringLayout.NORTH, bild, 50, SpringLayout.NORTH, personenDetailBildPanel);
        personenDetailBildPanel.add(bild);

        //NebenPanel
        personenDetailBildNebenPanel.add(name);
        personenDetailBildNebenPanel.add(platzhalter);

        //With GridBagLayout
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy=0;
        personenDetailRollenPanel.add(hrM, gridBagConstraints);

        //With GridBagLayout
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy=1;
        personenDetailRollenPanel.add(adminstrator, gridBagConstraints);

        //Adding all Panels to MainPanel
        personenDetailBildMainPanel.add(personenDetailBildPanel, BorderLayout.CENTER);
        personenDetailBildMainPanel.add(personenDetailBildNebenPanel, BorderLayout.WEST);
        personenDetailBildMainPanel.add(new JSeparator(), BorderLayout.SOUTH);

        //MainPanel adding to DetialPanel
        personenDetailPanel.add(personenDetailBildMainPanel, BorderLayout.CENTER);
        personenDetailPanel.add(personenDetailRollenPanel, BorderLayout.SOUTH);

        //ListPanel and DetailPanel
        personenPanel.add(personenListPanel, BorderLayout.WEST);
        personenPanel.add(personenDetailPanel, BorderLayout.CENTER);
    }
    public String getVALUE(JList list, PersonenFacade facade){
        if(list.getSelectedValue() == null){
            return facade.getName(facade.getMitarbeiterListe().get(0));
        }
        else{
            return facade.getMitarbeiterNameListe().get(list.getSelectedIndex());
        }
    }
}



/**
 * Inner Class to create a new person
 */
class CreatePersonDialog extends JDialog{
    private JPanel personenDetailPanel;
    private JPanel personenDetailBildMainPanel;
    private JPanel personenDetailBildNebenPanel;
    private JPanel personenDetailBildPanel;
    private JPanel personenDetailRollenPanel;
    private GridBagConstraints gridBagConstraints;
    private JLabel name;
    private JTextField field;
    private JLabel foto;
    private JLabel bild;
    private ImageIcon imageIcon;
    private JCheckBox hrM;
    private JCheckBox adminstrator;
    private JDialog dialog;
    private JButton speichernButton, abortBtn;

    private PersonErfassenFacade personErfassenFacade;

    /**
     * Constructor to initialize all components and adding to the panels
     * @param text parameter to set the name
     * @param personErfassenFacade paramter to set the facade
     */
    CreatePersonDialog(String text, PersonenFacade personenFacade,DefaultListModel<String> model, PersonErfassenFacade personErfassenFacade){
        this.personErfassenFacade = personErfassenFacade;
        this.getContentPane().setLayout(new BorderLayout());
        this.dialog = this;
        this.setTitle(text + " erfassen");
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        name = new JLabel("Name: ");
        field = new JTextField();
        foto = new JLabel("Foto: ");
        imageIcon = new ImageIcon("src/pic.png");
        bild = new JLabel(imageIcon);
        adminstrator = new JCheckBox("Administrator");
        hrM = new JCheckBox("HR-Mitarbeiter");

        //Ok Listener, Verarbeitung des Buttons
        speichernButton = new JButton("Speichern");
        speichernButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstname = personenFacade.getFirstName(field.getText());
                String lastname =  personenFacade.getLastName(field.getText());
                Person person = new Person(firstname, lastname, new ImageIcon("pic.png"));
                personenFacade.addPerson(person);
                model.addElement(field.getText());
                dialog.dispose();
            }
        });
        abortBtn = new JButton("Abbrechen");
        abortBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                dialog.dispose();
            }
        });

        personenDetailPanel = new JPanel(new BorderLayout());
        personenDetailBildMainPanel = new JPanel(new BorderLayout());

        personenDetailBildNebenPanel = new JPanel();
        personenDetailBildNebenPanel.setLayout(new BoxLayout(personenDetailBildNebenPanel, BoxLayout.PAGE_AXIS));

        personenDetailBildPanel = new JPanel();
        personenDetailBildPanel.setLayout(new BoxLayout(personenDetailBildPanel, BoxLayout.PAGE_AXIS));

        personenDetailRollenPanel = new JPanel();
        personenDetailRollenPanel.setLayout(new GridBagLayout());
        gridBagConstraints = new GridBagConstraints();

        personenDetailBildPanel.add(field);
        personenDetailBildPanel.add(bild);

        personenDetailBildNebenPanel.add(name);
        personenDetailBildNebenPanel.add(foto);

        personenDetailBildMainPanel.add(personenDetailBildPanel, BorderLayout.CENTER);
        personenDetailBildMainPanel.add(personenDetailBildNebenPanel, BorderLayout.WEST);
        personenDetailBildMainPanel.add(new JSeparator(), BorderLayout.SOUTH);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        personenDetailRollenPanel.add(hrM, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        personenDetailRollenPanel.add(adminstrator, gridBagConstraints);

        personenDetailPanel.add(personenDetailBildMainPanel, BorderLayout.CENTER);
        personenDetailPanel.add(personenDetailRollenPanel, BorderLayout.SOUTH);
        this.getContentPane().add(personenDetailPanel, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel(new GridLayout(1,2));
        btnPanel.add(abortBtn);
        btnPanel.add(speichernButton);
        this.getContentPane().add(btnPanel, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }
}


/**
 * Inner Class to update a person
 */
class UpdatePersonDialog extends JDialog{
    private JPanel personenDetailPanel;
    private JPanel personenDetailBildMainPanel;
    private JPanel personenDetailBildNebenPanel;
    private JPanel personenDetailBildPanel;
    private JPanel personenDetailRollenPanel;
    private GridBagConstraints gridBagConstraints;
    private JLabel name;
    private JTextField field;
    private JLabel foto;
    private JLabel bild;
    private ImageIcon imageIcon;
    private JCheckBox hrM;
    private JCheckBox adminstrator;
    private JDialog dialog;
    private JButton speichernButton, abortBtn;

    private PersonErfassenFacade personErfassenFacade;

    /**
     * Constructor to initialize all components and adding to the panels
     * @param text parameter to set the name
     * @param personenFacade paramter to set the Personen-facade
     * @param model  parameter to set the model
     * @param list parameter to set the list
     */
    UpdatePersonDialog(String text, PersonenFacade personenFacade,DefaultListModel<String> model, JList list, PersonErfassenFacade personErfassenFacade){
        this.personErfassenFacade = personErfassenFacade;
        this.getContentPane().setLayout(new BorderLayout());
        this.dialog = this;
        this.setTitle(text + " erfassen");
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        name = new JLabel("Name: ");
        field = new JTextField(personenFacade.getMitarbeiterNameListe().get(list.getSelectedIndex()));
        foto = new JLabel("Foto: ");
        imageIcon = new ImageIcon("src/pic.png");
        bild = new JLabel(imageIcon);
        adminstrator = new JCheckBox("Administrator");
        hrM = new JCheckBox("HR-Mitarbeiter");

        //Ok Listener, Verarbeitung des Buttons
        speichernButton = new JButton("Speichern");
        speichernButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstname = personenFacade.getFirstName(field.getText());
                String lastname =  personenFacade.getLastName(field.getText());
                personenFacade.updatePerson(personenFacade.getMitarbeiterListe().get(list.getSelectedIndex()), firstname, lastname);
                model.set(list.getSelectedIndex(), field.getText());
                dialog.dispose();
            }
        });
        abortBtn = new JButton("Abbrechen");
        abortBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                dialog.dispose();
            }
        });

        personenDetailPanel = new JPanel(new BorderLayout());
        personenDetailBildMainPanel = new JPanel(new BorderLayout());

        personenDetailBildNebenPanel = new JPanel();
        personenDetailBildNebenPanel.setLayout(new BoxLayout(personenDetailBildNebenPanel, BoxLayout.PAGE_AXIS));

        personenDetailBildPanel = new JPanel();
        personenDetailBildPanel.setLayout(new BoxLayout(personenDetailBildPanel, BoxLayout.PAGE_AXIS));

        personenDetailRollenPanel = new JPanel();
        personenDetailRollenPanel.setLayout(new GridBagLayout());
        gridBagConstraints = new GridBagConstraints();

        personenDetailBildPanel.add(field);
        personenDetailBildPanel.add(bild);

        personenDetailBildNebenPanel.add(name);
        personenDetailBildNebenPanel.add(foto);

        personenDetailBildMainPanel.add(personenDetailBildPanel, BorderLayout.CENTER);
        personenDetailBildMainPanel.add(personenDetailBildNebenPanel, BorderLayout.WEST);
        personenDetailBildMainPanel.add(new JSeparator(), BorderLayout.SOUTH);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        personenDetailRollenPanel.add(hrM, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        personenDetailRollenPanel.add(adminstrator, gridBagConstraints);

        personenDetailPanel.add(personenDetailBildMainPanel, BorderLayout.CENTER);
        personenDetailPanel.add(personenDetailRollenPanel, BorderLayout.SOUTH);
        this.getContentPane().add(personenDetailPanel, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel(new GridLayout(1,2));
        btnPanel.add(abortBtn);
        btnPanel.add(speichernButton);
        this.getContentPane().add(btnPanel, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }
}