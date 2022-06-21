package ch.bzz.M326.gui;

import ch.bzz.M326.company.Company;
import ch.bzz.M326.company.Department;
import ch.bzz.M326.company.StammdatenFacade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Our StammDaten-GUI
 */
public class Stammdaten extends JPanel {

    /**
     * Components for the StammdatenPanel
     */
    private JTabbedPane pane;
    private JPanel stammDatenPanel;
    private JPanel firmaPanel;
    private JLabel firma;
    private JTextField firmaField;
    private SpringLayout springLayout;

    private JPanel abteilungsPanel;
    private JPanel abteilungsPanelBorder;
    private JLabel abteilung;
    private JList<String> abteilungsListe;
    private JButton abteilungAdden;
    private JButton abteilungBearbeiten;
    private JButton abteilungLöschen;
    private JScrollPane abteilungScrollPane;
    private ArrayList<String> texts;
    private JPanel abteilungsButton;

    private Company company;

    /**
     * Constructor for initialize firma-components and calling up the initializePanels and createStammDatenComponents method
     * @param pane to set the JTabbedPane
     * @param company to set the company
     */
    public Stammdaten(JTabbedPane pane, Company company){

        //Facade
        StammdatenFacade facade = new StammdatenFacade(company);
        this.pane = pane;
        this.company = company;

        //Needed for the firmaPanel --> usually in the initializePanels method
        stammDatenPanel = new JPanel(new GridLayout(4,1, 50,20));

        //SpringLayout
        springLayout = new SpringLayout();
        firma = new JLabel("Firma:");
        firmaField = new JTextField(company.getCompanyName());
        firmaPanel = new JPanel();
        firmaPanel.setLayout(springLayout);

        //Setting with springLayout the JLabel and JField in relation to firmaPanel
        springLayout.putConstraint(SpringLayout.WEST, firma,5, SpringLayout.WEST, firmaPanel);
        springLayout.putConstraint(SpringLayout.NORTH, firma,50, SpringLayout.NORTH, firmaPanel);
        springLayout.putConstraint(SpringLayout.WEST, firmaField, 250, SpringLayout.EAST, firma);
        springLayout.putConstraint(SpringLayout.NORTH, firmaField, 50, SpringLayout.NORTH, firmaPanel);

        firmaField.setColumns(30);
        firmaPanel.add(firma);
        firmaPanel.add(firmaField);

        firmaPanel.add(new JLabel());
        firmaPanel.add(new JLabel());
        firmaPanel.add(new JLabel());
        firmaPanel.add(new JLabel());


        pane.addTab("Stammdaten", stammDatenPanel);
        stammDatenPanel.add(firmaPanel);

        createStammdatenComponent("Abteilungen", facade.getAllDepartments().toArray());
        createStammdatenComponent("Funktionen", facade.getAllJobFunctions().toArray());
        createStammdatenComponent("Teams", facade.getAllTeams().toArray());

    }


    /**
     * Initialize all components and adding to the panels
     * @param name to set the name
     * @param listElements to set the ListElements
     */
    public void createStammdatenComponent(String name, Object[] listElements){
        //Facade
        StammdatenFacade facade = new StammdatenFacade(company);

        abteilungsButton = new JPanel(new GridLayout(1,3,5,5));
        abteilungsPanelBorder = new JPanel(new BorderLayout());
        abteilungsPanel = new JPanel(new GridLayout(1,1, 0, 500));


        abteilung = new JLabel(name+": ");
        abteilungsListe = new JList(listElements);

        abteilungAdden = new JButton("New");
        abteilungAdden.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("morn");
                CreateDialog createDialog = new CreateDialog(name, company);

            }
        });
        abteilungLöschen = new JButton("Delete");
        abteilungLöschen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        abteilungBearbeiten = new JButton("Edit");
        abteilungBearbeiten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("morn");
                UpdateDialog updateDialog = new UpdateDialog("Abteilung", company);

            }
        });

        abteilungScrollPane = new JScrollPane(abteilungsListe, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);


        abteilungsButton.add(abteilungAdden);
        abteilungsButton.add(abteilungLöschen);
        abteilungsButton.add(abteilungBearbeiten);
        abteilungsPanel.add(abteilung);
        abteilungsPanel.add(abteilungsPanelBorder);
        abteilungsPanelBorder.add(abteilungScrollPane, BorderLayout.CENTER);
        abteilungsPanelBorder.add(abteilungsButton, BorderLayout.SOUTH);

        stammDatenPanel.add(abteilungsPanel);
    }

}

/**
 * Inner class to create new StammDaten
 */
class CreateDialog extends JDialog{

    /**
     * Components for the JDialog
     */
    private JTextField eingabeFeld;
    private JButton speichernButton, abortBtn;
    private JDialog dialog;
    private String temp;

    /**
     * Constructor for intialize the components and adding to the panels for the JDialog
     * @param text to set the name
     * @param company to set the company
     */
    CreateDialog(String text, Company company){
        //Facade
        StammdatenFacade facade = new StammdatenFacade(company);

        this.getContentPane().setLayout(new BorderLayout());
        this.dialog = this;
        this.setTitle(text + " erfassen");
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.getContentPane().add(new JLabel(text+": "));

        eingabeFeld = new JTextField();
        eingabeFeld.setText("Text eingeben");
        this.getContentPane().add(eingabeFeld);

        speichernButton = new JButton("Speichern");
        speichernButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                temp = eingabeFeld.getText();

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
        JPanel btnPanel = new JPanel(new GridLayout(1,2));
        btnPanel.add(abortBtn);
        btnPanel.add(speichernButton);
        this.getContentPane().add(btnPanel, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }

}

/**
 * Inner class to update StammDaten
 */
class UpdateDialog extends JDialog{
    /**
     * Components for the JDialog
     */
    private JTextField eingabeFeld;
    private JButton speichernButton, abortBtn;
    private JDialog dialog;
    private String temp;


    /**
     * Constructor for intialize the components and adding to the panels for the JDialog
     * @param text to set the name
     * @param company to set the company
     */
    UpdateDialog(String text, Company company){
        //Facade
        StammdatenFacade facade = new StammdatenFacade(company);

        this.getContentPane().setLayout(new BorderLayout());
        this.dialog = this;
        this.setTitle(text+" bearbeiten");
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.getContentPane().add(new JLabel(text+": "));

        eingabeFeld = new JTextField();
        eingabeFeld.setText("Text eingeben");
        this.getContentPane().add(eingabeFeld);
        speichernButton = new JButton("Speichern");
        speichernButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                temp = eingabeFeld.getText();

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

        JPanel btnPanel = new JPanel(new GridLayout(1,2));
        btnPanel.add(abortBtn);
        btnPanel.add(speichernButton);
        this.getContentPane().add(btnPanel, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }

}
