package ch.bzz.M326.company;

import java.util.ArrayList;

/**
 * a ch.bzz.M326.company.Company identified by the name
 *
 * @author Isuf Hasani
 * @since 2022-06-01
 * @version 1.1
 *
 */
public class Company {

    private String name;
    private ArrayList<Department> departments;

    /**
     * constuctor of class department
     * @param name
     */
    public Company(String name){
        this.name = name;
    }

    /**
     * gets the ch.bzz.M326.company.Company name
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
}
