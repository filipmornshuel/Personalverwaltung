package ch.bzz.M326.gui;

import ch.bzz.M326.company.AuthentificationFacade;
import ch.bzz.M326.company.Company;
import ch.bzz.M326.company.Team;
import ch.bzz.M326.employees.ZuordnungFacade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Our Authentifizierungs-GUI for the TabbedPanes
 * @author Filip Slavkovic
 * @since 2022-06-22
 * @version 1.0
 */
public class Authentifizierung extends JDialog {
    private JDialog dialog;
    private JLabel name;
    private JComboBox persons;
    private JLabel code;
    private JTextField codeField;
    private final String password = "1234";
    private JPanel components;
    private JPanel buttons;
    private JButton abort, next;
    private AuthentificationFacade authentificationFacade;
    private int tries =1;
    private boolean correct;
    private JFrame frame;
    private JTabbedPane pane;
    private int temp;

    /**
     * Constructor to call up the createComponentsmethod
     * @param frame to set the frame
     * @param authentificationFacade to set the facade
     * @param pane to set the pane
     */
    public Authentifizierung(JFrame frame, AuthentificationFacade authentificationFacade, JTabbedPane pane){
        super(frame,true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                pane.setSelectedIndex(0);
            }
        });
        this.dialog = this;
        this.authentificationFacade = authentificationFacade;
        this.frame = frame;
        this.pane = pane;
        setTitle("Authentifizierung");
        createComponents();
        pack();
        setVisible(true);
    }

    /**
     * Method to initialize all components and adding to the panels
     */
    public void createComponents(){
        this.getContentPane().setLayout(new BorderLayout());
        components = new JPanel(new GridLayout(2,2));
        buttons = new JPanel(new GridLayout(1,2));

        name = new JLabel("Name: ");
        code = new JLabel("Code: ");
        codeField = new JTextField("");
        persons = new JComboBox(authentificationFacade.getAllHRPeople());

        temp = pane.getSelectedIndex();

        abort = new JButton("Abbrechen");
        abort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pane.setSelectedIndex(0);
                dispose();
            }
        });
        next = new JButton("Weiter");
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tries<= 2){
                    if (password.equals(codeField.getText())){
                        pane.setSelectedIndex(temp);
                        correct = true;
                        dispose();
                    }else {
                        tries++;
                    }
                }else {
                    pane.setSelectedIndex(0);
                    correct = false;
                    dispose();
                }
            }
        });

        components.add(name);
        components.add(persons);
        components.add(code);
        components.add(codeField);

        buttons.add(abort);
        buttons.add(next);

        this.getContentPane().add(components, BorderLayout.CENTER);
        this.getContentPane().add(buttons, BorderLayout.SOUTH);

    }
}
