package ch.bzz.M326.employees;

import ch.bzz.M326.company.JobFunctions;
import ch.bzz.M326.company.Team;

import java.util.ArrayList;

/**
 * a ch.bzz.M326.employees.Participation in the company
 *
 * @author Isuf Hasani
 * @since 2022-06-01
 * @version 1.1
 *
 */
public class Participation {

    private ArrayList<JobFunctions> functions;
    private ArrayList<Team> teams;
    private Person owner;

    /**
     * constrcutor for the class Particiption
     * @param person
     */
    public Participation(Person person){
        owner = person;
    }

    /**
     * add the jobFunction to the ArrayList
     * @param jobFunction
     */
    public void addFunction(JobFunctions jobFunction){
        functions.add(jobFunction);
    }

    /**
     * get name of function that has been saved at the specified location.
     * @param index
     * @return name of function
     */
    public String getFunctionName(int index){
        return functions.get(index).getName();
    }

    /**
     * remove function from ArrayList
     * @param index
     */
    public void removeFunction(int index){
        functions.remove(index);
    }

    /**
     * get number of function in the Particiption
     * @return number of function
     */
    public int getNumberOfFunctions(){
        return functions.size();
    }

    /**
     * add team to the ArrayList
     * @param team
     */
    public void addTeam(Team team){
        teams.add(team);
    }

    /**
     * get name of function that has been saved at the specified location.
     * @param index
     * @return name of team
     */
    public String getTeamName(int index){
        return teams.get(index).getName();
    }

    /**
     * remove team from ArrayList
     * @param index
     */
    public void removeTeam(int index){
        teams.remove(index);
    }

    /**
     * get number of teams in the Particiption
     * @return number of teams
     */
    public int getNumberOfTeams(){
        return teams.size();
    }
}
