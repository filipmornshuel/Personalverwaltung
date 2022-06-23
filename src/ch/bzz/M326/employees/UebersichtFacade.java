package ch.bzz.M326.employees;

import ch.bzz.M326.company.Company;

import javax.swing.*;
import java.util.Vector;

/**
 * This class is an interface for all data that is needed for the Tab "Übersicht"
 * @author Nadim Bhatti
 * @since 2022-06-15
 * @version 1.0
 */
public class UebersichtFacade {

   private Company company;

   public UebersichtFacade(Company company){
      this.company = company;
   }

   /**
    * gets all the employees as a Person
    * @return all employees
    */
   public Vector<Person> getMitarbeiterListe(){
      return company.getPeople();
   }

   /**
    * gets all the names of the employees
    * @return names as Strings
    */
   public Vector<String> getMitarbeiterNameListe(){
      Vector<String> allPersons = new Vector<>();
      for (int i = 0; i < company.getPeople().size(); i++) {
         allPersons.add(getMitarbeiterListe().get(i).getFristName() + " " + getMitarbeiterListe().get(i).getLastName());
      }
      return allPersons;
   }

   /**
    * gets all functions
    * @return all functions as a String Vector
    */
   public Vector<String> getAllJobFunctions(){
      return company.getJobFunctions().getDesignations();
   }

   /**
    * gets all teams
    * @return all teams as a String Vector
    */
   public Vector<String> getAllTeams(){
      return company.getTeams().getDesignations();
   }

   /**
    * gets all departments
    * @return all department as String Vector
    */
   public Vector<String> getAllDepartments(){
      Vector<String> allDepartments = new Vector<>();
      for (int i = 0; i < company.getDepartments().size(); i++) {
         allDepartments.add(company.getDepartments(i).getName());
      }
      return allDepartments;
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
   public Vector<String> getFunctionsByPerson(Person person){
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
   public Vector<String> getTeamsByPerson(Person person){
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
   public String getDepartmentByPerson(Person person){
      return person.getDepartment().getName();
   }
}
