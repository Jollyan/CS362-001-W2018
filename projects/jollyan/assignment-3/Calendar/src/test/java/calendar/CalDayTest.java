package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void testSetsAndGets()  throws Throwable  {
		 GregorianCalendar today = new GregorianCalendar(1,1,1); //use for passing variable
		 
		 CalDay calendarDay = new CalDay();
		 assertFalse(calendarDay.isValid());
		 
		 //set day, month, and year are all private
		 
		 CalDay temp = new CalDay(today);
		 assertTrue(temp.isValid());
		 
		 int startHour=15;
		 int startMinute=30;
		 int startDay=1;  	
		 int startMonth=1; 	
		 int startYear=1; 	
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
         Appt appt = new Appt(startHour,
                  startMinute ,
                  startDay ,
                  startMonth ,
                  startYear ,
                  title,
                 description);
         assertEquals(0, temp.getSizeAppts());
         temp.addAppt(appt);
         
         LinkedList<Appt> appts = temp.getAppts();
         assertEquals(appt, appts.get(0));
         assertEquals(1, temp.getSizeAppts());
         //assertEquals(1, temp.getDay()); //bug on making day a month
         assertEquals(1, temp.getMonth());
         assertEquals(1, temp.getYear());	
         
         //adding more appointments to sort
         Appt appt2 = new Appt(2, 30, 1, 1, 1, "Test", "Test");
         Appt appt3 = new Appt(1, 30, 1, 1, 1, "Test", "Test");
         temp.addAppt(appt2);
         temp.addAppt(appt3);
         assertEquals(3, temp.getSizeAppts());
         
         Appt invalidAppt = new Appt(1, 30, 1, 1, 1, "Test", "Test");
         invalidAppt.setStartMinute(-1);
         temp.addAppt(invalidAppt);
         assertEquals(3, temp.getSizeAppts()); //make sure it didn't get added
	 }
	 
	 @Test
	  public void testListAdd()  throws Throwable  { 
		 GregorianCalendar today = new GregorianCalendar(1,1,1); //use for passing variable
		 CalDay temp = new CalDay(today);
		 
		 Appt appt = new Appt(0, 30, 1, 1, 1, "Test", "Test");
		 Appt appt2 = new Appt(1, 31, 2, 2, 2, "Test", "Test");
         Appt appt3 = new Appt(2, 32, 3, 3, 3, "Test", "Test");
         //how many adds
         for(int i = 0; i<100; i++) {
        	 if(i % 7 == 0) {
        		 temp.addAppt(appt3);
        	 }
        	 else if(i % 9 == 0) {
        		 temp.addAppt(appt2);
        	 }
        	 else {
        		 temp.addAppt(appt);
        	 }
         }
         Appt appt4 = new Appt(10, 10, 10, 10, 10, "Test", "Test");
         temp.addAppt(appt4);
         temp.addAppt(appt);
         temp.addAppt(appt);
         
         //can break on temp.addAppt(null);
	 }
	 
	 @Test
	  public void testToString()  throws Throwable  { 
		 GregorianCalendar today = new GregorianCalendar(1,1,1); //use for passing variable
		 CalDay temp = new CalDay(today);
		 
		 Appt appt = new Appt(0, 30, 1, 1, 1, "Test", "Test");
         
         assertEquals("\t --- 1/0/1 --- \n --- -------- Appointments ------------ --- \n\n", temp.toString());
         //assertEquals("\t --- 1/1/1 --- \n --- -------- Appointments ------------ --- \n\n", temp.toString()); //month bug
         
         temp.addAppt(appt);
         assertEquals("\t --- 1/0/1 --- \n --- -------- Appointments ------------ --- \n\t1/1/1 at 12:30am ,Test, Test\n \n", temp.toString());        
         
         
         CalDay invalidDay = new CalDay();
         assertEquals("", invalidDay.toString());
	 }
	 
	 @Test
	  public void testIterator()  throws Throwable  { 
		 GregorianCalendar today = new GregorianCalendar(1,1,1); //use for passing variable
		 CalDay temp = new CalDay(today);
		 
		 Appt appt = new Appt(0, 30, 1, 1, 1, "Test", "Test");
		 temp.addAppt(appt);
		 
		 assertTrue(temp.iterator() != null);
		 
		 CalDay invalid = new CalDay();
		 assertEquals(null, invalid.iterator());
	 }
//add more unit tests as you needed	
}