package ch.bzz.M326.employees;

import ch.bzz.M326.company.Department;
import ch.bzz.M326.employees.Participation;

import javax.swing.*;

/**
 * a Participation in the company
 *
 * @author Isuf Hasani
 * @since 2022-06-01
 * @version 1.1
 *
 */
public class Person {

    private ImageIcon photo;
    private String fristName;
    private String lastName;
    private Participation participation;
    private String jobfunction;
    private String team;
    private Department department;
    private String role;

    public Person(String fristName, String lastName, ImageIcon photo){
        this.fristName = fristName;
        this.lastName = lastName;
        this.photo = photo;
    }

    public void setJobfunction(String jobfunction) {
        this.jobfunction = jobfunction;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getJobfunction() {
        return jobfunction;
    }

    public String getTeam() {
        return team;
    }

    public String getName(){
        return fristName + " " + lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setFristName(String fristName) {
        this.fristName = fristName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoto(ImageIcon photo) {
        this.photo = photo;
    }

    public ImageIcon getPhoto() {
        return photo;
    }

    public String getFristName() {
        return fristName;
    }

    public String getLastName() {
        return lastName;
    }

    public Participation getParticipation(){
        return participation;
    }

    public void setParticipation(Participation participation) {
        this.participation = participation;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        if(this.department == null){
            this.department = department;
        }else{
            this.department.removeMemberByPerson(this);
            this.department = department;
            this.department.addMember(this);
        }
    }
}
