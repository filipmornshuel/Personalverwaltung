import ch.bzz.M326.company.Company;
import ch.bzz.M326.company.Department;
import ch.bzz.M326.company.JobFunctions;
import ch.bzz.M326.company.Team;
import ch.bzz.M326.employees.HRPerson;
import ch.bzz.M326.employees.Participation;
import ch.bzz.M326.employees.Person;
import ch.bzz.M326.gui.mainFrame;

import javax.swing.*;
import java.util.Random;

public class App {
   public static void main(String[] args) {
      App app = new App();

      Company company = new Company("Activato Konkurs AG");

      Department department1 = new Department("Informatik");
      Department department2 = new Department("Kundenservice");
      Department department3 = new Department("Marketing");
      Department department4 = new Department("Forschung und Entwicklung");

      JobFunctions functions = new JobFunctions("JobFunctions");
      functions.addJobFunction("Ausbilnder");
      functions.addJobFunction("Informationsbeauftragter");
      functions.addJobFunction("Kassierer");
      functions.addJobFunction("Besitzer");
      functions.addJobFunction("Profi");
      functions.addJobFunction("Praktikant");
      functions.addJobFunction("Projektleiter");
      functions.addJobFunction("Stellvertreter");
      functions.addJobFunction("Facharbeiter");
      functions.addJobFunction("Dolmetscher");
      functions.addJobFunction("Journalist");
      functions.addJobFunction("Auszubildender");
      functions.addJobFunction("Sekretär");

      company.setJobFunctions(functions);

      Team team = new Team("Teams");
      team.addTeam("T1");
      team.addTeam("T2");
      team.addTeam("T3");
      team.addTeam("T4");
      team.addTeam("T5");
      team.addTeam("T6");
      team.addTeam("T7");
      team.addTeam("T8");
      team.addTeam("T9");
      team.addTeam("T10");
      team.addTeam("T11");
      team.addTeam("T12");
      team.addTeam("T13");

      company.setTeams(team);

      Person person1 = app.randomPerson();
      Person person2 = app.randomPerson();
      Person person3 = app.randomPerson();
      Person person4 = app.randomPerson();
      Person person5 = app.randomPerson();
      Person person6 = app.randomPerson();
      Person person7 = app.randomPerson();
      Person person8 = app.randomPerson();
      Person person9 = app.randomPerson();
      Person person10 = app.randomPerson();
      Person person11 = app.randomPerson();
      Person person12 = app.randomPerson();
      Person person13 = app.randomPerson();
      Person person14 = app.randomPerson();
      Person person15 = app.randomPerson();
      Person person16 = app.randomPerson();

      Participation participation1 = new Participation(person1);
      participation1.addFunction(app.randomFunction());
      participation1.addFunction(app.randomFunction());
      participation1.addTeam(app.randomTeam());
      participation1.addTeam(app.randomTeam());
      person1.setParticipation(participation1);

      Participation participation2 = new Participation(person2);
      participation2.addFunction(app.randomFunction());
      participation2.addFunction(app.randomFunction());
      participation2.addTeam(app.randomTeam());
      participation2.addTeam(app.randomTeam());
      person2.setParticipation(participation2);

      Participation participation3 = new Participation(person3);
      participation3.addFunction(app.randomFunction());
      participation3.addFunction(app.randomFunction());
      participation3.addTeam(app.randomTeam());
      participation3.addTeam(app.randomTeam());
      person3.setParticipation(participation3);

      Participation participation4 = new Participation(person4);
      participation4.addFunction(app.randomFunction());
      participation4.addFunction(app.randomFunction());
      participation4.addTeam(app.randomTeam());
      participation4.addTeam(app.randomTeam());
      person4.setParticipation(participation4);

      Participation participation5 = new Participation(person5);
      participation5.addFunction(app.randomFunction());
      participation5.addFunction(app.randomFunction());
      participation5.addTeam(app.randomTeam());
      participation5.addTeam(app.randomTeam());
      person5.setParticipation(participation5);

      Participation participation6 = new Participation(person6);
      participation6.addFunction(app.randomFunction());
      participation6.addFunction(app.randomFunction());
      participation6.addTeam(app.randomTeam());
      participation6.addTeam(app.randomTeam());
      person6.setParticipation(participation6);

      Participation participation7 = new Participation(person7);
      participation7.addFunction(app.randomFunction());
      participation7.addFunction(app.randomFunction());
      participation7.addTeam(app.randomTeam());
      participation7.addTeam(app.randomTeam());
      person7.setParticipation(participation7);

      Participation participation8 = new Participation(person8);
      participation8.addFunction(app.randomFunction());
      participation8.addFunction(app.randomFunction());
      participation8.addTeam(app.randomTeam());
      participation8.addTeam(app.randomTeam());
      person8.setParticipation(participation8);

      Participation participation9 = new Participation(person9);
      participation9.addFunction(app.randomFunction());
      participation9.addFunction(app.randomFunction());
      participation9.addTeam(app.randomTeam());
      participation9.addTeam(app.randomTeam());
      person9.setParticipation(participation9);

      Participation participation10 = new Participation(person10);
      participation10.addFunction(app.randomFunction());
      participation10.addFunction(app.randomFunction());
      participation10.addTeam(app.randomTeam());
      participation10.addTeam(app.randomTeam());
      person10.setParticipation(participation10);

      Participation participation11 = new Participation(person11);
      participation11.addFunction(app.randomFunction());
      participation11.addFunction(app.randomFunction());
      participation11.addTeam(app.randomTeam());
      participation11.addTeam(app.randomTeam());
      person11.setParticipation(participation11);

      Participation participation12 = new Participation(person12);
      participation12.addFunction(app.randomFunction());
      participation12.addFunction(app.randomFunction());
      participation12.addTeam(app.randomTeam());
      participation12.addTeam(app.randomTeam());
      person12.setParticipation(participation12);

      Participation participation13 = new Participation(person13);
      participation13.addFunction(app.randomFunction());
      participation13.addFunction(app.randomFunction());
      participation13.addTeam(app.randomTeam());
      participation13.addTeam(app.randomTeam());
      person13.setParticipation(participation13);

      Participation participation14 = new Participation(person14);
      participation14.addFunction(app.randomFunction());
      participation14.addFunction(app.randomFunction());
      participation14.addTeam(app.randomTeam());
      participation14.addTeam(app.randomTeam());
      person14.setParticipation(participation14);

      Participation participation15 = new Participation(person15);
      participation15.addFunction(app.randomFunction());
      participation15.addFunction(app.randomFunction());
      participation15.addTeam(app.randomTeam());
      participation15.addTeam(app.randomTeam());
      person15.setParticipation(participation15);

      Participation participation16 = new Participation(person16);
      participation16.addFunction(app.randomFunction());
      participation16.addFunction(app.randomFunction());
      participation16.addTeam(app.randomTeam());
      participation16.addTeam(app.randomTeam());
      person16.setParticipation(participation16);

      department1.addMember(person1);
      department1.addMember(person2);
      department1.addMember(person3);
      department1.addMember(person4);

      department1.addMember(person5);
      department1.addMember(person6);
      department1.addMember(person7);
      department1.addMember(person8);

      department1.addMember(person9);
      department1.addMember(person10);
      department1.addMember(person11);
      department1.addMember(person12);

      department1.addMember(person13);
      department1.addMember(person14);
      department1.addMember(person15);
      department1.addMember(person16);


      company.addPerson(person1);
      company.addPerson(person2);
      company.addPerson(person3);
      company.addPerson(person4);
      company.addPerson(person5);
      company.addPerson(person6);
      company.addPerson(person7);
      company.addPerson(person8);
      company.addPerson(person9);
      company.addPerson(person10);
      company.addPerson(person11);
      company.addPerson(person12);
      company.addPerson(person13);
      company.addPerson(person14);
      company.addPerson(person15);
      company.addPerson(person16);

      company.addDepartment(department1);
      company.addDepartment(department2);
      company.addDepartment(department3);
      company.addDepartment(department4);



      HRPerson hrPerson = new HRPerson("Chasper", "Siegenthaler", new ImageIcon("pic.png"), 1);

      company.addHRPerson(hrPerson);

      mainFrame mainFrame = new mainFrame(company);

      System.out.println(person1.getFristName());
      System.out.println(person2.getFristName());
      System.out.println(person3.getFristName());
      System.out.println(person4.getFristName());
      System.out.println(person5.getFristName());
      System.out.println(person6.getFristName());
      System.out.println(person7.getFristName());
      System.out.println(person8.getFristName());
      System.out.println(person9.getFristName());
      System.out.println(person10.getFristName());
      System.out.println(person11.getFristName());
      System.out.println(person12.getFristName());
      System.out.println(person13.getFristName());
      System.out.println(person14.getFristName());
      System.out.println(person15.getFristName());
      System.out.println(person16.getFristName());




   }

