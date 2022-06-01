import java.util.ArrayList;

public class Team {

    private ArrayList<String> designations;
    private String name;


    public Team(String name){
        this.name = name;
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
