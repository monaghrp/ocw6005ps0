import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * RulesOf6005 represents some of the rules of 6.005 as described by the 
 * general information on Stellar. 
 * 
 * The course elements are described by the hasFeature function. 
 * 
 * The grade details are described by the computeGrade function.
 * 
 * The extension policy (slack days) are described by the extendDeadline function.
 */
public class RulesOf6005 {
	
	
	/**
	 * Tests if the string is one of the items in the Course Elements section. 
	 *  
	 * @param name - the element to be tested
	 * @return true if <name> appears in bold in Course Elements section. Ignores case (capitalization). 
	 * Example: "Lectures" and "lectures" will both return true.
	 */
	public static boolean hasFeature(String name){
		// TODO: Fill in this method, then remove the RuntimeException
        //throw new RuntimeException("hasFeature not implemented");
        String nameLowerCase = new String(name.toLowerCase());
        if (nameLowerCase.equals("lectures")) {
            return true;
        } else if (nameLowerCase.equals("recitations")) {
            return true;
        } else if (nameLowerCase.equals("text")) {
            return true;
        } else if (nameLowerCase.equals("problems sets")) {
            return true;
        } else if (nameLowerCase.equals("code review")) {
            return true;
        } else if (nameLowerCase.equals("returnin")) {
            return true;
        } else if (nameLowerCase.equals("projects")) {
            return true;
        } else if (nameLowerCase.equals("team meetings")) {
            return true;
        } else if (nameLowerCase.equals("quizzes")) {
            return true;
        } else {
            return false;
        }
	}
	
	
	/**
	 * Takes in the quiz, pset, project, and participation grades as values out of a 
	 * hundred and returns the grade based on the course information also as a value out 
	 * of a hundred, rounded to the nearest integer. 
	 * 
	 * Behavior is unspecified if the values are out of range.
	 * 
	 * @param quiz
	 * @param pset
	 * @param project
	 * @param participation
	 * @return the resulting grade out of a hundred
	 */
	public static int computeGrade(int quiz, int pset, int project, int participation){
		// TODO: Fill in this method, then remove the RuntimeException
        //throw new RuntimeException("computeGrade not implemented");
	    double dQuiz=(double)(quiz) * .2;
	    double dPset=(double)(pset) * .4;
	    double dProject=(double)(project) * .3;
	    double dPart=(double)(participation) * .1;
	            
	    return (int)(Math.round(dQuiz+dPset+dProject+dPart));
	}
	
	
	/**
	 * Based on the slack day policy, returns a date of when the assignment would be due, making sure not to
	 * exceed the budget. In the case of the request being more than what's allowed, the latest possible
	 * due date is returned. 
	 * 
	 * Hint: Take a look at http://download.oracle.com/javase/6/docs/api/java/util/GregorianCalendar.html
	 * 
	 * Behavior is unspecified if request is negative or duedate is null. 
	 * 
	 * @param request - the requested number of slack days to use
	 * @param budget - the total number of available slack days
	 * @param duedate - the original due date of the assignment
	 * @return a new instance of a Calendar with the date and time set to when the assignment will be due
	 */
	
	public static Calendar extendDeadline(int request, int budget, Calendar duedate){
		// TODO: Fill in this method, then remove the RuntimeException
        //throw new RuntimeException("extendDeadline not implemented");
	    if (request > budget) {
	        request=budget;
	    } else if (request> 3) {
	        request=3;
	    }
	    Calendar newDeadline = new GregorianCalendar();
	    newDeadline.clear();
	    newDeadline.set(duedate.get(Calendar.YEAR),
	                    duedate.get(Calendar.MONTH),
	                    duedate.get(Calendar.DATE),
	                    duedate.get(Calendar.HOUR),
	                    duedate.get(Calendar.MINUTE),
	                    duedate.get(Calendar.SECOND));  
	    newDeadline.add(Calendar.DATE, request);        
        return newDeadline;
        
	}
	
	
	/**
	 * Main method of the class. Runs the functions hasFeature, computeGrade, and 
	 * extendDeadline. 
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		System.out.println("Has feature QUIZZES: " + hasFeature("QUIZZES"));
		System.out.println("My grade is: " + computeGrade(60, 40, 50, 37));
		Calendar duedate = new GregorianCalendar();
		duedate.set(2011, 8, 9, 23, 59, 59);
		System.out.println("Original due date: " + duedate.getTime());
		System.out.println("New due date:" + extendDeadline(4, 2, duedate).getTime());
	}
}
