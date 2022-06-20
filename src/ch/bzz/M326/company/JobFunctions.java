package ch.bzz.M326.company;

import java.util.ArrayList;
import java.util.Vector;

/**
 * a job function identified by the name
 *
 * @author Isuf Hasani
 * @since 2022-06-01
 * @version 1.1
 *
 */
public class JobFunctions {

    private Vector<String> designations;
    private String name;
    private int namePerson;

    /**
     * default constuctor of class department
     */
    public JobFunctions(String name){
        designations = new Vector<>();
        this.name = name;
    }

    /**
     * get name of the job function
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * set the name of the job function
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * add the job function to the ArrayList
     * @param function
     */
    public void addJobFunction(String function){
        designations.add(function);
    }

    /**
     * get the job function that has been saved at the specified location.
     * @return job function
     * @param index
     */
    public String getJobFunction(int index){
        return designations.get(index);
    }

    /**
     * remove the job function from the ArrayList
     * @param index
     */
    public void removeJobFunction(int index){
        designations.remove(index);
    }

    public void removeJobFunction(String jobfunction){
        designations.remove(jobfunction);
    }

    public Vector<String> getDesignations() {
        return designations;
    }

    /**
     * gets the number of job functions
     * @return number of job functions
     */
    public int getSize(){
        return designations.size();
    }
}
