import ch.bzz.M326.company.*;
import ch.bzz.M326.employees.*;
import com.beust.jcommander.JCommander;
import org.junit.jupiter.api.BeforeAll;
import org.junit.*;

import javax.swing.*;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Testing different functions of the facades
 * @author Nadim Bhatti
 * @since 2022-06-21
 * @version 1.0
 */
public class Test {

   private static Company company;
   private static StammdatenFacade stammdatenFacade;
   private static ZuordnungFacade zuordnungFacade;
   private static PersonenFacade personenFacade;
   private static UebersichtFacade uebersichtFacade;
   private static PersonErfassenFacade personErfassenFacade;

   @Before
   public void setUp(){
      company = new Company("Activato Konkurs AG");
   }

   @org.junit.Test
   public void test01(){
      assertEquals(company.getCompanyName(), "Activato Konkurs AG");
   }

   @org.junit.Test
   public void test02(){
      JobFunctions jobFunctions = new JobFunctions("Functions");
      jobFunctions.addJobFunction("Nadim");
      jobFunctions.addJobFunction("Bhatti");
      jobFunctions.addJobFunction("A");
      jobFunctions.addJobFunction("B");
      jobFunctions.addJobFunction("C");
      company.setJobFunctions(jobFunctions);
      stammdatenFacade = new StammdatenFacade(company);
      zuordnungFacade = new ZuordnungFacade(company);
      assertEquals(stammdatenFacade.getAllJobFunctions().get(0), "Nadim");
      assertEquals(stammdatenFacade.getAllJobFunctions().get(1), "Bhatti");
      assertEquals(stammdatenFacade.getAllJobFunctions().get(2), "A");
      assertEquals(stammdatenFacade.getAllJobFunctions().get(3), "B");
      assertEquals(stammdatenFacade.getAllJobFunctions().get(4), "C");
      assertEquals(stammdatenFacade.getAllJobFunctions(), zuordnungFacade.getAllJobFunctions());
   }

   @org.junit.Test
   public void test03(){
      Team teams = new Team("Teams");
      teams.addTeam("A");
      teams.addTeam("B");
      teams.addTeam("C");
      teams.addTeam("D");
      company.setTeams(teams);
      stammdatenFacade = new StammdatenFacade(company);
      zuordnungFacade = new ZuordnungFacade(company);
      assertEquals(stammdatenFacade.getAllTeams().get(0), "A");
      assertEquals(stammdatenFacade.getAllTeams().get(1), "B");
      assertEquals(stammdatenFacade.getAllTeams().get(2), "C");
      assertEquals(stammdatenFacade.getAllTeams().get(3), "D");
      assertEquals(stammdatenFacade.getAllTeams(), zuordnungFacade.getAllTeams());
   }

   @org.junit.Test
   public void test04(){
      Department department = new Department("Finance");
      company.addDepartment(department);
      stammdatenFacade = new StammdatenFacade(company);
      zuordnungFacade = new ZuordnungFacade(company);
      assertEquals(stammdatenFacade.getAllDepartments().get(0), "Finance");
      assertEquals(zuordnungFacade.getAllDepartments().get(0), "Finance");
   }

   @org.junit.Test
   public void test05(){
      Person person = new Person("Nadim", "Bhatti", new ImageIcon("pic.png"));
      company.addPerson(person);
      assertEquals(company.getPeople().get(0).getFristName(), "Nadim");
      assertEquals(company.getPeople().get(0).getLastName(), "Bhatti");
   }

   @org.junit.Test
   public void test06(){
      Person person = new Person("Nadim", "Bhatti", new ImageIcon("pic.png"));
      company.addPerson(person);
      personenFacade = new PersonenFacade(company);
      assertEquals(personenFacade.getName(person), "Nadim Bhatti");
   }

   @org.junit.Test
   public void test07(){
      Vector<Person> personen = new Vector<>();
      Person person1 = new Person("A", "B", new ImageIcon("pic.png"));
      Person person2 = new Person("C", "D", new ImageIcon("pic.png"));
      Person person3 = new Person("E", "F", new ImageIcon("pic.png"));
      Person person4 = new Person("G", "H", new ImageIcon("pic.png"));
      Person person5 = new Person("I", "J", new ImageIcon("pic.png"));
      personen.add(person1);
      personen.add(person2);
      personen.add(person3);
      personen.add(person4);
      personen.add(person5);
      company.addPerson(person1);
      company.addPerson(person2);
      company.addPerson(person3);
      company.addPerson(person4);
      company.addPerson(person5);
      uebersichtFacade = new UebersichtFacade(company);
      assertEquals(personen, uebersichtFacade.getMitarbeiterListe());
   }

   @org.junit.Test
   public void test08(){
      Person person = new Person("Nadim", "Bhatti", new ImageIcon("pic.png"));
      company.addPerson(person);
      personenFacade = new PersonenFacade(company);
      personenFacade.updatePerson(person, "Hans","Peter");
      assertEquals(personenFacade.getName(personenFacade.getMitarbeiterListe().get(0)), "Hans Peter");
   }

   @org.junit.Test
   public void test09(){
      JobFunctions jobFunctions = new JobFunctions("Jobfunctions");
      jobFunctions.addJobFunction("Sekretaer");
      company.setJobFunctions(jobFunctions);
      stammdatenFacade = new StammdatenFacade(company);
      stammdatenFacade.updateFunction("Sekretaer", "Kaufmann");
      assertEquals(stammdatenFacade.getAllJobFunctions().get(0), "Kaufmann");
   }

   @org.junit.Test
   public void test10(){
      Person person = new Person("Nadim", "Bhatti", new ImageIcon("pic.png"));
      company.addPerson(person);
      personErfassenFacade = new PersonErfassenFacade(company);
      personErfassenFacade.setName(person, "Max Mustermann");
      assertEquals(personErfassenFacade.getName(person), "Max Mustermann");
   }

   @org.junit.Test
   public void test11(){
      Team team = new Team("Teams");
      team.addTeam("Informatiker");
      company.setTeams(team);
      stammdatenFacade = new StammdatenFacade(company);
      stammdatenFacade.updateTeam("Informatiker", "Mediamatiker");
      assertEquals(stammdatenFacade.getAllTeams().get(0), "Mediamatiker");
   }

   @org.junit.Test
   public void test12(){
      Department department = new Department("Finance");
      company.addDepartment(department);
      stammdatenFacade = new StammdatenFacade(company);
      stammdatenFacade.updateDepartment("Finance", "Analysis");
      assertEquals(stammdatenFacade.getAllDepartments().get(0), "Analysis");
   }

   @org.junit.Test
   public void test13(){
      Department department = new Department("Finance");
      company.addDepartment(department);
      stammdatenFacade = new StammdatenFacade(company);
      stammdatenFacade.deleteDepartment("Finance");
      assertEquals(stammdatenFacade.getAllDepartments().size(), 0);
   }

   @org.junit.Test
   public void test14(){
      Team team = new Team("Team");
      team.addTeam("T1");
      company.setTeams(team);
      stammdatenFacade = new StammdatenFacade(company);
      stammdatenFacade.deleteTeam("T1");
      assertEquals(stammdatenFacade.getAllTeams().size(), 0);
   }

   @org.junit.Test
   public void test15(){
      JobFunctions jobFunctions = new JobFunctions("Functions");
      jobFunctions.addJobFunction("Informatiker");
      company.setJobFunctions(jobFunctions);
      stammdatenFacade = new StammdatenFacade(company);
      stammdatenFacade.deleteFunction("Informatiker");
      assertEquals(stammdatenFacade.getAllJobFunctions().size(), 0);
   }


}


