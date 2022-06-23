package ch.bzz.M326.company;

import java.util.Vector;

/**
 * This class is an interface for all data that is needed for the Tab "Stammdaten"
 * @author Nadim Bhatti
 * @since 2022-06-20
 * @version 1.0
 */
public class StammdatenFacade {

   private Company company;

   public StammdatenFacade(Company company){
      this.company = company;
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
    * this method adds a department
    * @param department department
    */
   public void addDepartment(Department department){
      company.addDepartment(department);
   }

   /**
    * adds either a department, function or a team by the name
    * @param name
    * @param typedText
    */
   public void universalAdd(String name, String typedText){
      switch (name){
         case "Abteilungen":
            addDepartment(new Department(typedText));
            break;
         case "Funktionen":
            addJobFunction(typedText);
            break;
         case "Teams":
            addTeam(typedText);
      }
   }

   public void universalDelete(String name, String delete){
      switch (name){
         case "Abteilungen":
            deleteDepartment(delete);
            break;
         case "Funktionen":
            deleteFunction(delete);
            break;
         case "Teams":
            deleteTeam(delete);
      }
   }

   /**
    * gets size of name
    * @param name
    * @return
    */
   public int universalGetSize(String name){
      switch (name){
         case "Abteilungen":
            return getAllDepartments().size();
         case "Funktionen":
            return getAllJobFunctions().size();
         case "Teams":
            return getAllTeams().size();
         default:
            return 0;
      }
   }

   /**
    * gets list by name
    * @param name
    * @return
    */
   public Vector<String> universalGetList(String name){
      switch (name){
         case "Abteilungen":
            return getAllDepartments();
         case "Funktionen":
            return getAllJobFunctions();
         case "Teams":
            return getAllTeams();
         default:
            return null;
      }
   }

   /**
    * updates element by name
    * @param name
    * @return
    */
   public void universalUpdate(String name, String oldDesignation, String newDesignation){
      switch (name){
         case "Abteilungen":
            updateDepartment(oldDesignation, newDesignation);
            break;
         case "Funktionen":
            updateFunction(oldDesignation, newDesignation);
            break;
         case "Teams":
            updateTeam(oldDesignation, newDesignation);
            break;
      }
   }


   /**
    * removes a department
    * @param department
    */
   public void deleteDepartment(String department){
      for (int i = 0; i < company.getDepartments().size(); i++) {
         if(company.getDepartments(i).getName().equals(department)){
            company.removeDepartment(company.getDepartments(i));
         }
      }
   }

   /**
    * updates a department
    * @param department
    * @param name name as String
    */
   public void updateDepartment(String department, String name){
      for (int i = 0; i < company.getDepartments().size(); i++) {
         if(company.getDepartments(i).getName().equals(department)){
            company.getDepartments(i).setName(name);
         }
      }
   }

   /**
    * gets all functions
    * @return all functions as a String Vector
    */
   public Vector<String> getAllJobFunctions(){
      return company.getJobFunctions().getDesignations();
   }

   /**
    * this method adds a function
    * @param jobFunctions function
    */
   public void addJobFunction(String jobFunctions){
      company.addFunction(jobFunctions);
   }

   /**
    * removes a jobfunction
    * @param jobFunctions
    */
   public void deleteFunction(String jobFunctions){
      company.removeFunction(jobFunctions);
   }

   /**
    * updates a jobfunction
    * @param newJobFunction new name as String
    * @param oldJobFunction old name as String
    */
   public void updateFunction(String oldJobFunction, String newJobFunction){
      company.removeFunction(oldJobFunction);
      company.addFunction(newJobFunction);
   }

   /**
    * gets all teams
    * @return all teams as a String Vector
    */
   public Vector<String> getAllTeams(){
      return company.getTeams().getDesignations();
   }

   /**
    * this method adds a team
    * @param team team
    */
   public void addTeam(String team){
      company.addTeam(team);
   }

   /**
    * removes a team
    * @param team
    */
   public void deleteTeam(String team){
      company.removeTeam(team);
   }

   /**
    * updates a team
    * @param oldteam
    * @param newTeam
    */
   public void updateTeam(String oldteam, String newTeam){
      company.removeTeam(oldteam);
      company.addTeam(newTeam);
   }

   /**
    * gets the name of the company
    * @return name of company as String
    */
   public String getFirmaName(){
      return company.getCompanyName();
   }

   /**
    * sets the name for the company
    * @param name name as String
    */
   public void setFirmaName(String name){
      company.setName(name);
   }
}
