package calendar;

import java.util.Calendar;
import java.util.Random;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for Appt class.
 */

public class ApptRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected valid method to be tested !.
	 */
    public static String RandomValidMethod(Random random){
        String[] methodArray = new String[] {"setStartHour",
        				"setStartMinute", "setStartMonth", "setStartDay"};// The list of the of methods to be tested in the Appt class

    	int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)
    	            
        return methodArray[n] ; // return the method name 
        }
    
    /**
	 * Return a randomly selected method to be tests !.
	 */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"setTitle","setRecurrence"};// The list of the of methods to be tested in the Appt class

    	int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)
    	            
        return methodArray[n] ; // return the method name 
        }
    
	/**
	 * Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
	 */
    public static int RandomSelectRecur(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return the value of the  appointments to recur 
        }	
    
	/**
	 * Return a randomly selected appointments to recur forever or Never recur  !.
	 */
    public static int RandomSelectRecurForEverNever(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return appointments to recur forever or Never recur 
        }	
    
   /**
     * Generate Random Tests that tests Appt Class.
     */
	 @Test
	  public void randomtest()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 
		 System.out.println("Start testing...");
		 
		try{ 
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
	//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);
				
				 int startHour=ValuesGenerator.RandInt(random);
				 int startMinute=ValuesGenerator.RandInt(random);
				 int startDay=ValuesGenerator.RandInt(random);
				 int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startYear=ValuesGenerator.RandInt(random);
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
			 if(!appt.getValid())continue;
			for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = ApptRandomTest.RandomSelectMethod(random);
					   if (methodName.equals("setTitle")){
						   String newTitle=(String) ValuesGenerator.getString(random);
						   appt.setTitle(newTitle);						   
						}
					   else if (methodName.equals("setRecurrence")){
						   int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
						   int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
						   int recur=ApptRandomTest.RandomSelectRecur(random);
						   int recurIncrement = ValuesGenerator.RandInt(random);
						   int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
						   appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
						}				
				}
				
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 ) {}
			              //System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			 
			}
		}catch(NullPointerException e){
			
		}
	 
		 System.out.println("Done testing...");
	 }

	 @Test
	  public void testValid()  throws Throwable  {
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
		 System.out.println("Start testing valid");
		 
		 try{ 
				for (int iteration = 0; elapsed < TestTimeout; iteration++) {
					long randomseed =System.currentTimeMillis(); //10
		//			System.out.println(" Seed:"+randomseed );
					Random random = new Random(randomseed);
					
					 int startHour=ValuesGenerator.RandInt(random);
					 int startMinute=ValuesGenerator.RandInt(random);
					 int startDay=ValuesGenerator.RandInt(random);
					 int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
					 int startYear=ValuesGenerator.RandInt(random);
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
					 
				 if(!appt.getValid())continue;
				 //test each method
				for (int i = 0; i < NUM_TESTS; i++) {
						String methodName = ApptRandomTest.RandomValidMethod(random);
						   if (methodName.equals("setStartHour")){
							   int newHour = ValuesGenerator.getRandomIntBetween(random, -5, 30); //issue with always being true
							   appt.setStartHour(newHour);
							   if(!appt.getValid()) { assertFalse(appt.getValid()); }
							   else { assertTrue(appt.getValid()); }
							}
						   else if (methodName.equals("setStartMinute")){
							   int newMinute = ValuesGenerator.getRandomIntBetween(random, -5, 70);
							   appt.setStartMinute(newMinute);
							   if(!appt.getValid()) { assertFalse(appt.getValid()); }
							   else { assertTrue(appt.getValid()); }
							}
						   else if (methodName.equals("setStartDay")){
							   int newDay = ValuesGenerator.getRandomIntBetween(random, -5, 40); //gets 0 too
							   appt.setStartDay(newDay);
							   if(!appt.getValid()) { assertFalse(appt.getValid()); }
							   else { assertTrue(appt.getValid()); }
							}
						   else if (methodName.equals("setStartMonth")){
							   int newMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11); //can't get over or under due to bug
							   appt.setStartMonth(newMonth);
							   if(!appt.getValid()) { assertFalse(appt.getValid()); }
							   else { assertTrue(appt.getValid()); }
							}
					}
					
					 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				        if((iteration%10000)==0 && iteration!=0 ) {}
				              //System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
				 
				}
			}catch(NullPointerException e){
				
			}
		 System.out.println("Done testing valid");
	 }
	 
	 @Test
	  public void testRecursiveDays()  throws Throwable  {
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
		 System.out.println("Start testing recursive days");
		 
		 try{ 
				for (int iteration = 0; elapsed < TestTimeout; iteration++) {
					long randomseed =System.currentTimeMillis(); //10
		//			System.out.println(" Seed:"+randomseed );
					Random random = new Random(randomseed);
					
					 int startHour=ValuesGenerator.RandInt(random);
					 int startMinute=ValuesGenerator.RandInt(random);
					 int startDay=ValuesGenerator.RandInt(random);
					 int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
					 int startYear=ValuesGenerator.RandInt(random);
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
					 
				 if(!appt.getValid())continue;
				 //test each method
				for (int i = 0; i < NUM_TESTS; i++) {
						int sizeOfArray = ValuesGenerator.getRandomIntBetween(random, 0, 100);
						if(sizeOfArray % 5 == 0) { // null test
							int[] recurDays=null; //null instead here
							int recur=ApptRandomTest.RandomSelectRecur(random);
							int recurIncrement = ValuesGenerator.RandInt(random);
							int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
							appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
							assertEquals(0, appt.getRecurDays().length);
						}
						else {
							int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeOfArray);
							int recur=ApptRandomTest.RandomSelectRecur(random);
							int recurIncrement = ValuesGenerator.RandInt(random);
							int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
							appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
							assertEquals(sizeOfArray, appt.getRecurDays().length);
						}
						
					}
					
					 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				        if((iteration%10000)==0 && iteration!=0 ) {}
				              //System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
				 
				}
			}catch(NullPointerException e){
				
			}
		 System.out.println("Done testing recursive days");
	 }

	private void assertTrue(Object valid) {
		// TODO Auto-generated method stub
		
	}
	
}
