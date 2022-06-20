import ch.bzz.M326.company.Company;
import ch.bzz.M326.company.Department;
import ch.bzz.M326.company.JobFunctions;
import ch.bzz.M326.company.Team;
import ch.bzz.M326.employees.HRPerson;
import ch.bzz.M326.employees.Participation;
import ch.bzz.M326.employees.Person;

import javax.swing.*;
import java.util.Random;

import java.util.ArrayList;

public class App {
   public static void main(String[] args) {
      App app = new App();

      Company company = new Company("Activato Konkurs AG");

      Department department1 = new Department("Informatik");
      Department department2 = new Department("Kundenservice");
      Department department3 = new Department("Marketing");
      Department department4 = new Department("Forschung und Entwicklung");

      JobFunctions function1 = new JobFunctions("Ausbildner");
      JobFunctions function2 = new JobFunctions("Informationsbeauftragter");
      JobFunctions function3 = new JobFunctions("Kassierer");
      JobFunctions function4 = new JobFunctions("Besitzer");
      JobFunctions function5 = new JobFunctions("Profi");
      JobFunctions function6 = new JobFunctions("Praktikant");
      JobFunctions function7 = new JobFunctions("Projektleiter");
      JobFunctions function8 = new JobFunctions("Stellvertreter");
      JobFunctions function9 = new JobFunctions("Facharbeiter");
      JobFunctions function10 = new JobFunctions("Dolmetscher");
      JobFunctions function11 = new JobFunctions("Journalist");
      JobFunctions function12 = new JobFunctions("Auszubildender");
      JobFunctions function13 = new JobFunctions("Sekretär");

      Team team1 = new Team("T1");
      Team team2 = new Team("T2");
      Team team3 = new Team("T3");
      Team team4 = new Team("T4");
      Team team5 = new Team("T5");
      Team team6 = new Team("T6");
      Team team7 = new Team("T7");
      Team team8 = new Team("T8");
      Team team9 = new Team("T9");
      Team team10 = new Team("T10");
      Team team11 = new Team("T11");
      Team team12 = new Team("T12");
      Team team13 = new Team("T13");

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
      participation1.addFunction(function1);
      participation1.addFunction(function4);
      participation1.addTeam(team1);
      participation1.addTeam(team4);
      participation1.addTeam(team9);
      person1.setParticipation(participation1);

      Participation participation2 = new Participation(person2);
      participation2.addFunction(function12);
      participation2.addFunction(function2);
      participation2.addFunction(function10);
      participation2.addFunction(function5);
      participation2.addTeam(team5);
      participation2.addTeam(team8);
      participation2.addTeam(team10);
      person2.setParticipation(participation2);

      Participation participation3 = new Participation(person3);
      participation3.addFunction(function10);
      participation3.addFunction(function7);
      participation3.addFunction(function8);
      participation3.addTeam(team3);
      participation3.addTeam(team6);
      participation3.addTeam(team3);
      person3.setParticipation(participation3);

      Participation participation4 = new Participation(person4);
      participation4.addFunction(function7);
      participation4.addFunction(function3);
      participation4.addTeam(team1);
      participation4.addTeam(team13);
      participation4.addTeam(team4);
      participation4.addTeam(team9);
      person4.setParticipation(participation4);

      Participation participation5 = new Participation(person5);
      participation5.addFunction(function12);
      participation5.addFunction(function10);
      participation5.addTeam(team11);
      participation5.addTeam(team6);
      participation5.addTeam(team7);
      person5.setParticipation(participation5);

      Participation participation6 = new Participation(person6);
      participation6.addFunction(function4);
      participation6.addFunction(function5);
      participation6.addTeam(team2);
      participation6.addTeam(team13);
      participation6.addTeam(team10);
      person6.setParticipation(participation6);

      Participation participation7 = new Participation(person7);
      participation7.addFunction(function4);
      participation7.addFunction(function12);
      participation7.addFunction(function8);
      participation7.addTeam(team5);
      participation7.addTeam(team12);
      person7.setParticipation(participation7);

      Participation participation8 = new Participation(person8);
      participation8.addFunction(function12);
      participation8.addFunction(function11);
      participation8.addTeam(team13);
      participation8.addTeam(team12);
      participation8.addTeam(team11);
      person8.setParticipation(participation8);

      Participation participation9 = new Participation(person9);
      participation9.addFunction(function9);
      participation9.addFunction(function2);
      participation9.addFunction(function4);
      participation9.addTeam(team1);
      participation9.addTeam(team2);
      participation9.addTeam(team3);
      person9.setParticipation(participation9);

      Participation participation10 = new Participation(person10);
      participation10.addFunction(function4);
      participation10.addFunction(function5);
      participation10.addTeam(team7);
      participation10.addTeam(team8);
      participation10.addTeam(team9);
      person10.setParticipation(participation10);

      Participation participation11 = new Participation(person11);
      participation11.addFunction(function9);
      participation11.addFunction(function10);
      participation11.addTeam(team5);
      participation11.addTeam(team4);
      participation11.addTeam(team3);
      person11.setParticipation(participation11);

      Participation participation12 = new Participation(person12);
      participation12.addFunction(function8);
      participation12.addFunction(function9);
      participation12.addTeam(team3);
      participation12.addTeam(team1);
      participation12.addTeam(team2);
      person12.setParticipation(participation12);

      Participation participation13 = new Participation(person13);
      participation13.addFunction(function1);
      participation13.addFunction(function2);
      participation13.addTeam(team7);
      participation13.addTeam(team6);
      participation13.addTeam(team5);
      person13.setParticipation(participation13);

      Participation participation14 = new Participation(person14);
      participation14.addFunction(function13);
      participation14.addFunction(function12);
      participation14.addTeam(team1);
      participation14.addTeam(team2);
      participation14.addTeam(team3);
      person14.setParticipation(participation14);

      Participation participation15 = new Participation(person15);
      participation15.addFunction(function6);
      participation15.addFunction(function5);
      participation15.addTeam(team9);
      participation15.addTeam(team2);
      participation15.addTeam(team11);
      person15.setParticipation(participation15);

      Participation participation16 = new Participation(person16);
      participation16.addFunction(function3);
      participation16.addFunction(function4);
      participation16.addTeam(team8);
      participation16.addTeam(team9);
      participation16.addTeam(team10);
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


      company.addDepartment(department1);
      company.addDepartment(department2);
      company.addDepartment(department3);
      company.addDepartment(department4);
      company.addFunction(function1);
      company.addFunction(function2);
      company.addFunction(function3);
      company.addFunction(function4);
      company.addFunction(function5);
      company.addFunction(function6);
      company.addFunction(function7);
      company.addFunction(function8);
      company.addFunction(function9);
      company.addFunction(function10);
      company.addFunction(function11);
      company.addFunction(function12);
      company.addFunction(function13);
      company.addTeam(team1);
      company.addTeam(team2);
      company.addTeam(team3);
      company.addTeam(team4);
      company.addTeam(team5);
      company.addTeam(team6);
      company.addTeam(team7);
      company.addTeam(team8);
      company.addTeam(team9);
      company.addTeam(team10);
      company.addTeam(team11);
      company.addTeam(team12);
      company.addTeam(team13);

      HRPerson hrPerson = new HRPerson("Chasper", "Siegenthaler", new ImageIcon("pic.png"), 1);
   }

   public Person randomPerson(){
      Random random = new Random();
      String[] firstNames = {"Guenther", "Jonathan", "Markus", "Peder", "Choban", "Gohan", "Ertan", "Urs", "Michael", "Sebastian", "Sven"};
      String[] lastNames = {"Ronaldinho", "Miroslav", "Van Guenther", "Schleichens", "Mueller", "Martins", "Frei", "Meier", "Dogan"};
      ImageIcon image = new ImageIcon("pic.png");
      int fn = random.nextInt(10);
      int ln = random.nextInt(8);
      Person person = new Person(firstNames[fn], lastNames[ln], image);
      return person;
   }
}
