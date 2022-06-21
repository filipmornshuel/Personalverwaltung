package ch.bzz.M326.company;

import java.util.Vector;

/**
 * This class is an interface for all data that is needed for the authentification
 * @author Nadim Bhatti
 * @since 2022-06-21
 * @version 1.0
 */
public class AuthentificationFacade {

   private Company company;

   public AuthentificationFacade(Company company){
      this.company = company;
   }

   /**
    * gets all hr peoples first and last name as a String
    * @return
    */
   public Vector<String> getAllHRPeople(){
      Vector<String> hr = new Vector<>();
      for (int i = 0; i < company.getHrPeople().size(); i++) {
         hr.add(company.getHrPeople().get(i).getFristName() + " " + company.getHrPeople().get(i).getLastName());
      }
      return hr;
   }
}
