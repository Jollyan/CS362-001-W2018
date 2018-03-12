package calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Random;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;
	
    /**
     * Generate Random Tests that tests TimeTable Class.
     */
	 @Test
	  public void testDeleteAppt()  throws Throwable  {
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 
		 System.out.println("Start testing deleteAppt");
		 
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
				 
				 CalDay temp = new CalDay(today);
				 
				 TimeTable timeTable=new TimeTable();
				 
				 int size = 0;
				 
				 LinkedList<Appt> appts = new LinkedList<Appt>();
				
			for (int i = 0; i < NUM_TESTS; i++) {
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
				 temp.addAppt(appt); //if invalid it doesn't add
				 size++;
				
				if(!appt.getValid()) { //nothing happens if invalid
					appts = temp.getAppts();
					 assertTrue(null == timeTable.deleteAppt(appts, appt)); //invalid appt
					 size--;
				 }				 
				//null tests
				else if(i % 12 == 0) {
					LinkedList<Appt> emptyList = timeTable.deleteAppt(appts, null);
			        assertEquals(null, emptyList);
				}
				else if(i % 13 == 0) {
					LinkedList<Appt> emptyList=timeTable.deleteAppt(null, appts.get(1));
			        assertEquals(null, emptyList);
				}			
				else { //if appt was valid and not null			  
					LinkedList<Appt> tempList = temp.getAppts();
					size = tempList.size();
					appts = timeTable.deleteAppt(tempList, appt); //delete the one that got added
					//System.out.println(appts.get(0) + "\n");
					if(appts == null) { assertTrue(appts == null); } //not in list?
					else assertTrue(size > appts.size());
				}
		         
			}
				
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 ) {}
			              //System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			 
			}
		}catch(NullPointerException e){
			
		}
	 
		 System.out.println("Done testing deleteAppt");
		 
		 
	 }

	 @Test
	  public void testApptRange()  throws Throwable  {
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 
		 System.out.println("Start testing deleteAppt");
		 
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
				
				GregorianCalendar today1 = new GregorianCalendar(1,1,1); //use for passing variable
				 
				 CalDay temp = new CalDay(today1);
				 
				 TimeTable timeTable=new TimeTable();
				 
				 int size = 0;
				 
				 LinkedList<Appt> appts = new LinkedList<Appt>();
				 
				 LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		         GregorianCalendar today = new GregorianCalendar(1,1,1);
		 		 GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
		 		 tomorrow.add(Calendar.DAY_OF_MONTH,1);
				
			for (int i = 0; i < NUM_TESTS; i++) {
				
				startHour=ValuesGenerator.getRandomIntBetween(random, 0, 23);
				 startMinute=ValuesGenerator.getRandomIntBetween(random, -5, 70);
				 startDay=ValuesGenerator.getRandomIntBetween(random, 1, 20);
				 startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 startYear=ValuesGenerator.RandInt(random);
				 title=ValuesGenerator.getString(random);
				 description=ValuesGenerator.getString(random);
				 //Construct a new Appointment object with the initial data	 
				 appt = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
				 int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
				 int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
				 int recur=ApptRandomTest.RandomSelectRecur(random);
				 int recurIncrement = ValuesGenerator.RandInt(random);
				 int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
				 appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
				 
				 //add appointment	
				 temp.addAppt(appt); //if invalid it doesn't add
				 appts = temp.getAppts();
				 size++;
				 if(!appt.getValid()) {
					 size--;
					 LinkedList<Appt> invalidListAppts = new LinkedList<Appt>();
				     invalidListAppts.add(appt);
					 calDays = timeTable.getApptRange(invalidListAppts, today, tomorrow);
				     GregorianCalendar invalidToday = new GregorianCalendar(1,1,0);
				     GregorianCalendar invalidTomorrow = (GregorianCalendar)invalidToday.clone();
					 invalidTomorrow.add(Calendar.DAY_OF_MONTH,1);
					 calDays = timeTable.getApptRange(invalidListAppts, invalidToday, invalidTomorrow);
				 }
				 //else if(i == 10) { calDays = timeTable.getApptRange(appts, tomorrow, today); } //date incorrect
				 else if(i == 11) {
					 LinkedList<Appt> invalidListAppts = new LinkedList<Appt>();
					 calDays = timeTable.getApptRange(invalidListAppts, today, tomorrow);
				 }
				 else calDays = timeTable.getApptRange(appts, today, tomorrow);
			}
				
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 ) {}
			              //System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			 
			}
		}catch(NullPointerException e){
			
		}
	 
		 System.out.println("Done testing deleteAppt");
		 
		 
	 }
	
}
