package ch.bzz.M326.company;

import java.util.Vector;

/**
 * This class is an interface for all data that is needed for the Tab "Stammdaten"
 * @author Nadim Bhatti
 * @since 2022-06-15
 * @version 1.0
 */
public class StammdatenFacade {

   private Company company;

   public StammdatenFacade(Company company){}

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
    * gets all functions
    * @return all functions as a String Vector
    */
   public Vector<String> getAllJobFunctions(){
      Vector<String> allJobFunctions = new Vector<>();
      for (int i = 0; i < company.getJobFunctions().size(); i++) {
         allJobFunctions.add(company.getJobFunction(i).getName());
      }
      return allJobFunctions;
   }

   /**
    * gets all teams
    * @return all teams as a String Vector
    */
   public Vector<String> getAllTeams(){
      Vector<String> allTeams = new Vector<>();
      for (int i = 0; i < company.getTeams().size(); i++) {
         allTeams.add(company.getTeam(i).getName());
      }
      return allTeams;
   }

   public String getFirmaName(){
      return company.getCompanyName();
   }

}
