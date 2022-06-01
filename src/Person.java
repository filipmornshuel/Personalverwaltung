import javax.swing.*;

public class Person {

    private ImageIcon photo;
    private String fristName;
    private String lastName;
    private Participation participation;

    public Person(String fristName, String lastName, ImageIcon photo){
        this.fristName = fristName;
        this.lastName = lastName;
        this.photo = photo;
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
}
