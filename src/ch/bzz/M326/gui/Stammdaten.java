package ch.bzz.M326.gui;

import ch.bzz.M326.company.StammdatenFacade;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Our StammDaten-GUI
 * @author Filip Slavkovic
 * @since 2022-06-20
 * @version 1.0
 */
public class Stammdaten extends JPanel {
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
    private JList<String> funktionsListe;
    private JList<String> teamsListe;
    private JButton abteilungAdden;

    private JButton abteilungBearbeiten;
    private JButton funktionBearbeiten;
    private JButton teamBearbeiten;

    private JButton abteulungloeschen;
    private JButton funktionLoeschen;
    private JButton teamLoeschen;

    private JScrollPane abteilungScrollPane;
    private ArrayList<String> texts;
    private JPanel abteilungsButton;

    private StammdatenFacade stammdatenFacade;

    private DefaultListModel<String> modelFunktion;
    private DefaultListModel<String> modelTeam;
    private DefaultListModel<String> modelAbteilung;

    /**
     * Constructor for initialize firma-components and calling up the initializePanels and createStammDatenComponents method
     * @param pane to set the JTabbedPane
     * @param stammdatenFacade to set the facade
     */
    public Stammdaten(JTabbedPane pane, StammdatenFacade stammdatenFacade){
        this.pane = pane;
        this.stammdatenFacade = stammdatenFacade;

        //Needed for the firmaPanel --> usually in the initializePanels methode
        stammDatenPanel = new JPanel(new GridLayout(4,1, 50,20));

        //SpringLayout
        springLayout = new SpringLayout();
        firma = new JLabel("Firma:");
        firmaField = new JTextField(stammdatenFacade.getFirmaName());
        firmaField.setEditable(false);
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

        modelFunktion = new DefaultListModel<>();
        for (int i = 0; i < stammdatenFacade.getAllJobFunctions().size(); i++) {
            modelFunktion.addElement(stammdatenFacade.getAllJobFunctions().get(i));
        }
        modelTeam = new DefaultListModel<>();
        for (int i = 0; i < stammdatenFacade.getAllTeams().size(); i++) {
            modelTeam.addElement(stammdatenFacade.getAllTeams().get(i));
        }
        modelAbteilung = new DefaultListModel<>();
        for (int i = 0; i < stammdatenFacade.getAllDepartments().size(); i++) {
            modelAbteilung.addElement(stammdatenFacade.getAllDepartments().get(i));
        }

        createStammdatenComponent("Abteilungen", modelAbteilung,1);
        createStammdatenComponent("Funktionen", modelFunktion,2);
        createStammdatenComponent("Teams", modelTeam,3);

    }


