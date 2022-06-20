package ch.bzz.M326.employees;

import ch.bzz.M326.company.Company;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Vector;

/**
 * This class is an interface for all data that is needed for the Tab "Personen"
 * @author Nadim Bhatti
 * @since 2022-06-20
 * @version 1.0
 */
public class PersonenFacade {

   private Company company;

   public PersonenFacade(Company company){
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
      for (int i = 0; i < company.getDepartments().size(); i++) {
         allPersons.add(getMitarbeiterListe().get(i).getFristName() + " " + getMitarbeiterListe().get(i).getLastName());
      }
      return allPersons;
   }

   /**
    * adds a person to the company
    * @param person
    */
   public void addPerson(Person person){
      company.addPerson(person);
   }

   /**
    * removes a person
    * @param person
    */
   public void removePerson(Person person){
      company.removePerson(person);
   }

   /**
    * updates a person
    * @param person
    * @param firstName
    * @param lastName
    */
   public void updatePerson(Person person, String firstName, String lastName){
      person.setFristName(firstName);
      person.setLastName(lastName);
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
}
