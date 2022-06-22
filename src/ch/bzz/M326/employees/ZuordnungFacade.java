package ch.bzz.M326.employees;

import ch.bzz.M326.company.Company;
import ch.bzz.M326.company.Department;
import ch.bzz.M326.company.JobFunctions;
import ch.bzz.M326.company.Team;

import javax.swing.*;
import java.util.Vector;

/**
 * This class is an interface for all data that is needed for the Tab "Zuordnung"
 * @author Nadim Bhatti
 * @since 2022-06-15
 * @version 1.0
 */
public class ZuordnungFacade {

   private Company company;

   public ZuordnungFacade(Company company){
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
    * sets a department for a person
    * @param person
    * @param department
    */
   public void setDepartment(Person person, Department department){
      person.setDepartment(department);
   }

   /**
    * adds a function to a person
    * @param person
    * @param jobFunctions
    */
   public void setFunction(Person person, String jobFunctions){
      person.setJobfunction(jobFunctions);
   }

   /**
    * adds a team to a person
    * @param person
    * @param team
    */
   public void setTeam(Person person, String team){
      person.setTeam(team);
   }

   /**
    * returns the photo of the person
    * @return photo
    */
   public ImageIcon getPhoto(Person person){
      return person.getPhoto();
   }


   /**
    * gets the department of the person
    * @return department as a String
    */
   public String getDepartment(Person person){
      return person.getDepartment().getName();
   }

   public Person getPersonByName(String name){
      Person person = new Person(null, null, null);
      for (int i = 0; i < getMitarbeiterListe().size(); i++) {
         if(getMitarbeiterListe().get(i).getName().equals(name)){
            person =  getMitarbeiterListe().get(i);
         }
      }
      if(person != null){
         return person;
      }
      else {
         return null;
      }
   }

   /**
    * gets the team of a person
    * @param person
    * @return
    */
   public String getTeam(Person person){
      return person.getTeam();
   }

   /**
    * gets the jobfunction of a person
    * @param person
    * @return
    */
   public String getFunction(Person person){
      return person.getJobfunction();
   }
}