    /**
     * Initialize all components and adding to the panels
     * @param name to set the name
     * @param model to set the ListElements
     */
    public void createStammdatenComponent(String name, DefaultListModel<String> model, int value){

        abteilungsButton = new JPanel(new GridLayout(1,3,5,5));
        abteilungsPanelBorder = new JPanel(new BorderLayout());
        abteilungsPanel = new JPanel(new GridLayout(1,1, 0, 500));

        abteilung = new JLabel(name+": ");

        switch (value){
            case 1:
                abteilungsListe = new JList(modelAbteilung);
                abteulungloeschen = new JButton("Delete");
                abteulungloeschen.setEnabled(false);
                abteilungBearbeiten = new JButton("Edit");
                abteilungBearbeiten.setEnabled(false);
                abteilungsListe.addListSelectionListener(new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        if(e.getValueIsAdjusting()){
                            if (abteilungsListe.getSelectedValue() != null) {
                                abteulungloeschen.setEnabled(true);
                                abteilungBearbeiten.setEnabled(true);
                            } else {
                                abteulungloeschen.setEnabled(false);
                                abteilungBearbeiten.setEnabled(false);
                            }
                        }
                    }
                });
                abteilungScrollPane = new JScrollPane(abteilungsListe, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                break;
            case 2:
                funktionsListe = new JList(modelFunktion);
                funktionLoeschen = new JButton("Delete");
                funktionLoeschen.setEnabled(false);
                funktionBearbeiten = new JButton("Edit");
                funktionBearbeiten.setEnabled(false);
                funktionsListe.addListSelectionListener(new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        if(e.getValueIsAdjusting()){

                            if(funktionsListe.getSelectedValue() != null){
                                funktionLoeschen.setEnabled(true);
                                funktionBearbeiten.setEnabled(true);
                            }else{
                                funktionLoeschen.setEnabled(false);
                                funktionBearbeiten.setEnabled(false);
                            }
                        }
                    }
                });
                abteilungScrollPane = new JScrollPane(funktionsListe, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                break;
            case 3:
                teamsListe = new JList(modelTeam);
                teamLoeschen = new JButton("Delete");
                teamLoeschen.setEnabled(false);
                teamBearbeiten = new JButton("Edit");
                teamBearbeiten.setEnabled(false);
                teamsListe.addListSelectionListener(new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        if(e.getValueIsAdjusting()){
                            if (teamsListe.getSelectedValue() != null) {
                                teamLoeschen.setEnabled(true);
                                teamBearbeiten.setEnabled(true);
                            } else {
                                teamLoeschen.setEnabled(false);
                                teamBearbeiten.setEnabled(false);
                            }
                        }
                    }
                });
                abteilungScrollPane = new JScrollPane(teamsListe, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                break;
            default:
                break;
        }


        abteilungAdden = new JButton("New");
        abteilungAdden.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateDialog createDialog = new CreateDialog(name, stammdatenFacade, getListModel(value), getEditButton(value), getDeleteButton(value));
            }
        });

        getDeleteButton(value).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (value){
                    case 1:
                        stammdatenFacade.universalDelete(name, abteilungsListe.getSelectedValue());
                        modelAbteilung.removeElement(abteilungsListe.getSelectedValue());
                        abteilungBearbeiten.setEnabled(false);
                        abteulungloeschen.setEnabled(false);
                        break;
                    case 2:
                        stammdatenFacade.universalDelete(name, funktionsListe.getSelectedValue());
                        modelFunktion.removeElement(funktionsListe.getSelectedValue());
                        funktionBearbeiten.setEnabled(false);
                        funktionLoeschen.setEnabled(false);
                        break;
                    case 3:
                        stammdatenFacade.universalDelete(name, teamsListe.getSelectedValue());
                        modelTeam.removeElement(teamsListe.getSelectedValue());
                        teamBearbeiten.setEnabled(false);
                        teamLoeschen.setEnabled(false);
                        break;
                }
                if(getJlist(value).getModel().getSize() == 0){
                    getDeleteButton(value).setEnabled(false);
                    getEditButton(value).setEnabled(false);
                }
            }
        });
        getEditButton(value).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateDialog(name, stammdatenFacade, value, getJlist(value), getListModel(value), getEditButton(value), getDeleteButton(value));
            }
        });


        abteilungsButton.add(abteilungAdden);
        abteilungsButton.add(getDeleteButton(value));
        abteilungsButton.add(getEditButton(value));
        abteilungsPanel.add(abteilung);
        abteilungsPanel.add(abteilungsPanelBorder);
        abteilungsPanelBorder.add(abteilungScrollPane, BorderLayout.CENTER);
        abteilungsPanelBorder.add(abteilungsButton, BorderLayout.SOUTH);

        stammDatenPanel.add(abteilungsPanel);
    }

    public JButton getEditButton(int value){
        switch (value){
            case 1:
                return abteilungBearbeiten;
            case 2:
                return funktionBearbeiten;
            case 3:
                return teamBearbeiten;
            default:
                return null;
        }
    }

    public JButton getDeleteButton(int value){
        switch (value){
            case 1:
                return abteulungloeschen;
            case 2:
                return funktionLoeschen;
            case 3:
                return teamLoeschen;
            default:
                return null;
        }
    }

    public DefaultListModel<String> getListModel(int value){
        switch (value){
            case 1:
                return modelAbteilung;
            case 2:
                return modelFunktion;
            case 3:
                return modelTeam;
            default:
                return null;
        }
    }

    public JList getJlist(int value){
        switch (value){
            case 1:
                return abteilungsListe;
            case 2:
                return funktionsListe;
            case 3:
                return teamsListe;
            default:
                return null;
        }
    }

}

/**
 * Inner class to create new StammDaten
 */
class CreateDialog extends JDialog{
    private JTextField eingabeFeld;
    private JButton speichernButton, abortBtn;
    private JDialog dialog;
    private String temp;

    /**
     * Constructor for intialize the components and adding to the panels for the JDialog
     * @param text to set the name
     * @param stammdatenFacade to set the facade
     */
    CreateDialog(String text, StammdatenFacade stammdatenFacade, DefaultListModel<String> model, JButton edit, JButton delete){

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
                if(!temp.equals("")){
                    stammdatenFacade.universalAdd(text, temp);
                    model.addElement(temp);
                }else{
                    JOptionPane.showMessageDialog(null, "Die Eingabe ist leer, fuellen Sie bitte das Feld aus", "Field is empty!", JOptionPane.ERROR_MESSAGE);
                    new CreateDialog(text, stammdatenFacade, model, edit, delete);
                }
                if(model.getSize() > 0){
                    edit.setEnabled(true);
                    delete.setEnabled(true);
                }
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
    private JTextField eingabeFeld;
    private JButton speichernButton, abortBtn;
    private JDialog dialog;
    private String temp;


    /**
     * Constructor for intialize the components and adding to the panels for the JDialog
     * @param text to set the name
     * @param stammdatenFacade to set the facade
     */
    UpdateDialog(String text, StammdatenFacade stammdatenFacade, int value, JList jList, DefaultListModel<String> model, JButton edit, JButton delete){

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
                if(!temp.equals("")){
                    stammdatenFacade.universalUpdate(text, stammdatenFacade.universalGetList(text).get(jList.getSelectedIndex()), temp);
                    model.set(jList.getSelectedIndex(), temp);
                    jList.clearSelection();
                }else{
                    JOptionPane.showMessageDialog(null, "Die Eingabe ist leer, fuellen Sie bitte das Feld aus", "Error", JOptionPane.ERROR_MESSAGE);
                    new UpdateDialog(text, stammdatenFacade, value, jList, model, edit, delete);
                }
                edit.setEnabled(false);
                delete.setEnabled(false);
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
