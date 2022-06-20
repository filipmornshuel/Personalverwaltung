package ch.bzz.M326.employees;

import ch.bzz.M326.company.Company;

import javax.swing.*;

/**
 * This class is an interface for all data that is needed for the GUI "Person erfassen"
 * @author Nadim Bhatti
 * @since 2022-06-20
 * @version 1.0
 */
public class PersonErfassenFacade {

   private Company company;

   public PersonErfassenFacade(Company company){
      this.company = company;
   }

   /**
    * returns the full name of a person
    * @return first name
    */
   public String getName(Person person){
      return person.getFristName() + " " + person.getLastName();
   }

   public void setName(Person person, String name){
      String[] splitted = name.split(" ");
      person.setFristName(splitted[0]);
      person.setLastName(splitted[1]);
   }

   /**
    * returns the photo of the person
    * @return photo
    */
   public ImageIcon getPhoto(Person person){
      return person.getPhoto();
   }
}
