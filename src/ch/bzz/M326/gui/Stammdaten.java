package ch.bzz.M326.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

/**
 * Unsere Stammdaten-GUI für das Programm
 */
public class Stammdaten extends JPanel {

    /**
     * Komponenten für das StammdatenPanel
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


    /**
     * Konstruktor für das Erzeugen des Stammdaten-GUIs
     * @param pane Weitergabe vom JTabbedPane
     */
    public Stammdaten(JTabbedPane pane){
        this.pane = pane;
        stammDatenPanel = new JPanel(new GridLayout(4,1, 50,20));
        springLayout = new SpringLayout();
        firma = new JLabel("Firma:");
        firmaField = new JTextField("Text eingeben");
        firmaPanel = new JPanel();
        firmaPanel.setLayout(springLayout);

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
        createStammdatenComponent("Abteilungen");
        createStammdatenComponent("Funktionen");
        createStammdatenComponent("Teams");

    }

    /**
     * Initialisierung der Komponenten
     * in Methode ausgebaut, um redundanten Code zu vermeiden
     * @param name Weitergabe des Namen
     */
    public void createStammdatenComponent(String name){

        abteilungsPanel = new JPanel(new GridLayout(1,1, 0, 500));
        abteilungsPanelBorder = new JPanel(new BorderLayout());
        texts = new ArrayList<>();
        texts.add("text");
        texts.add("text");
        texts.add("text");
        abteilung = new JLabel(name+": ");
        abteilungsListe = new JList(texts.toArray());

        abteilungAdden = new JButton("New");
        abteilungAdden.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("morn");
                new CreateDialog(name);
                // texts.add("jebiga");
                // System.out.println(texts);
                //abteilungsListe.add(texts.toArray())
                //abteilungsListe.repaint();
            }
        });
        abteilungLöschen = new JButton("Delete");
        abteilungsListe.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                abteilungLöschen.setEnabled(true);
            }

            @Override
            public void focusLost(FocusEvent e) {
                abteilungLöschen.setEnabled(false);
            }
        });
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
                new UpdateDialog("Abteilung");
            }
        });
        abteilungsButton = new JPanel(new GridLayout(1,3,5,5));
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
 * Innere Klasse für das Erzeugen
 */
class CreateDialog extends JDialog{

    /**
     * Komponenten für das JDialog
     */
    private JTextField eingabeFeld;
    private JButton speichernButton, abortBtn;
    private JDialog dialog;
    private String temp;

    /**
     * Konstruktor für das Erzeugen vom JDialog
     * @param text Weitergabe des Namens
     */
    CreateDialog(String text){
        this.getContentPane().setLayout(new BorderLayout());
        this.dialog = this;
        this.setTitle(text + " erfassen");
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.getContentPane().add(new JLabel(text+": "));
        eingabeFeld = new JTextField();
        eingabeFeld.setText("Text eingeben");
       this.getContentPane().add(eingabeFeld);
        //Ok Listener, Verarbeitung des Buttons
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
 * Innere Klasse für das Updaten
 */
class UpdateDialog extends JDialog{
    /**
     * Komponenten für das JDialog
     */
    private JTextField eingabeFeld;
    private JButton speichernButton, abortBtn;
    private JDialog dialog;
    private String temp;

    /**
     * Konstruktor zum erzeugen des JDialoges
     * @param text Weitergabe des Namens
     */
    UpdateDialog(String text){
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
        //Abbrechen Button mit Actionlistener
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
