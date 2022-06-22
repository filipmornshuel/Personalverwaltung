package ch.bzz.M326.employees;

import ch.bzz.M326.employees.Person;
import ch.bzz.M326.log.LogBook;
import ch.bzz.M326.log.Useraction;

import javax.swing.*;

/**
 * a Person with "HR" rights
 *
 * @author Isuf Hasani
 * @since 2022-06-01
 * @version 1.1
 *
 */
public class HRPerson extends Person {

    private int modus;
    private String pwd;

    /**
     * constuctor of class HRPerson
     * @param fristName
     * @param lastName
     * @param photo
     * @param modus
     */
    public HRPerson(String fristName, String lastName, ImageIcon photo, int modus) {
        super(fristName, lastName, photo);
        this.modus = modus;
    }

    /**
     * methode to change the modus of the person
     * @param person
     * @param modus
     */
    public void change(Person person, int modus){
        if (this.modus == modus){
            System.out.println("This person a   lready has this modus");

        }else {
            this.modus = modus;
        }

    }

    /**
     * gets first name of hrperson
     * @return
     */
    @Override
    public String getFristName() {
        return super.getFristName();
    }

    /**
     * gets last name of hrperson
     * @return
     */
    @Override
    public String getLastName() {
        return super.getLastName();
    }

    /**
     * set the modus of the HRPerson
     * @param modus
     */
    public void setModus(int modus) {
        this.modus = modus;
    }

    /**
     * gets the modus
     * @return modus
     */
    public int getModus() {
        return modus;
    }

    /**
     * set the password of HRPerson
     * @param pwd   password as String
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * get the password of HRPerson
     * @return pwd as String
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * write entry in the LogBook
     * @param useraction
     * @param person
     */
    public void writeLogEntry(int useraction, Person person){
        Useraction ua = new Useraction(this, person, useraction);
        LogBook log = new LogBook();
        log.getLogBookInstance();
        log.addEntry(ua.getEntry());
    }
}
