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
      Vector<String> allJobFunctions = new Vector<>();
      for (int i = 0; i < company.getJobFunctions().size(); i++) {
         allJobFunctions.add(company.getJobFunction(i).getName());
      }
      return allJobFunctions;
   }

   /**
    * this method adds a function
    * @param jobFunctions department
    */
   public void addJobFunction(JobFunctions jobFunctions){
      company.addFunction(jobFunctions);
   }

   /**
    * removes a jobfunction
    * @param jobFunctions
    */
   public void deleteFunction(JobFunctions jobFunctions){
      company.removeFunction(jobFunctions);
   }

   /**
    * updates a jobfunction
    * @param jobFunctions
    * @param name name as String
    */
   public void updateFunction(JobFunctions jobFunctions, String name){
      jobFunctions.setName(name);
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

   /**
    * this method adds a team
    * @param team team
    */
   public void addTeam(Team team){
      company.addTeam(team);
   }

   /**
    * removes a team
    * @param team
    */
   public void deleteTeam(Team team){
      company.removeTeam(team);
   }

   /**
    * updates a team
    * @param team
    * @param name
    */
   public void updateTeam(Team team, String name){
      team.setName(name);
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
