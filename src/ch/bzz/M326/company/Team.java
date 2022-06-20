package ch.bzz.M326.company;

import java.util.ArrayList;
import java.util.Vector;

public class Team {

    private Vector<String> designations;
    private String name;

    public  void removeTeam(String team){
        designations.remove(team);
    }

    public Vector<String> getDesignations() {
        return designations;
    }

    public Team(String name){
        this.name = name;
        designations = new Vector<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addTeam(String team){
        designations.add(team);
    }

    public String getTeam(int index){
        return designations.get(index);
    }

    public void removeTeam(int index){
        designations.remove(index);
    }

    public int getSize(){
        return designations.size();
    }
}
