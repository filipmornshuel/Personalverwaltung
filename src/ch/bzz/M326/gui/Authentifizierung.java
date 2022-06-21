package ch.bzz.M326.gui;

import ch.bzz.M326.company.AuthentificationFacade;
import ch.bzz.M326.company.Company;
import ch.bzz.M326.company.Team;
import ch.bzz.M326.employees.ZuordnungFacade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private Company company;
    private int tries =1;
    private boolean correct;

    public Authentifizierung(JFrame frame, Company company){
        super(frame,true);
        this.dialog = this;
        this.company = company;
        setTitle("Authentifizierung");
        createComponents();
        pack();
        setVisible(true);
        //setModal(true);

    }

    public void createComponents(){
        AuthentificationFacade authentificationFacade = new AuthentificationFacade(company);

        this.getContentPane().setLayout(new BorderLayout());
        components = new JPanel(new GridLayout(2,2));
        buttons = new JPanel(new GridLayout(1,2));

        name = new JLabel("Name: ");
        code = new JLabel("Code: ");
        codeField = new JTextField("");
        persons = new JComboBox(authentificationFacade.getAllHRPeople());

        abort = new JButton("Abbrechen");
        abort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new mainFrame(company);
                dispose();
            }
        });
        next = new JButton("Weiter");
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tries<= 2){
                    if (password.equals(codeField.getText())){
                            correct = true;
                            dispose();
                    }else {
                        tries++;
                    }
                }else {
                    correct = false;
                    new mainFrame(company);
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

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}
