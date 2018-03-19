
package finalprojectB;

import java.util.Random;
import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   public void testManualTestAndrew()
   {
//You can use this function to implement your manual testing	 
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   
	   assertTrue(urlVal.isValid("http://www.google.com"));
	   assertTrue(urlVal.isValid("https://www.google.com"));
	   assertTrue(urlVal.isValid("https://www.github.com/Jollyan/CS362-001-W2018"));
	   assertTrue(urlVal.isValid("http://www.google.com/"));
	   
	   assertFalse(urlVal.isValid("https://www.google.com//"));
	   
	   assertTrue(urlVal.isValid("http://www.oregonstate.edu"));
	   
	   assertTrue(urlVal.isValid("https://www.mecopinc.org/students#afterApply"));
	   
	   assertFalse(urlVal.isValid(null));
	   
	   assertFalse(urlVal.isValid(""));
	   
	   assertFalse(urlVal.isValid("www.google.comwww.google.comwww.google.comwww.google.comwww.google.comwww.google.com"));
	   assertFalse(urlVal.isValid("http://www.google.comwww.google.comwww.google.comwww.google.comwww.google.comwww.google.com"));
	   
	   assertFalse(urlVal.isValid("1234")); //test random numbers
	   assertFalse(urlVal.isValid("www.1234541415851145341245157521541210545215153237113427141276541761567"
	   		+ "257.com")); //test big random numbers
	   
	   assertFalse(urlVal.isValid("place"));//test random string
	   assertFalse(urlVal.isValid("www.fbcjdsbhefudhkuhaijcjkbfvr8hehbywfuvnewgvbdeyev.com"));//test random string
	   
	   assertFalse(urlVal.isValid(".com"));//test just ending
	   assertFalse(urlVal.isValid("www."));//test just start   
   }
   
   public void testManualTestBrandon()
   {
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   assertTrue(urlVal.isValid("http://www.bing.com"));
	   assertFalse(urlVal.isValid(null));
	   assertFalse(urlVal.isValid("www.bing.com"));
	   assertFalse(urlVal.isValid("aaaa"));
	   assertTrue(urlVal.isValid("https://www.bing.com"));
	   
   }
   
   
   public void testScheme()
   {
	 UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	 assertTrue(urlVal.isValidScheme("http"));
	 assertTrue(urlVal.isValidScheme("https"));
	 assertTrue(urlVal.isValidScheme("ftp"));
	 assertTrue(urlVal.isValidScheme("aa"));
	 assertFalse(urlVal.isValidScheme(""));
	 assertFalse(urlVal.isValidScheme(null));
	 //testing Default values
	 UrlValidator urlValDefault = new UrlValidator();
	 assertTrue(urlValDefault.isValidScheme("http"));
	 assertTrue(urlValDefault.isValidScheme("https"));
	 assertTrue(urlValDefault.isValidScheme("ftp"));
	 assertFalse(urlValDefault.isValidScheme("aa"));
	 assertFalse(urlValDefault.isValidScheme(""));
	 
	 

   }
   
   public void testAuthority(){
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES); 
	   assertTrue(urlVal.isValidAuthority("www.bing.com"));
	   assertTrue(urlVal.isValidAuthority("www.facebook.com"));
	   assertFalse(urlVal.isValidAuthority(null));
	   assertFalse(urlVal.isValidAuthority("aaa"));

   }
   public void testPath(){
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   assertTrue(urlVal.isValidPath("/test1"));
	   assertTrue(urlVal.isValidPath("/test1/"));
	   assertFalse(urlVal.isValidPath(null));
	   assertFalse(urlVal.isValidPath("/../"));
	   assertFalse(urlVal.isValidPath("/.."));

   }
   public void testQuery(){
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   assertTrue(urlVal.isValidQuery(null));
	   assertTrue(urlVal.isValidQuery("?action=view"));

   }
   public void testFragment(){
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES); 
	   assertTrue(urlVal.isValidFragment(null));
	   assertTrue(urlVal.isValidFragment("!"));
   } 
   
   public static String RandomPartOfURL(Random random){
       String[] partArray = new String[] {"scheme", "authorization", "query", "port"};// tested in the IsValid Function without path for now
   	   int n = random.nextInt(partArray.length);   	            
       return partArray[n] ; // return the part name 
   }
   
   public static String RandomFalseScheme(Random random){
       String[] partArray = new String[] {"3ht://", "http:/", "http:", "http/", "://"};// false scheme
   	   int n = random.nextInt(partArray.length);   	            
       return partArray[n] ; // return the scheme 
   }
   
   public static String RandomTrueScheme(Random random){
       String[] partArray = new String[] {"http://", "ftp://", "h3t://", ""};// true scheme
   	   int n = random.nextInt(partArray.length);   	            
       return partArray[n] ; // return the scheme 
   }
   
   
   public static String RandomFalseAuthorization(Random random){
       String[] partArray = new String[] {"256.256.256.256","1.2.3.4.5","1.2.3.4.","1.2.3",".1.2.3.4","go.a",
    		  "go.a1a","go.1aa","aaa.",".aaa","aaa",""};// false authorization
   	   int n = random.nextInt(partArray.length);   	            
       return partArray[n] ; // return the authorization 
   }
   
   public static String RandomTrueAuthorization(Random random){
       String[] partArray = new String[] {"www.google.com","go.com","go.au","0.0.0.0","255.255.255.255", "255.com"};// true authorization
   	   int n = random.nextInt(partArray.length);   	            
       return partArray[n] ; // return the authorization 
   }
 
   
   public static String RandomTrueQuery(Random random){
       String[] partArray = new String[] {"?action=view", "?action=edit&mode=up", ""};// true Query
   	   int n = random.nextInt(partArray.length);   	            
       return partArray[n] ; // return the Query 
   }
   
   public static String RandomFalsePort(Random random){
       String[] partArray = new String[] {":-1",":65636",":65a"};// false Port
   	   int n = random.nextInt(partArray.length);   	            
       return partArray[n] ; // return the Port 
   }
   
   public static String RandomTruePort(Random random){
       String[] partArray = new String[] {":80",":65535",":0",""};// true Port
   	   int n = random.nextInt(partArray.length);   	            
       return partArray[n] ; // return the Port 
   }

   
   private static final int NUM_TESTS=5000;
   
   public void testIsValidRandom()
   {
	   //You can use this function for programming based testing
	   long randomseed =System.currentTimeMillis(); //10
	   Random random = new Random(randomseed);
	   String scheme = "http://";
	   String authorization = "www.google.com";
	   //String path = null; //may need to test without path variable
	   String query = null; //action tests
	   String port = null;
	   
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   //assertTrue(urlVal.isValid(""+scheme+authorization+path+query+fragment));
	   assertTrue(urlVal.isValid(""+scheme+authorization+port+query));
	   
	   //test each part for true value and false
	   for (int i = 0; i < NUM_TESTS; i++) {
			String methodName = UrlValidatorTest.RandomPartOfURL(random); //pull out which part to test 
			
			   if (methodName.equals("scheme")){
				   	if (random.nextInt() % 7 == 0) {
				   		scheme = null;
				   		assertFalse(urlVal.isValid(""+scheme+authorization+port+query));
				   	}
				   	else if(random.nextInt() % 3 == 0) { //false scheme
				   		scheme = UrlValidatorTest.RandomFalseScheme(random);
				   		assertFalse(urlVal.isValid(""+scheme+authorization+port+query));
				   	}
				   	else {
				   		scheme = UrlValidatorTest.RandomTrueScheme(random);
				   		assertTrue(urlVal.isValid(""+scheme+authorization+port+query));
				   	}
				   	scheme = UrlValidatorTest.RandomTrueScheme(random);
				}
			   else if (methodName.equals("authorization")){
				   if (random.nextInt() % 7 == 0) {
					   authorization = null;
				   		assertFalse(urlVal.isValid(""+scheme+authorization+port+query));
				   	}
				   	else if(random.nextInt() % 3 == 0) { //false scheme
				   		authorization = UrlValidatorTest.RandomFalseAuthorization(random);
				   		assertFalse(urlVal.isValid(""+scheme+authorization+port+query));
				   	}
				   	else {
				   		authorization = UrlValidatorTest.RandomTrueAuthorization(random);
				   		assertTrue(urlVal.isValid(""+scheme+authorization+port+query));
				   	}
				   authorization = UrlValidatorTest.RandomTrueAuthorization(random);
				}	
//			   else if (methodName.equals("path")){
//				   
//				}
			   else if (methodName.equals("query")){
				   if (random.nextInt() % 7 == 0) {
					   query = null;
				   		assertTrue(urlVal.isValid(""+scheme+authorization+port+query));
				   	}
				   	else {
				   		query = UrlValidatorTest.RandomTrueQuery(random);
				   		assertTrue(urlVal.isValid(""+scheme+authorization+port+query));
				   	}
				}
			   else if (methodName.equals("port")){
				   if (random.nextInt() % 7 == 0) {
					    port = UrlValidatorTest.RandomFalsePort(random);
				   		assertFalse(urlVal.isValid(""+scheme+authorization+port+query));
				   	}
				   	else {
				   		port = UrlValidatorTest.RandomTruePort(random);
				   		assertTrue(urlVal.isValid(""+scheme+authorization+port+query));
				   	}
				   port = null;
				}
		}
   }
   


}
