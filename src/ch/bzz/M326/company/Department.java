package ch.bzz.M326.company;

import ch.bzz.M326.employees.Person;

import java.util.ArrayList;

/**
 * a department identified by the name
 *
 * @author Isuf Hasani
 * @since 2022-06-01
 * @version 1.1
 *
 */
public class Department {

    private String name;
    private ArrayList<Person> members;

    /**
     * constuctor of class department
     * @param name
     */
    public Department(String name){
        this.name = name;
    }

    /**
     * gets the Company name
     * @return value of name
     */
    public String getName() {
        return name;
    }

    /**
     * add the person to the ArrayList
     * @param person
     */
    public void addMember(Person person){
        members.add(person);
    }
    /**
     * get the member that has been saved at the specified location.
     * @return member
     * @param index
     */
    public Person getMembers(int index) {
        return members.get(index);
    }

    /**
     * remove the member to the ArrayList
     * @param index
     */
    public void removeMember(int index){
        members.remove(index);
    }

    /**
     * gets the number of members
     * @return number of members
     */
    public int getNumberOfMembers(){
        return members.size();
    }
}
