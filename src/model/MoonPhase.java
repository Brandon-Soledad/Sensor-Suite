// Jonathan Lee
// TCSS 360 A
// Project 2, Group 7

package model;

import java.time.LocalDate;

/**
 * Represents the moon phase feature of the console receiver.
 * 
 * @author Jonathan Lee
 * @version 20 July 2020
 *
 */
public class MoonPhase {
	
	/**
	 * Represents the current date of this year.
	 */
	private LocalDate myDate;
	
	/**
	 * Represents the current year.
	 */
	private int myYear;
	
	/**
	 * Represents the current month.
	 */
	private int myMonth;
	
	/**
	 * Represents the current day.
	 */
	private int myDay;
	
	/**
	 * Constructor used to retrieve the current date.
	 */
	public MoonPhase() {
		myDate = LocalDate.now();
		myYear = myDate.getYear();
		myMonth = myDate.getMonthValue();
		myDay = myDate.getDayOfMonth();
	}
	
	/**
	 * Used to calculate an estimation of the moon phase itself.
	 * 
	 * @return the number of days into the moon's cycle.
	 */
	public double getMoonPhase() {
		double daysSinceNew = julian() - 2451549.5;
		double newMoons = daysSinceNew / 29.53;
		int newM = (int) newMoons;
		double frac = newMoons - newM;
		double daysIntoCycle = frac * 29.53;
		return daysIntoCycle;
	}
	
	/**
	 * Helper method to calculate the Julian day numbers used for
	 * calculating the moon phase.
	 * 
	 * @return the Julian day number.
	 */
	private double julian() {
		int year = myYear;
		int month = myMonth;
		if (month == 1 || month == 2) {
			year--;
			month += 12;
		}
		double a = year / 100;
		double b = a / 4;
		double c = 2 - a + b;
		double e = 365.25 * (year + 4716);
		double f = 30.6001 * (month + 1);
		double JD = c + myDay + e + f - 1524.5;
		return JD;
	}

}
