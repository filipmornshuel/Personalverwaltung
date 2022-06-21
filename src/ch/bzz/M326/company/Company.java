package ch.bzz.M326.company;

import ch.bzz.M326.employees.HRPerson;
import ch.bzz.M326.employees.Person;
import ch.bzz.M326.log.LogBook;

import java.util.ArrayList;
import java.util.Vector;

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
    private Vector<Department> departments;
    private JobFunctions jobFunctions;
    private Team teams;
    private Vector<Person> people;
    private Vector<HRPerson> hrPeople;
    private LogBook logBook;

    /**
     * constuctor of class department
     * @param name
     */
    public Company(String name){
        this.name = name;
        people = new Vector<>();
        departments = new Vector<>();
        hrPeople = new Vector<>();
    }

    /**
     * gets the logbook
     * @return
     */
    public LogBook getLogBook() {
        return logBook;
    }

    /**
     * sets the logbook
     * @param logBook
     */
    public void setLogBook(LogBook logBook) {
        this.logBook = logBook;
    }

    /**
     * adds a hrPerson
     * @param hrPerson
     */
    public void addHRPerson(HRPerson hrPerson){
        hrPeople.add(hrPerson);
    }

    /**
     * removes a hrPerson
     * @param hrPerson
     */
    public void removeHRPerson(HRPerson hrPerson){
        hrPeople.remove(hrPerson);
    }

    /**
     * sets the HRPeople
     * @param hrPeople
     */
    public void setHrPeople(Vector<HRPerson> hrPeople) {
        this.hrPeople = hrPeople;
    }

    /**
     * adds a person
     * @param person
     */
    public void addPerson(Person person){
        people.add(person);
    }

    /**
     * removes a person
     * @param person
     */
    public void removePerson(Person person){
        people.remove(person);
    }

    /**
     * sets the people
     * @param people
     */
    public void setPeople(Vector<Person> people) {
        this.people = people;
    }

    /**
     * gets all people
     * @return
     */
    public Vector<Person> getPeople() {
        return people;
    }

    /**
     * adds a jobfunction
     * @param jobfunction function
     */
    public void addFunction(String jobfunction){
        this.jobFunctions.addJobFunction(jobfunction);
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
     * @param jobFunction
     */
    public void removeFunction(String jobFunction){
        this.jobFunctions.removeJobFunction(jobFunction);
    }

    /**
     * removes a team
     * @param team
     */
    public void removeTeam(String team){
        this.teams.removeTeam(team);
    }

    /**
     * adds a team
     * @param team team
     */
    public void addTeam(String team){
        this.teams.addTeam(team);
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

    /**
     * gets the department
     * @return
     */
    public Vector<Department> getDepartments() {
        return departments;
    }

    /**
     * sets thed departments
     * @param departments
     */
    public void setDepartments(Vector<Department> departments) {
        this.departments = departments;
    }

    /**
     * gets the jobfunctions
     * @param jobFunctions
     */
    public void setJobFunctions(JobFunctions jobFunctions) {
        this.jobFunctions = jobFunctions;
    }

    /**
     * sets the teams
     * @param teams
     */
    public void setTeams(Team teams) {
        this.teams = teams;
    }

    /**
     * gets the teams
     * @return
     */
    public Team getTeams() {
        return teams;
    }

    /**
     * gets a jobfunction
     * @param index
     * @return
     */
    public String getJobFunction(int index){
        return jobFunctions.getJobFunction(index);
    }

    /**
     * gets a team
     * @param index
     * @return
     */
    public String getTeam(int index){
        return teams.getTeam(index);
    }

    /**
     * gets a jobfunction
     * @return
     */
    public JobFunctions getJobFunctions() {
        return jobFunctions;
    }

}
