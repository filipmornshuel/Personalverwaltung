package ch.bzz.M326.company;

import java.util.Vector;

public class StammdatenFacade {

   private Company company;

   public StammdatenFacade(Company company){}

   /**
    * gets all departments
    * @return all department as String Vector
    */
   public Vector<String> getDepartments(){
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
   public Vector<String> getJobFunctions(){
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
   public Vector<String> getTeams(){
      Vector<String> allTeams = new Vector<>();
      for (int i = 0; i < company.getTeams().size(); i++) {
         allTeams.add(company.getTeam(i).getName());
      }
      return allTeams;
   }
}
