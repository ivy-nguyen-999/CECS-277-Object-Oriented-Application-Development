package cecs277DemoVisitorPattern;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * The terms of agreement for renting a particular item from the DVD store.  The
 * Visitor patterns that I've seen all have the visitor return just one thing,
 * and I want to return two.  Not a problem if you're willing to construct an
 * object that contains both of those things, which is what the Agreement amounts
 * to.  Something that you won't get with those other Visitor examples.
 * @author	David Brown
 * @date	08/06/19
 */
public class Agreement {
	/** The rental rate */
	private double rate;
	/** When it is due back. */
	LocalDate dueDate;
	
	/**
	 * Constructor
	 * @param	rate	The amount of the rent if it is returned by the due date.
	 * @param	weeks	The number of weeks into the future for the due date.
	 * @param	days	The number of days (in addition to the weeks) into the 
	 * 					future for the due date.
	 */
	public Agreement (double rate, int weeks, int days) {
		this.rate = rate;
		//Get today's date
		LocalDate today = LocalDate.now();
		//Add the weeks (could be zero) and days to get the due date 
		this.dueDate = today.plus(weeks, ChronoUnit.WEEKS).plus(days,ChronoUnit.DAYS);
	}
	
	/**
	 * Retrieve the rental rate.
	 * @return	The rental rate in dollars and cents.
	 */
	public double getRate() {return this.rate;}
	
	/**
	 * Return the calculated due date.
	 * @return	The calculated due date.
	 */
	public LocalDate getDueDate() {return this.dueDate;}
	
	@Override
	public String toString () {
		return "Rate: " + this.getRate() + "Due on: " + this.getDueDate();
	}
}