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
public class ZuordnungFacade {

   private Company company;

   public ZuordnungFacade(Company company){}

   public Vector<Person> getMitarbeiterListe(){
      Vector<Person> allPersons = new Vector<>();
      for (int i = 0; i < company.getDepartments().size(); i++) {
         for (int j = 0; j < company.getDepartments(i).getNumberOfMembers(); j++) {
            allPersons.add(company.getDepartments(i).getMembers(j));
         }
      }
      return allPersons;
   }

   public Vector<String> getMitarbeiter(){
      Vector<String> allPersons = new Vector<>();
      for (int i = 0; i < company.getDepartments().size(); i++) {
         allPersons.add(getMitarbeiterListe().get(i).getFristName() + " " + getMitarbeiterListe().get(i).getLastName());
      }
      return allPersons;
   }

   /**
    * returns the full name of a person
    * @return first name
    */
   public String getName(Person person){
      return person.getFristName() + " " + person.getLastName();
   }

   /**
    * returns the photo of the person
    * @return photo
    */
   public ImageIcon getPhoto(Person person){
      return person.getPhoto();
   }

   /**
    * gets all functions of a Person
    * @return all functions as a String Vector
    */
   public Vector<String> getFunctions(Person person){
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
   public Vector<String> getTeams(Person person){
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
   public String getDepartment(Person person){
      return person.getDepartment().getName();
   }
}