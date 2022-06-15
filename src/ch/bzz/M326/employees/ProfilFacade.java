package ch.bzz.M326.employees;

import ch.bzz.M326.company.Company;

import javax.swing.*;
import java.util.Vector;

/**
 * This class is an interface for all data that is needed for the ProfilGUI
 * @author Nadim Bhatti
 * @since 2022-06-15
 * @version 1.0
 */
public class ProfilFacade {

   private Person person;

   public ProfilFacade(Person person){}

   /**
    * returns the full name of a person
    * @return first name
    */
   public String getName(){
      return person.getFristName() + " " + person.getLastName();
   }

   /**
    * returns the photo of the person
    * @return photo
    */
   public ImageIcon getPhoto(){
      return person.getPhoto();
   }

   /**
    * gets all functions of a Person
    * @return all functions as a String Vector
    */
   public Vector<String> getFunctions(){
      Vector<String> functions = new Vector<String>();
      for (int i = 0; i < person.getParticipation().getNumberOfFunctions(); i++) {
         functions.add(person.getParticipation().getFunctionName(i));
      }
      return functions;
   }

   /**
    * gets all teams the Person is in
    * @return all teams as a String Vector
    */
   public Vector<String> getTeams(){
      Vector<String> teams = new Vector<String>();
      for (int i = 0; i < person.getParticipation().getNumberOfTeams(); i++) {
         teams.add(person.getParticipation().getTeamName(i));
      }
      return teams;
   }

   /**
    * gets the department of the person
    * @return department as a String
    */
   public String getDepartment(){
      return person.getDepartment().getName();
   }
}
