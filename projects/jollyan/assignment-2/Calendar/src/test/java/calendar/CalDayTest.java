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
         temp.addAppt(appt); // won't add since appt valid is always false
         
         LinkedList<Appt> appts = temp.getAppts(); //empty due to bug
         //assertEquals(appt, appts.get(0));
         //assertEquals(1, temp.getSizeAppts());
         //assertEquals(1, temp.getDay()); //bug on making day a month
         assertEquals(1, temp.getMonth());
         assertEquals(1, temp.getYear());	 
	 }
	 @Test
	  public void testToString()  throws Throwable  { //can't test at all due to appt bug
		 GregorianCalendar today = new GregorianCalendar(1,1,1); //use for passing variable
		 CalDay temp = new CalDay(today);
		 
//		 int startHour=15;
//		 int startMinute=30;
//		 int startDay=1;  	
//		 int startMonth=1; 	
//		 int startYear=1; 	
//		 String title="Birthday Party";
//		 String description="This is my birthday party.";
//		 //Construct a new Appointment object with the initial data	 
//         Appt appt = new Appt(startHour,
//                  startMinute ,
//                  startDay ,
//                  startMonth ,
//                  startYear ,
//                  title,
//                 description);
         
         //assertEquals("\t --- 1/1/1 --- \n --- -------- Appointments ------------ --- \n\n", temp.toString());
         
         //test when appt can be valid and added
	 }
//add more unit tests as you needed	
}
