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
    * this method adds a department
    * @param department department
    */
   public void addDepartment(Department department){
      company.addDepartment(department);
   }

   /**
    * removes a department
    * @param department
    */
   public void deleteDepartment(Department department){
      company.removeDepartment(department);
   }

   /**
    * updates a department
    * @param department
    * @param name name as String
    */
   public void updateDepartment(Department department, String name){
      department.setName(name);
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
