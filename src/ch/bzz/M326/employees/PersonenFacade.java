package ch.bzz.M326.employees;

import ch.bzz.M326.company.Company;

import javax.swing.*;
import java.util.Vector;

/**
 * This class is an interface for all data that is needed for the Tab "Personen"
 * @author Nadim Bhatti
 * @since 2022-06-19
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
      Vector<Person> allPersons = new Vector<>();
      for (int i = 0; i < company.getDepartments().size(); i++) {
         for (int j = 0; j < company.getDepartments(i).getNumberOfMembers(); j++) {
            allPersons.add(company.getDepartments(i).getMembers(j));
         }
      }
      return allPersons;
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
