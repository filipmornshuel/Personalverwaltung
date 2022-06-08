package ch.bzz.M326.employees;

import javax.swing.*;
import java.util.Vector;

/**
 * This class is an interface for all data that is needed for the ProfilGUI
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

   public Vector<String> getFunctions(){
      Vector<String> functions = new Vector<String>();
      for (int i = 0; i < person.getParticipation().getNumberOfFunctions(); i++) {
         functions.add(person.getParticipation().getFunctionName(i));
      }
      return functions;
   }

   public Vector<String> getTeams(){

   }
}
