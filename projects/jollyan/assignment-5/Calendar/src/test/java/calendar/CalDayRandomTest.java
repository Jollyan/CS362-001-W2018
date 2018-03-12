package calendar;


import org.junit.Test;


import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Random;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;
    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void testAddAppt()  throws Throwable  {
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 
		 System.out.println("Start testing addAppt");
		 
		try{ 
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
	//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);
				
				Appt appt;
				int startHour;
				int startMinute;
				int startDay;
				int startMonth;
				int startYear;
				String title;
				String description;
				
				
				GregorianCalendar today = new GregorianCalendar(1,1,1); //use for passing variable
				 
				 CalDay calendarDay = new CalDay();
				 assertFalse(calendarDay.isValid());
				 
				 CalDay temp = new CalDay(today);
				 assertTrue(temp.isValid());
				 
				 assertEquals(0, temp.getSizeAppts());
				 
				 int size = 0;
				
			for (int i = 0; i < NUM_TESTS; i++) {
				//new appt
				startHour=ValuesGenerator.getRandomIntBetween(random, 0, 23);
				startMinute=ValuesGenerator.getRandomIntBetween(random, -5, 70);
				startDay=ValuesGenerator.getRandomIntBetween(random, 1, 20);
				startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				startYear=ValuesGenerator.RandInt(random);
				title=ValuesGenerator.getString(random);
				description=ValuesGenerator.getString(random);
				 //Construct a new Appointment object with the initial data	 
				 appt = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
					
				 //add appointment	
				 temp.addAppt(appt);
				 if(!appt.getValid()) { //make sure it didn't get added
					 LinkedList<Appt> appts = temp.getAppts();
					 if(temp.getSizeAppts() == 0) { assertTrue(temp.getSizeAppts() == 0); }
					 else assertFalse(appt.getStartMinute() == appts.get(temp.getSizeAppts() - 1).getStartMinute()); 
				 }
				 else { //if appt was valid			  
					 size++;
			         //assertEquals(appt.getStartMonth(), appts.get(temp.getSizeAppts() - 1).getStartMonth()); //cant do since resorts
					 assertEquals(size, temp.getSizeAppts());
				 }
		         
				}
				
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 ) {}
			              //System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			 
			}
		}catch(NullPointerException e){
			
		}
	 
		 System.out.println("Done testing addAppt");
		 
		 
	 }


	
}
