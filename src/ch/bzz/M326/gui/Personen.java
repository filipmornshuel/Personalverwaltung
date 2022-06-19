package ch.bzz.M326.gui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Unsere Personen-GUI für das Programm
 */
public class Personen extends JPanel {
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
    private JButton delete;
    private JButton bearbeiten;
    private JButton create;

    private JLabel name;
    private JTextField field;
    private JLabel platzhalter;
    private JLabel bild;
    private ImageIcon imageIcon;


    private JLabel hr;
    private JLabel admin;
    private JCheckBox hrM;
    private JCheckBox adminstrator;

    /**
     * Konstruktor für das Ausführen der createPersonenComponents-Methode
     * @param pane Weitergabe des JTabbedPanes
     */
    public Personen(JTabbedPane pane){
        this.pane = pane;
        createPersonenComponents();
        pane.addTab("Personen", personenPanel);
    }

    /**
     * Methode zum Initialisieren aller Attribute
     */
    public void createPersonenComponents(){

        personenPanel = new JPanel(new BorderLayout());
        personenListPanel = new JPanel(new BorderLayout());

        personenDetailPanel = new JPanel(new BorderLayout());
        personenDetailBildMainPanel = new JPanel(new BorderLayout());

        personenDetailBildPanel = new JPanel();
        //personenDetailBildPanel.setLayout(new BoxLayout(personenDetailBildPanel, BoxLayout.PAGE_AXIS));
        springLayout = new SpringLayout();
        personenDetailBildPanel.setLayout(springLayout);
        //personenDetailBildPanel = new JPanel(new GridLayout(2,2));


        personenDetailRollenPanel = new JPanel();
        personenDetailRollenPanel.setLayout(new GridBagLayout());
        gridBagConstraints = new GridBagConstraints();

        personenDetailBildNebenPanel = new JPanel();
        personenDetailBildNebenPanel.setLayout(new BoxLayout(personenDetailBildNebenPanel, BoxLayout.PAGE_AXIS));

        personenListButtonsPanel = new JPanel(new GridLayout(1,3));

        //Betreffend Liste
        personen = new ArrayList<>();
        for (int i = 0; i < 30; i++){
            personen.add("textjebigakock");
        }
        personenPanel.setBorder(BorderFactory.createTitledBorder("Personen bearbeiten:"));
        personenListe = new JList<>();
        personenListe = new JList(personen.toArray());
        übersicht = new JLabel("Übersicht");
        personenScrollPane = new JScrollPane(personenListe,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
        personenListPanel.add(personenScrollPane, BorderLayout.CENTER);

        delete = new JButton("Delete");
        bearbeiten = new JButton("Edit");
        create = new JButton("New");

        personenListButtonsPanel.add(create);
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CreatePersonDialog("Person erfassen");
            }
        });

        personenListButtonsPanel.add(delete);
        personenListButtonsPanel.add(bearbeiten);
        personenListPanel.add(personenListButtonsPanel, BorderLayout.SOUTH);
        personenListPanel.add(übersicht, BorderLayout.NORTH);


        //DetailPanel betreffend
        personenDetailPanel.setBorder(BorderFactory.createTitledBorder("Detail:"));

        name = new JLabel("Name: ");
        field = new JTextField("Trulli Theo");
        platzhalter = new JLabel();
        bild = new JLabel();
        imageIcon = new ImageIcon("src/pic.png");
        bild.setIcon(imageIcon);

        hrM = new JCheckBox("HR-Mtiarbeiter");
        adminstrator = new JCheckBox("Adminstrator: ");

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
        personenDetailRollenPanel.add(hrM, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy=1;
        personenDetailRollenPanel.add(adminstrator, gridBagConstraints);

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

/**
 * Innere Klasse für das Erzeugen einer neuen Person
 */
class CreatePersonDialog extends JDialog{
    /**
     * Komponenten für das JDialog
     */
    private JPanel personenDetailPanel;
    private JPanel personenDetailBildMainPanel;
    private JPanel personenDetailBildNebenPanel;
    private JPanel personenDetailBildPanel;
    private JPanel personenDetailRollenPanel;
    private GridBagConstraints gridBagConstraints;
    private GridBagLayout gridBagLayout;
    private JLabel name;
    private JTextField field;
    private JLabel foto;
    private JLabel bild;
    private ImageIcon imageIcon;
    private JCheckBox hrM;
    private JCheckBox adminstrator;
    private JDialog dialog;
    private JButton speichernButton, abortBtn;

    /**
     * Konstruktor für das Erzeugen der Komponenten
     * @param text Weitergabe des Namens
     */
    CreatePersonDialog(String text){
        this.getContentPane().setLayout(new BorderLayout());
        this.dialog = this;
        this.setTitle(text + " erfassen");
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        name = new JLabel("Name: ");
        field = new JTextField("Trulli Theo");
        foto = new JLabel("Foto: ");
        imageIcon = new ImageIcon("src/pic.png");
        bild = new JLabel(imageIcon);



        //Ok Listener, Verarbeitung des Buttons
        speichernButton = new JButton("Speichern");
        speichernButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

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

        personenDetailBildPanel.add(field);
        personenDetailBildPanel.add(bild);

        personenDetailBildNebenPanel.add(name);
        personenDetailBildNebenPanel.add(foto);

        personenDetailBildMainPanel.add(personenDetailBildPanel, BorderLayout.CENTER);
        personenDetailBildMainPanel.add(personenDetailBildNebenPanel, BorderLayout.WEST);
        personenDetailBildMainPanel.add(new JSeparator(), BorderLayout.SOUTH);

        personenDetailRollenPanel = new JPanel();
        personenDetailRollenPanel.setLayout(new GridBagLayout());
        gridBagConstraints = new GridBagConstraints();

        adminstrator = new JCheckBox("Administrator");
        hrM = new JCheckBox("HR-Mitarbeiter");


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
