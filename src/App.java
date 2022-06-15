import ch.bzz.M326.company.Company;
import ch.bzz.M326.company.Department;

import java.util.ArrayList;

public class App {
   public static void main(String[] args) {
      Company company = new Company("Activato Konkurs AG");
      ArrayList<Department> departments = new ArrayList<>();
      Department department1 = new Department("Informatik");
      Department department2 = new Department("Kundenservice");
      Department department3 = new Department("Marketing");
      Department department4 = new Department("Forschung und Entwicklung");
      departments.add(department1);
      departments.add(department2);
      departments.add(department3);
      departments.add(department4);
   }
}
