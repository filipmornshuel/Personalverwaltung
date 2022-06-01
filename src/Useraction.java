import javax.swing.*;
import java.util.ArrayList;

public class Useraction {

    public static int CREATE_PERSON = 0;
    public static int CHANGE_VALUE = 1;
    public static int SET_ASSIGNMENT = 2;
    public static int DELETE_PERSON = 3;
    private ArrayList<String> actionDescription;
    private String entry;


    public Useraction(HRPerson hrPerson, Person person, int action){
        hrPerson.getFristName();
        hrPerson.getLastName();
        if (action >= 0 && action < actionDescription.size()){
            person.getFristName();
            person.getLastName();
        }else {
            System.out.println("unknown action");
        }

    }

    public String getEntry(){
        return entry;
    }
}
