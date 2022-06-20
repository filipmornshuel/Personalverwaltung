package ch.bzz.M326.company;

import java.util.ArrayList;

/**
 * a Company identified by the name
 *
 * @author Isuf Hasani
 * @since 2022-06-01
 * @version 1.1
 *
 */
public class Company {

    private String name;
    private ArrayList<Department> departments;
    private ArrayList<JobFunctions> jobFunctions;
    private ArrayList<Team> teams;

    /**
     * constuctor of class department
     * @param name
     */
    public Company(String name){
        this.name = name;
    }

    /**
     * adds a jobfunction to its vector
     * @param jobFunctions function
     */
    public void addFunction(JobFunctions jobFunctions){
        this.jobFunctions.add(jobFunctions);
    }

    /**
     * sets the name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * removes a department
     * @param department
     */
    public void removeDepartment(Department department){
        this.departments.remove(department);
    }

    /**
     * removes jobfunction
     * @param jobFunctions
     */
    public void removeFunction(JobFunctions jobFunctions){
        this.jobFunctions.remove(jobFunctions);
    }

    /**
     * removes a team
     * @param team
     */
    public void removeTeam(Team team){
        this.teams.remove(team);
    }

    /**
     * adds a team to its vector
     * @param team team
     */
    public void addTeam(Team team){
        this.teams.add(team);
    }

    /**
     * gets the Company name
     * @return value of name
     */
    public String getCompanyName() {
        return name;
    }

    /**
     * add the department to the ArrayList
     * @param department
     */
    public void addDepartment(Department department){
       departments.add(department);
    }

    /**
     * get the department that has been saved at the specified location.
     * @return department
     * @param index
     */
    public Department getDepartments(int index) {
        return departments.get(index);
    }

    /**
     * get the department name from the department that has been saved at the specified location.
     * @return name of department
     * @param index
     */
    public String getDepartmentsName(int index){
        return departments.get(index).getName();
    }

    /**
     * remove the department to the ArrayList
     * @param index
     */
    public void removeDepartment(int index){
        departments.remove(index);
    }
    /**
     * gets the number of departments
     * @return number of departments
     */
    public int getNumberOfDepartments(){
        return departments.size();
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(ArrayList<Department> departments) {
        this.departments = departments;
    }

    public void setJobFunctions(ArrayList<JobFunctions> jobFunctions) {
        this.jobFunctions = jobFunctions;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public JobFunctions getJobFunction(int index){
        return jobFunctions.get(index);
    }

    public Team getTeam(int index){
        return teams.get(index);
    }

    public ArrayList<JobFunctions> getJobFunctions() {
        return jobFunctions;
    }
}
