package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void testGetApptRange()  throws Throwable  {
		 GregorianCalendar calendarDay = new GregorianCalendar(1,1,1); //use for passing variable
		 CalDay temp = new CalDay(calendarDay);
		 
		 int startHour=15;
		 int startMinute=30;
		 int startDay=1;  	
		 int startMonth=1; 	
		 int startYear=1; 	
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 
		 //Construct a new Appointments	 
         Appt appt1 = new Appt(startHour,
                  startMinute ,
                  startDay ,
                  startMonth ,
                  startYear ,
                  title,
                 description);
         
         String title2="Dentist";
		 String description2="Get my Teeth cleaned.";
         Appt appt2 = new Appt(startHour,
                 startMinute+1 ,
                 startDay+1 ,
                 startMonth+1 ,
                 startYear+1 ,
                 title2,
                description2);
         int[] recurDays = new int[0];
         appt1.setRecurrence(recurDays, 1, 1, 10);
         appt2.setRecurrence(recurDays, 2, 0, 0); 
         temp.addAppt(appt1);
         temp.addAppt(appt2);
         
         TimeTable timeTable=new TimeTable();
         LinkedList<CalDay> calDays = new LinkedList<CalDay>();
         GregorianCalendar today = new GregorianCalendar(1,1,1);
 		 GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
 		 tomorrow.add(Calendar.DAY_OF_MONTH,1);
 		 //calDays = timeTable.getApptRange(temp.getAppts(), tomorrow, today); //bad call to test if
 		 calDays = timeTable.getApptRange(temp.getAppts(), today, tomorrow);
         //System.out.println("The number of appointments between "+ todatDate +" and " + tomorrowDate);
		 //calDays = timeTable.getApptRange(listAppts, today, tomorrow);
		 //for (int i = 0; i < calDays.size(); i++)
			//System.out.println(calDays.get(i).toString());
         
 		 assertEquals(calDays.get(0).getMonth(), appt1.getStartMonth());
 		LinkedList<Appt> listAppts = new LinkedList<Appt>();
        listAppts.add(appt1); 
        listAppts.add(appt2);
        listAppts.add(appt2); 
        //calDays = timeTable.getApptRange(listAppts, tomorrow, today); //bad call to test if
        
        
        //test occurrence functions
        
        //invalid appt
        Appt invalidAppt = new Appt(1, 30, 1, 1, 1, "Test", "Test");
        invalidAppt.setStartMinute(-1);
        invalidAppt.setRecurrence(recurDays, 1, 1, 10);
        
        //set up list
        LinkedList<Appt> invalidListAppts = new LinkedList<Appt>();
        invalidListAppts.add(invalidAppt);
        
        //run invalid appt
        calDays = timeTable.getApptRange(invalidListAppts, today, tomorrow);
        GregorianCalendar invalidToday = new GregorianCalendar(1,1,0);
		GregorianCalendar invalidTomorrow = (GregorianCalendar)invalidToday.clone();
		invalidTomorrow.add(Calendar.DAY_OF_MONTH,1);
		calDays = timeTable.getApptRange(invalidListAppts, invalidToday, invalidTomorrow);
		
		//appt before today
		GregorianCalendar beforeToday = new GregorianCalendar(1,1,5);
		GregorianCalendar beforeTomorrow = (GregorianCalendar)beforeToday.clone();
		beforeTomorrow.add(Calendar.DAY_OF_MONTH,1);
		calDays = timeTable.getApptRange(invalidListAppts, beforeToday, beforeTomorrow);
		
		//never recur
		invalidListAppts = new LinkedList<Appt>();
		invalidAppt.setRecurrence(recurDays, 1, 1, 0);
		invalidListAppts.add(invalidAppt);
		calDays = timeTable.getApptRange(invalidListAppts, invalidToday, invalidTomorrow);
		
		//empty appts
		listAppts = new LinkedList<Appt>();
		calDays = timeTable.getApptRange(listAppts, today, tomorrow);
		
		//calDays = timeTable.getApptRange(invalidListAppts, tomorrow, today); //try{  }catch?
	 }
	 
