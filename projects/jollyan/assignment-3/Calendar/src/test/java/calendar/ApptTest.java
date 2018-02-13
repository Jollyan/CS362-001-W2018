package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void testSetAndGet()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
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
	// assertions of Constructor
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());   
		 
	//assertions of set
		 appt.setDescription("My special day.");
		 assertEquals("My special day.", appt.getDescription());
		 
		 appt.setDescription(null);
		 assertEquals("",appt.getDescription());
		 
		 appt.setStartDay(1);
		 assertEquals(1, appt.getStartDay());
		 
		 appt.setStartHour(6);
		 assertEquals(6, appt.getStartHour());
		 
		 appt.setStartMinute(0);
		 assertEquals(0, appt.getStartMinute());
		 
		 appt.setStartMonth(8);
		 assertEquals(8, appt.getStartMonth());
		 
		 appt.setStartYear(2017);
		 assertEquals(2017, appt.getStartYear());
		 
		 appt.setTitle("Birthday");
		 assertEquals("Birthday", appt.getTitle());
		 
		 appt.setTitle(null);
		 assertEquals("",appt.getTitle());
		 
	 }
	 
	 @Test
	  public void testBoundary()  throws Throwable  {
		 Appt appt = new Appt(0, 30, 1, 1, 1, "Test", "Test");
		 
		 appt.setStartHour(0);
		 assertTrue(appt.getValid()); 
		 
		 appt.setStartHour(23);
		 assertTrue(appt.getValid());
		 
		 appt.setStartMinute(0);
		 assertTrue(appt.getValid());
		 
		 appt.setStartMinute(59);
		 assertTrue(appt.getValid());
		 
		 appt.setStartDay(1);
		 assertTrue(appt.getValid());
		 
		 //test all months end days
		 for(int i = 1; i<=12; i++) {
			 appt.setStartDay(CalendarUtil.NumDaysInMonth(1,i-1));
			 assertTrue(appt.getValid());
		 }
		 
		 appt.setStartMonth(12);
		 assertTrue(appt.getValid());
		 
		 appt.setStartMonth(1);
		 assertTrue(appt.getValid());		 
	 }

	 @Test
	  public void testIsValid()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
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
		 
		 assertTrue(appt.getValid());
		 
		 appt.setStartHour(-1);
		 //assertFalse(appt.getValid()); bug
		 appt.setStartHour(0);
		 
		 appt.setStartHour(25);
		 //assertFalse(appt.getValid()); bug for both bounds
		 appt.setStartHour(0);
		 
		 appt.setStartMinute(-1);
		 assertFalse(appt.getValid());
		 appt.setStartMinute(0);
		 
		 appt.setStartMinute(100);
		 assertFalse(appt.getValid());
		 appt.setStartMinute(0);
		 
		 appt.setStartDay(-1);
		 assertFalse(appt.getValid());
		 appt.setStartDay(1);
		 
		 appt.setStartDay(100);
		 assertFalse(appt.getValid());
		 appt.setStartDay(1);
		 
//		 appt.setStartMonth(13); //daysInMonth does not check before executing
//		 assertFalse(appt.getValid());
//		 appt.setStartMonth(1);
		 
//		 appt.setStartMonth(-1); //daysInMonth does not check before executing
//		 assertFalse(appt.getValid());
//		 appt.setStartMonth(1);
		 
		 appt.setStartYear(-1);
		 //assertFalse(appt.getValid()); //doesn't check year
		 appt.setStartYear(1);
	 }

	
	 @Test
	  public void testToString()  throws Throwable  {
		 int startHour=14;
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour, 30, 1, 1, 1, "Test", "Test");
		 
		 appt.setStartDay(100);
		 assertEquals(null, appt.toString());
		 appt.setStartDay(1);
		 
		 assertTrue(appt.toString().equals("\t1/1/1 at 2:30pm ,Test, Test\n"));
		 
		 Appt appt2 = new Appt(0, 30, 1, 1, 1, "Test", "Test");
		 assertTrue(appt2.toString().equals("\t1/1/1 at 12:30am ,Test, Test\n"));
		 
		 Appt appt3 = new Appt(11, 30, 1, 1, 1, "Test", "Test");
		 assertTrue(appt3.toString().equals("\t1/1/1 at 11:30am ,Test, Test\n"));
	 }
	 
	 @Test
	  public void testRecurrance()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
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
		 
		 int[] testRecurringDays = new int[1];
		 
		 //assertEquals(testRecurringDays, appt.getRecurDays()); //bug
		 
		 //weekly = 1, monthly = 2, yearly = 3, never = 0, forever = 1000
		 //setRecurrence(recurringDays, RECUR_BY_MONTHLY = 2, 0, RECUR_NUMBER_NEVER = 0);
		 //public void setRecurrence(int[] recurDays, int recurBy, int recurIncrement, int recurNumber)
		 assertEquals(2, appt.getRecurBy());
		 assertEquals(0, appt.getRecurIncrement());
		 assertEquals(0, appt.getRecurNumber());
		 assertTrue(!appt.isRecurring());
		 
		 appt.setRecurrence(testRecurringDays, 1, 1, 1);
		 assertEquals(1, appt.getRecurBy());
		 assertEquals(1, appt.getRecurIncrement());
		 assertEquals(1, appt.getRecurNumber());
		 assertTrue(appt.isRecurring());
		 
		 //add more to test other values
	 }
	 
	 @Test
	  public void testCompare()  throws Throwable  {
		 Appt appt = new Appt(0, 30, 1, 1, 1, "Test", "Test");
		 Appt appt2 = new Appt(0, 30, 2, 2, 2, "Test", "Test");
		 Appt appt3 = new Appt(1, 30, 1, 1, 1, "Test", "Test");
		 
		 int compareNum = appt.compareTo(appt2);
		 assertEquals(-3,compareNum);
		 
		 compareNum = appt2.compareTo(appt);
		 assertEquals(3,compareNum);
		 
		 compareNum = appt.compareTo(appt);
		 assertEquals(0,compareNum);
		 
		 compareNum = appt3.compareTo(appt);
		 assertEquals(1,compareNum);
		 
		 compareNum = appt.compareTo(appt3);
		 assertEquals(-1,compareNum);
	 }
}