package ch.bzz.M326.employees;

import ch.bzz.M326.company.JobFunctions;
import ch.bzz.M326.company.Team;

import java.util.ArrayList;
import java.util.Vector;

/**
 * a Participation in the company
 *
 * @author Isuf Hasani
 * @since 2022-06-01
 * @version 1.1
 *
 */
public class Participation {

    private JobFunctions functions;
    private Team teams;
    private Person owner;

    /**
     * constrcutor for the class Particiption
     * @param person
     */
    public Participation(Person person){
        owner = person;
        functions = new JobFunctions("Functions");
        teams = new Team("Teams");
    }

    /**
     * add the jobFunction to the ArrayList
     * @param jobFunction
     */
    public void addFunction(String jobFunction){
        this.functions.addJobFunction(jobFunction);
        owner.setJobfunction(jobFunction);
    }

    /**
     * get name of function that has been saved at the specified location.
     * @param index
     * @return name of function
     */
    public String getFunctionName(int index){
        return functions.getJobFunction(index);
    }

    /**
     * remove function from ArrayList
     * @param index
     */
    public void removeFunction(int index){
        functions.removeJobFunction(index);
    }

    /**
     * get number of function in the Particiption
     * @return number of function
     */
    public int getNumberOfFunctions(){
        return functions.getDesignations().size();
    }

    /**
     * add team to the ArrayList
     * @param team
     */
    public void addTeam(String team){
        teams.addTeam(team);
        owner.setTeam(team);
    }

    /**
     * get name of function that has been saved at the specified location.
     * @param index
     * @return name of team
     */
    public String getTeamName(int index){
        return teams.getTeam(index);
    }

    /**
     * remove team from ArrayList
     * @param index
     */
    public void removeTeam(int index){
        teams.removeTeam(index);
    }

    /**
     * get number of teams in the Particiption
     * @return number of teams
     */
    public int getNumberOfTeams(){
        return teams.getDesignations().size();
    }
}