   public Person randomPerson(){
      Random random = new Random();
      String[] firstNames = {"Guenther", "Jonathan", "Markus", "Peder", "Choban", "Gohan", "Erthan", "Urs", "Michael", "Sebastian", "Sven"};
      String[] lastNames = {"Ronaldinho", "Miroslav", "Van Guenther", "Schleichens", "Mueller", "Martins", "Frei", "Meier", "Dogan"};
      ImageIcon image = new ImageIcon("pic.png");
      int fn = random.nextInt(10);
      int ln = random.nextInt(8);
      Person person = new Person(firstNames[fn], lastNames[ln], image);
      return person;
   }

   public String randomFunction(){
      Random random = new Random();
      String[] functions = {"Ausbilnder", "Informationsbeauftragter", "Kassierer", "Besitzer", "Profi", "Praktikant", "Projektleiter", "Stellvertreter", "Facharbeiter", "Dolmetscher", "Journalist", "Auszubildender", "Sekretär"};
      int ran1 = random.nextInt(12);
      return functions[ran1];
   }

   public String randomTeam(){
      Random random = new Random();
      String[] teams = {"T1", "T2", "T3", "T4", "T5", "T6", "T7", "T8", "T9", "T10", "T11", "T12", "T13"};
      int ran1 = random.nextInt(12);
      return teams[ran1];
   }
}
