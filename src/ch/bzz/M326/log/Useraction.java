package ch.bzz.M326.log;

import ch.bzz.M326.employees.HRPerson;
import ch.bzz.M326.employees.Person;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public class Useraction {

    public static int CREATE_PERSON = 0;
    public static int CHANGE_VALUE = 1;
    public static int SET_ASSIGNMENT = 2;
    public static int DELETE_PERSON = 3;
    private ArrayList<String> actionDescription;
    private String entry;


    public Useraction(HRPerson hrPerson, Person person, int action){
        actionDescription = new ArrayList<>(Arrays.asList(" create person ", " change value ", " set assignment ", " delete person "));
        entry = LocalDate.now() + " " + LocalTime.now() + " : " + hrPerson.getFristName() + " " + hrPerson.getLastName() + " do";
        if (action >= 0 && action < actionDescription.size()){
            entry += actionDescription.get(action) + "for " + person.getFristName() + " " + person.getLastName();
        }else {
            entry += "unknown action";
        }
    }

    public String getEntry(){
        return entry;
    }
}
