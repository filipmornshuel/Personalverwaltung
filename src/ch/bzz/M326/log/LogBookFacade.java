package ch.bzz.M326.log;

import ch.bzz.M326.company.Company;

import java.util.Vector;

/**
 * This class is an interface for all data that is needed for the Tab "Logbuch"
 * @author Nadim Bhatti
 * @since 2022-06-20
 * @version 1.0
 */
public class LogBookFacade {
   private Company company;

   public LogBookFacade(Company company){
      this.company = company;
   }

   /**
    * returs every entry in a Vector
    * @param logBook
    * @return
    */
   public Vector<String> getAllEntries(LogBook logBook){
      return company.getLogBook().getEntries();
   }

   /**
    * gets the logbook of the company
    * @return
    */
   public LogBook getLogBook(){
      return company.getLogBook();
   }
}