//	@Test
//	  public void testGetApptOccurences()  throws Throwable  { //private method
//		 
//		 int startHour=15;
//		 int startMinute=30;
//		 int startDay=1;  	
//		 int startMonth=1; 	
//		 int startYear=1; 	
//		 String title="Birthday Party";
//		 String description="This is my birthday party.";
//		 
//		 //Construct a new Appointments	 
//        Appt appt = new Appt(startHour,
//                 startMinute ,
//                 startDay ,
//                 startMonth ,
//                 startYear ,
//                 title,
//                description);
//        
//        //weekly = 1, monthly = 2, yearly = 3, never = 0, forever = 1000
//		//setRecurrence(recurringDays, RECUR_BY_MONTHLY = 2, 0, RECUR_NUMBER_NEVER = 0);
//		//public void setRecurrence(int[] recurDays, int recurBy, int recurIncrement, int recurNumber)
//        int[] recurDays = new int[0];
//        appt.setRecurrence(recurDays, 1, 1, 10);
//        
//        GregorianCalendar firstDay = new GregorianCalendar(1,1,1);
//        GregorianCalendar secondDay = new GregorianCalendar(2,2,2);
//        
//        TimeTable timeTable=new TimeTable();
//        LinkedList<GregorianCalendar> daysOccured = timeTable.
//        
//        
//	 }

	 @Test
	  public void testDeleteAppt()  throws Throwable  {
		 
		 int startHour=15;
		 int startMinute=30;
		 int startDay=1;  	
		 int startMonth=1; 	
		 int startYear=1; 	
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 
		 //Construct a new Appointments	 
         Appt appt1 = new Appt(startHour,
                  startMinute ,
                  startDay ,
                  startMonth ,
                  startYear ,
                  title,
                 description);
         
         String title2="Dentist";
		 String description2="Get my Teeth cleaned.";
         Appt appt2 = new Appt(startHour,
                 startMinute+1 ,
                 startDay+1 ,
                 startMonth+1 ,
                 startYear+1 ,
                 title2,
                description2);
         LinkedList<Appt> listAppts = new LinkedList<Appt>();
         listAppts.add(appt1); 
         listAppts.add(appt2);
         listAppts.add(appt2); 
         
         TimeTable timeTable=new TimeTable();
         LinkedList<Appt> listDeletedAppts=timeTable.deleteAppt(listAppts, listAppts.get(1));         
         assertEquals(appt1.getStartMonth(), listDeletedAppts.get(0).getStartMonth());
         
         
         //test null return
         LinkedList<Appt> emptyList=timeTable.deleteAppt(listAppts, null);
         assertEquals(null, emptyList);
         
         emptyList=timeTable.deleteAppt(null, listAppts.get(1));
         assertEquals(null, emptyList);
         
         //invalid appt
         LinkedList<Appt> invalidListAppts = new LinkedList<Appt>();
         Appt invalidAppt = new Appt(1, 30, 1, 1, 1, "Test", "Test");
         invalidAppt.setStartMinute(-1);
         invalidListAppts.add(invalidAppt);
         invalidListAppts.add(invalidAppt);
         emptyList=timeTable.deleteAppt(listAppts, listAppts.get(1));
	 }
	 
	 @Test
	  public void testPermute()  throws Throwable  {
		 
		 int startHour=15;
		 int startMinute=30;
		 int startDay=1;  	
		 int startMonth=1; 	
		 int startYear=1; 	
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 
		 //Construct a new Appointments	 
        Appt appt1 = new Appt(startHour,
                 startMinute ,
                 startDay ,
                 startMonth ,
                 startYear ,
                 title,
                description);
        
        String title2="Dentist";
		 String description2="Get my Teeth cleaned.";
        Appt appt2 = new Appt(startHour,
                startMinute+1 ,
                startDay+1 ,
                startMonth+1 ,
                startYear+1 ,
                title2,
               description2);
        LinkedList<Appt> listAppts = new LinkedList<Appt>();
        listAppts.add(appt2); 
        listAppts.add(appt1); 
        int[] pv = new int[2];
        pv[0] = 0;
        pv[1] = 1;
        
        TimeTable timeTable=new TimeTable();
        listAppts = timeTable.permute(listAppts, pv);
        
        assertEquals(appt1.getStartMonth()+1, listAppts.get(0).getStartMonth());
	 }
}